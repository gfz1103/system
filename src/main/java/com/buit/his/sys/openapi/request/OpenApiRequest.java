package com.buit.his.sys.openapi.request;

/**
 * @Author sunjx
 * @Date 2020-12-14 15:47
 * @Description
 **/
public class OpenApiRequest<T> {

    private String accessKey;
    private String accessSecret;
    private T data;
    private String nonce;
    private String sign;
    private Long timestamp;

    public OpenApiRequest(String accessKey, String accessSecret, T data, String nonce, String sign, Long timestamp) {
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.sign = sign;
        this.data = data;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
