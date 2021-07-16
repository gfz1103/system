package com.buit.his.user.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.buit.commons.BaseException;
import com.buit.his.user.response.SysUserResp;
import com.buit.system.model.SysYwqxkz;
import com.buit.system.service.SysXtcsCacheSer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.config.LoginConfig;
import com.buit.constans.RedisKeyHead;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DicYljgDao;
import com.buit.his.user.dao.HrPersonnelDao;
import com.buit.his.user.dao.SysGroupDao;
import com.buit.his.user.dao.SysUserDao;
import com.buit.his.user.dao.SysUserResourceDao;
import com.buit.his.user.dao.SysYwqxkzDao;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.model.SysUserResource;
import com.buit.his.user.response.DicResp;
import com.buit.his.user.response.LoginResp;
import com.buit.system.model.SysYwqxkz;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 系统用户表<br>
 * @author All
 */
@Service
public class SysUserSer extends BaseManagerImp<SysUser, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SysUserSer.class);

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysGroupDao sysGroupDao;
	@Autowired
	private SysYwqxkzDao sysYwqxkzDao;
	@Autowired
	private DicYljgDao dicYljgDao;
	@Autowired
	private LoginConfig loginConfig;
	@Autowired
	private RedisFactory redisFactory;
	@Autowired
	private SysUserResourceDao sysUserResourceDao;
	@Autowired
	private HrPersonnelDao hrPersonnelDao;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private SysXtcsCacheSer sysXtcsCacheSer;
	/**
	 * 该时间内连续输入密码错误多次锁定用户 单位为分钟，不可为小数
	 */
//	int loginErrorTime1=60;
	/**
	 * 用户登录次数过多导致锁定后，等待该时间后自动解锁 单位为分钟，不可为小数 默认24小时
	 */
	int loginRecoveryTime=24*60;
	/**
	 * 一定时间内输入密码错误达到该次数后锁定用户 不可为小数
	 */
//	int loginErrorNumber1=10;
	/**
	 * 60min
	 */
//	private long tokenExpireTime = 1000 * 60 * 60;
	/**
	 * 60min
	 */
//	private long refreshTokenExpireTime = 1000 * 60 * 60;
	private String secretKey = "abcdef";
	
	@Override
	public SysUserDao getEntityMapper() {
		return sysUserDao;
	}
	/**
	 * 密码重置
	 */
	@Transactional(rollbackFor=Exception.class)
	public ReturnEntity<SysUser> add(SysUser sysUser) {
		List<SysUser> queList = sysUserDao.loginQuery(sysUser.getLoginName());
		if (queList.size() > 0) {
			return ReturnEntityUtil.error("ERROR_USER_0007");
		} 
		sysUser.setUserPwd(sysUser.getLoginName());
		sysUser.setUserId(sysUser.getPersonId());
		sysUser.setGmtCreate(new Timestamp(System.currentTimeMillis()));
		Digester md5 = new Digester(DigestAlgorithm.MD5); 
		md5.setSalt(sysUser.getLoginName().getBytes());
		String md5passwd = md5.digestHex(sysUser.getUserPwd());
		sysUser.setUserPwd(md5passwd);
		ChineseCharacterUtil.setPyAndWb(sysUser,sysUser.getUserName());
		//默认一年后过期..可能需要参数配置
		sysUser.setEndDate(new Timestamp(DateUtil.offset(DateUtil.date(), DateField.YEAR, 1).getTime()));
		sysUser.setLastChangePwdTime(DateUtil.date().toTimestamp());
		sysUserDao.insert(sysUser);
		SysUserResource res =new SysUserResource();
		res.setGmtCreate(DateUtil.date().toTimestamp());
    	res.setHospitalId(sysUser.getHospitalId());
    	res.setResourceId( 1);
    	res.setResourceType("0");
    	res.setUserId(sysUser.getUserId());
		// res.setUserresId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_USER_RESOURCE));
		sysUserResourceDao.insert(res);
		return ReturnEntityUtil.success(sysUser);
	}
	
	/**
	 * 修改密码
	 */
	public ReturnEntity<String> updatePasswd(Integer userId,String oldPwd,String newPwd) {
		SysUser sysUser=sysUserDao.getPwd(userId);
		Digester md5 = new Digester(DigestAlgorithm.MD5); 
		md5.setSalt(sysUser.getLoginName().getBytes());
		String md5OldPasswd = md5.digestHex(oldPwd);
		if(!md5OldPasswd.equals(sysUser.getUserPwd())) {
			return ReturnEntityUtil.error("ERROR_USER_0005");
		}
		sysUser.setLastChangePwdTime(DateUtil.date().toTimestamp());
		sysUser.setUserPwd(md5.digestHex(newPwd));
		sysUser.setChangPasswd(2);
		sysUserDao.update(sysUser);
		return ReturnEntityUtil.success();
	}
	/**
	 * 密码重置
	 */
	public void updatePasswd(Integer userId,String loginName) {
		SysUser sysUser=new SysUser();
		sysUser.setUserId(userId);
		Digester md5 = new Digester(DigestAlgorithm.MD5); 
		md5.setSalt(loginName.getBytes());
		sysUser.setChangPasswd(1);
		sysUser.setLastChangePwdTime(DateUtil.date().toTimestamp());
		sysUser.setUserPwd(md5.digestHex(loginName));
		sysUserDao.update(sysUser);
	}
	/**
	 * 判断是否需要修改密码
	 */
	public Boolean checkChangePwdTime(SysUser sysUser){
		String qyxgmm = sysXtcsCacheSer.getCsz(sysUser.getHospitalId(), "QYXGMM");
		String xgmmts = sysXtcsCacheSer.getCsz(sysUser.getHospitalId(), "XGMMTS");
		if("1".equals(qyxgmm)){
			SysUser user = sysUserDao.getById(sysUser.getUserId());
			return DateUtil.offset(user.getLastChangePwdTime(), DateField.DAY_OF_MONTH, Integer.parseInt(xgmmts)).isBefore(DateUtil.date());
		}
		return false;
	}
	
	/**
	 * 登录验证用名和密码
	 */
	public ReturnEntity<LoginResp> login(String loginName,String userPwd) {
//		logger.debug("死机-----开始 登录");
		SysUser que = null;
		String loginRecoveryTimeKey = RedisKeyHead.loginRecoveryTime.getHeadKey() + loginName;
		// 先判断锁定
		if (redisTemplate.hasKey(loginRecoveryTimeKey)) {
			return ReturnEntityUtil.error("ERROR_USER_0001");
		}
//		logger.debug("死机-----判断loginRecoveryTimeKey");
		List<SysUser> queList = sysUserDao.loginQuery(loginName);
		if (queList.size() > 0) {
			que = queList.get(0);
		} else {
			return ReturnEntityUtil.error("ERROR_USER_0002");
		}
//		logger.debug("死机-----sysUserDao.loginQuery 结束");
		if (que.getEndDate() != null && que.getEndDate().before(new Date())) {
			return ReturnEntityUtil.error("ERROR_USER_0003");
		}
		String lock="1";
		if (lock.equals(que.getLockFlag())) {
			return ReturnEntityUtil.error("ERROR_USER_0006");
		}
//
//		if ("".equals(userPwd) || userPwd == null) {
//			LoginResp loginResp = new LoginResp();
//			loginResp.setSysuser(que);
//			return ReturnEntityUtil.success(loginResp);
//		}
		//MD5解密
	/*	byte[] decoded = Base64.getDecoder().decode(userPwd);
		String decodeStr = new String(decoded);
		System.out.println("Base 64 解密后：" + decodeStr);*/
		// AES解密
		String loginErrorTimeKey = RedisKeyHead.loginErrorTime.getHeadKey() + loginName;
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		md5.setSalt(que.getLoginName().getBytes());
		String md5passwd = md5.digestHex(userPwd);
		logger.info("密码应该是===="+md5passwd);
		// 密码验证不通过
		if (!md5passwd.equals(que.getUserPwd())) {

			long times = redisFactory.increment(loginErrorTimeKey, 1);
			if (times == 1) {
				redisFactory.setExpire(loginErrorTimeKey, Long.valueOf(loginConfig.getErrorTime()));
			}
			if (times >=loginConfig.getErrorNumber()) {
				redisFactory.setKey(loginRecoveryTimeKey, times);
				redisFactory.setExpire(loginRecoveryTimeKey, Long.valueOf(loginConfig.getLockTime()));
				//超过十次设置为锁定状态
				que.setLoginErrorFlag(0);
				que.setGmtModify(DateUtil.date().toTimestamp());
				sysUserDao.updateLoginErrorFlag(que);
			}
			return ReturnEntityUtil.error("ERROR_USER_0004");
		}
//		logger.debug("死机-----sysUserDao.loginQuery 密码验证结束");
		redisFactory.delete(loginErrorTimeKey);
		que.setUserPwd(null);
		que.setHospitalName(dicYljgDao.getById(que.getHospitalId()).getHospitalName());

		// 密码验证过
		// 生成JWT
		String token = buildJwt(que.getUserId(),que.getUserName());
		// 保存refreshToken至redis，使用hash结构保存使用中的token以及用户标识
		String refreshTokenKey = String.format("JWT_TOKEN::%s", token);
		logger.info("token失效时间:"+loginConfig.getTokenInvalidTime());
		redisFactory.setKey(refreshTokenKey, que, Long.valueOf(loginConfig.getTokenInvalidTime()));
		LoginResp loginResp = new LoginResp();
		loginResp.setToken(token);
		loginResp.setHospitas(sysUserResourceDao.getHospitaDic(que.getUserId()));
		loginResp.setSysuser(que);
		// 登录成功后 修改登录次数
		que.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		sysUserDao.addLoginCount(que);
//		logger.debug("死机-----更新登录次数结束");
		return ReturnEntityUtil.success(loginResp);
	}
	
	private String buildJwt(Integer userId,String userName){
		//生成jwt
		Date now = new Date();
		Algorithm algo = Algorithm.HMAC256(secretKey);
		String token = JWT.create()
				.withIssuer("MING")
				.withIssuedAt(now)
				//保存身份标识
				.withClaim("userId", userId)
				.withClaim("userName", userName)
				.sign(algo);
		return token;
	}
	
	/**
	 * 更新session中用户信息 
	 */
	public SysUser updataSession(SysUser sysUser) {
        String token = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        logger.info("token是----"+token);
        String refreshTokenKey = String.format("JWT_TOKEN::%s", token);
		logger.info("token失效时间:"+loginConfig.getTokenInvalidTime());
        redisFactory.setKey(refreshTokenKey, sysUser, Long.valueOf(loginConfig.getTokenInvalidTime()));
        return sysUser;
    }
	
	/**
	 * 更新session中用户信息 
	 */
	public void loginOut() {
        String token = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
        String refreshTokenKey = String.format("JWT_TOKEN::%s", token);		
        redisFactory.delete(refreshTokenKey);
    }
	
	
	/**
	 * 根据登录名返回用户信息
	 */
	public ReturnEntity<SysUser> loginGetUser(String loginName) {
		SysUser que = null;
		String loginRecoveryTimeKey=RedisKeyHead.loginRecoveryTime.getHeadKey()+loginName;
		//先判断锁定 
		if(redisTemplate.hasKey(loginRecoveryTimeKey) ){
			return ReturnEntityUtil.error("ERROR_USER_0001");
		}
		List<SysUser> queList = sysUserDao.loginQuery(loginName);
		if (queList.size() > 0) {
			que = queList.get(0);
		} else {
			return ReturnEntityUtil.error("ERROR_USER_0002");
		}
		return ReturnEntityUtil.success(que);
	}
	public static void main(String[] args) {
//		Digester md5 = new Digester(DigestAlgorithm.MD5);
//		md5.setSalt("admin".getBytes());
//		String md5passwd = md5.digestHex("123");
//		System.out.println(md5passwd);
//		Date now = new Date();
//		Algorithm algo = Algorithm.HMAC256( "abcdef");
//		String token = JWT.create()
//				.withIssuer("MING")
//				.withIssuedAt(now)
//				//保存身份标识
//				.withClaim("userId", 1)
//				.withClaim("userName", "文光临")
//				.sign(algo);
//		System.out.println(token);
	
	}
	/**
	 * 分页查询
	 */
	public PageInfo<SysUser> page(SysUser user, String userName, PageQuery page) {
		SysUser sysuser=new SysUser ();
		sysuser.setUserName(userName);
		sysuser.setHospitalId(user.getHospitalId());
		setSortColumns(sysuser);
		PageInfo<SysUser> pageInfo = PageHelper.startPage(
				page.getPageNum(), page.getPageSize()).doSelectPageInfo(
				() -> sysUserDao.findByEntity(sysuser)
		);
		getEmpNo(pageInfo);
		return pageInfo;
	}


	private void getEmpNo(PageInfo<SysUser> pageInfo){
    	pageInfo.getList().forEach(item ->{
			HrPersonnel personal = hrPersonnelDao.getById(item.getPersonId());
			item.setEmpNo(personal == null? null:personal.getRybh());
		});
	}

	/**
	 * 获取岗位用户列表字典
	 * @param sysuser
	 * @return
	 */
    public List<DicResp> findGroupUserDic(SysUser sysuser) {
    	return sysUserDao.findGroupUserDic(sysuser);
    }
    /**
	 * 更新用户默认权限,切换业务权限时调用
	 */
    @Transactional(rollbackFor=Exception.class)
	public void changeBid(SysUser sysUser,Integer groupId,Integer ksdm) {
		SysYwqxkz sysYwqxkz =new SysYwqxkz();
		sysYwqxkz.setMrbz(0);
		sysYwqxkz.setYgdm(sysUser.getUserId());
		sysYwqxkz.setYwlb(sysGroupDao.getById(groupId).getBtId());
		sysYwqxkz.setJgid(sysUser.getHospitalId());
		sysYwqxkzDao.update(sysYwqxkz);
		sysYwqxkz.setKsdm(ksdm);
		sysYwqxkz.setMrbz(1);
		sysYwqxkzDao.update(sysYwqxkz);
    }

	/**
	 * 验证密码是否正确
	 * @param loginName
	 * @param userPwd
	 * @return
	 */
	public boolean checkPwd(String loginName,String userPwd) {
		SysUser user = null;
		List<SysUser> list = sysUserDao.loginQuery(loginName);
		if (list.size() > 0) {
			user = list.get(0);
		} else {
			throw BaseException.create("ERROR_USER_0002");
		}
		// AES解密
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		md5.setSalt(user.getLoginName().getBytes());
		String md5passwd = md5.digestHex(userPwd);
		// 密码验证不通过
		if (!md5passwd.equals(user.getUserPwd())) {
			throw BaseException.create("ERROR_USER_0004");
		}
		return true;
	}

	/**
	 * 查询密码登录错误超过十次锁定的用户
	 * @param hospitalId
	 * @param userName
	 * @return
	 */
	public List<SysUserResp> errorUser(Integer hospitalId, String userName) {
		List<SysUserResp> sysUsers = sysUserDao.errorUser(hospitalId,userName);
		List<SysUserResp> list = new ArrayList<>();
		for (SysUserResp sysUser : sysUsers) {
			String loginErrorTimeKey = RedisKeyHead.loginErrorTime.getHeadKey() + sysUser.getLoginName().toUpperCase();
			Integer value = redisFactory.getValue(loginErrorTimeKey, Integer.class);
			//redis缓存中的key没有失效并且次数大于等于10的是锁定的用户
			if (value != null && value >= 10) {
				HrPersonnel personal = hrPersonnelDao.getById(sysUser.getPersonId());
				sysUser.setEmpNo(personal == null? null:personal.getRybh());
				list.add(sysUser);
			}
		}
		return list;
	}

	/**
	 * 解锁密码登录错误超过十次锁定的用户
	 * @param userId
	 */
	public void unLockRrrorUser(Integer userId) {
		SysUser byId = sysUserDao.getById(userId);
		if (byId != null) {
			//状态1 解除锁定
			byId.setLoginErrorFlag(1);
			byId.setGmtModify(DateUtil.date().toTimestamp());
			String loginErrorTimeKey = RedisKeyHead.loginErrorTime.getHeadKey() + byId.getLoginName().toUpperCase();
			String loginRecoveryTimeKey = RedisKeyHead.loginRecoveryTime.getHeadKey() + byId.getLoginName().toUpperCase();
			//删除redis中的键值
			redisFactory.delete(loginErrorTimeKey);
			redisFactory.delete(loginRecoveryTimeKey);
			sysUserDao.updateLoginErrorFlag(byId);
		}

	}
}
