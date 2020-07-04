package com.module.common.http;


/**
 * @author scottxuan
 */
public enum HttpMethod{
    /**
     * GET请求
     */
    GET("GET"),

    /**
     * POST请求
     */
    POST("POST"),

    /**
     * PUT请求
     */
    PUT("PUT"),

    /**
     * DELETE请求
     */
    DELETE("DELETE");

    private String value;

    HttpMethod(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
