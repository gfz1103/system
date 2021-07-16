package com.buit.his.sys.openapi;

/**
 * @Author sunjx
 * @Date 2020-12-14 16:44
 * @Description
 **/
public enum  OpenApiErrorCode {
    ERROR_OPENAPI_0001("ERROR_OPENAPI_0001","参数格式不正确"),
    ERROR_OPENAPI_0002("ERROR_OPENAPI_0002","签名错误"),
    ERROR_OPENAPI_0003("ERROR_OPENAPI_0003","accessKey 或者 accessSecret 为空"),
    ERROR_OPENAPI_0004("ERROR_OPENAPI_0004","accessKey 或者 accessSecret 错误"),
    ERROR_OPENAPI_0005("ERROR_OPENAPI_0005","accessKey已禁用"),
    ERROR_OPENAPI_0006("ERROR_OPENAPI_0006","没有权限"),
    ERROR_OPENAPI_0007("ERROR_OPENAPI_0007","没有权限"),
    ERROR_OPENAPI_0008("ERROR_OPENAPI_0008","未知错误"),
    ERROR_OPENAPI_0009("ERROR_OPENAPI_0009","参数不能为空"),
    ERROR_OPENAPI_0010("ERROR_OPENAPI_0010","超时的请求"),
    ERROR_OPENAPI_0011("ERROR_OPENAPI_0011","重复请求"),
    ;

    OpenApiErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
