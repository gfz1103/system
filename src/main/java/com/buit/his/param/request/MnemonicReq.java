package com.buit.his.param.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.buit.his.param.enums.MnemonicTypeEnum;

import io.swagger.annotations.ApiModel;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/20 16:25
 */
@ApiModel("MnemonicReq")
public class MnemonicReq {
    @Valid
    @NotEmpty
    private List<MnemonicTypeEnum> typeList;
    @NotBlank
    private String value;

    public List<MnemonicTypeEnum> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<MnemonicTypeEnum> typeList) {
        this.typeList = typeList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
