package com.crecc.sale.web.dto;

/**
 * Created by xiyuanbupt on 2018/11/28.
 */
public class ErrorInfo<T>{
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;

    public ErrorInfo() {
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
