package com.module.common.http;

/**
 * @author scottxuan
 */
public interface HttpRequest<T extends HttpResponse> {

    /**
     * 请求url
     * @return
     */
    HttpUrl getUrl();

    /**
     * 请求参数
     * @return
     */
    String getParameters();

    /**
     * 响应接收entity
     * @return
     */
    Class<T> getResponse();

}
