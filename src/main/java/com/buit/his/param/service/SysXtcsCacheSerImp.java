package com.buit.his.param.service;

import com.buit.commons.BaseException;
import com.buit.his.param.dao.CfgJqtdcsDao;
import com.buit.his.param.dao.SysXtcsDao;
import com.buit.system.BUHISSystemArgument;
import com.buit.system.request.SystemParamReq;
import com.buit.system.response.SysXtcs;
import com.buit.system.service.SysXtcsCacheSer;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description SYS_XTCS 表缓存service
 * @Author yueyu
 * @Date 2020/5/11 15:57
 */
@DubboService(timeout = 10000)
public class SysXtcsCacheSerImp implements SysXtcsCacheSer {

    @Value("${buit.jgid}")
    private Integer jgid;

    @Autowired
    SysXtcsDao sysXtcsDao;

    @Autowired
    private CfgJqtdcsDao cfgJqtdcsDao;

    public Map<String, Object> getSystemParams(SystemParamReq systemParamReq, Integer hospitalId) {
//		log.info("查询系统参数[{},{}]", JSONUtil.toJsonStr(systemParamReq), JSONUtil.toJsonStr(user));
        Map<String, Object> result = new HashMap<>();
        List<String> csmcList = new ArrayList<>();
        if (systemParamReq.getCommons() != null) {
            csmcList.addAll(systemParamReq.getCommons());
        }
        if (systemParamReq.getPrivates() != null) {
            csmcList.addAll(systemParamReq.getPrivates());
        }
        if (!csmcList.isEmpty()) {
            csmcList.stream().forEach(k -> {
                SysXtcs value = this.getByJGIdAndCsmc(hospitalId, k);
                if (value != null) {
                    result.put(k, value.getCsz());
                }
            });
        }
//		if (systemParamReq.getPersonals() != null&&!systemParamReq.getPersonals().isEmpty()) {
//			EmrYsxgGrcs emrYsxgGrcs = emrYsxgGrcsDao.getByYhbh(user.getUserId());
//			if(emrYsxgGrcs!=null){
//				result.putAll(BeanUtil.beanToMap(emrYsxgGrcs));
//			}
//		}
        return result;
    }

    public SysXtcs getByJGIdAndCsmc(Integer jgId, String csmc) {
        SysXtcs sysXtcs = sysXtcsDao.findByJgIdAndCsmc(jgId, csmc);
        if (sysXtcs == null) {//取默认值 并保存数据库
            sysXtcs = new SysXtcs();
            String csz = BUHISSystemArgument.defaultValue.get(csmc);
            if (StringUtils.isEmpty(csz)) {
                csz = BUHISSystemArgument.defaultPubValue.get(csmc);
            }
            sysXtcs.setBz(BUHISSystemArgument.defaultAlias.get(csmc));
            sysXtcs.setSslb(BUHISSystemArgument.defaultCategory.get(csmc));
            sysXtcs.setCsz(csz);
            sysXtcs.setCsmc(csmc);
            sysXtcs.setJgid(jgId);
            sysXtcsDao.insert(sysXtcs);
        }
        return sysXtcs;
    }

    @Override
    public SysXtcs getByJGIdAndCsmcNoInsertDefault(Integer jgId, String csmc) {
        SysXtcs sysXtcs = sysXtcsDao.findByJgIdAndCsmc(jgId, csmc);
        return sysXtcs;
    }

    /**
     * 查询获得与这台计算机IP绑定的参数值
     *
     * @param req
     * @param ip
     * @param jgid
     * @return
     * @author wy
     */
    public Map<String, Object> doLoadThisComputerArgs(Map<String, Object> req, String ip, Integer jgid) {
        String nameStr = (String) req.get("names");
        String[] names = nameStr.split(",");
        Map<String, Object> args = new HashMap<String, Object>();
        String str = "";
        for (String name : names) {
            str += "'" + name + "',";
        }
        str = str.trim().replaceAll(",$", "");

        if (str.length() > 0) {
            List<Map<String, Object>> list = cfgJqtdcsDao.getByJgIdAndIpAndCsmcs(jgid, ip, str);

            for (Map<String, Object> item : list) {
                Object val = item.get("CSZ") != null ? item.get("CSZ") : "";
                args.put(item.get("CSM").toString(), val);
            }
        }
        return args;
    }

    /**
     * 直接获取系统参数值
     *
     * @param jgId
     * @param csmc
     * @return
     */
    public String getCsz(Integer jgId, String csmc) {
        SysXtcs sysXtcs = getByJGIdAndCsmc(jgId, csmc);
        if (sysXtcs == null) {
            throw BaseException.create("ERROR_SYS_PARAMETER_001", new String[]{csmc});
        } else if (sysXtcs.getCsz() == null) {
            throw BaseException.create("ERROR_SYS_PARAMETER_002", new String[]{csmc});
        }
        return sysXtcs.getCsz();
    }

    /**
     * 非his系统登录获取系统参数（自助机）
     *
     * @param csmc 参数名称
     * @return 参数值
     */
    @Override
    public String getHisSystemParam(String csmc) {
        return getCsz(jgid, csmc);
    }

    public void update(SysXtcs sysXtcs) {
        sysXtcsDao.update(sysXtcs);
    }

    public void delete(Integer jgId, String csmc) {
        sysXtcsDao.deleteByJGIdAndCsmc(jgId, csmc);
    }

    public void insert(SysXtcs sysXtcs) {
        sysXtcsDao.insert(sysXtcs);
    }
}
