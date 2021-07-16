package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典项返回参数
 * zhouhaisheng
 */
@ApiModel(value ="字典项返回参数" )
public class DicResp {
 @ApiModelProperty("字典id")
 private String dicId;
 @ApiModelProperty("字典值")
 private String dicName;

 public String getDicId() {
  return dicId;
 }

 public void setDicId(String dicId) {
  this.dicId = dicId;
 }

 public String getDicName() {
  return dicName;
 }

 public void setDicName(String dicName) {
  this.dicName = dicName;
 }
}
