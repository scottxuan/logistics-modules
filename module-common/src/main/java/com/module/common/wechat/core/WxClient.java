package com.module.common.wechat.core;

import com.module.common.error.ErrorCodes;
import com.module.common.http.HttpClient;
import com.module.common.http.HttpRequest;
import com.module.common.wechat.common.WxResponse;
import com.scottxuan.base.exception.ExceptionUtils;
import com.scottxuan.base.utils.JsonUtils;
import com.scottxuan.base.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WxClient {

    /**
     * 发送微信请求
     * @param httpRequest
     * @param <T>
     * @return
     */
    public static <T extends WxResponse> T request(HttpRequest<T> httpRequest) {
        log.info("wechat " + httpRequest.getUrl().toString() + " request" + httpRequest.getParameters());
        String result = HttpClient.request(httpRequest);
        log.info("wechat " + httpRequest.getUrl().toString() + " request" + result);
        T response = parseObject(result, httpRequest.getResponse());
        if (ObjectUtils.isEmpty(response) || !response.isSuccess()) {
            ExceptionUtils.throwException(ErrorCodes.WE_CHAT_ERROR,response.getErrMsg());
        }
        return response;
    }

    public static <T extends WxResponse> T parseObject(String request, Class<T> response) {
        T t = null;
        Object object = JsonUtils.parseObject(request, response);
        if (object instanceof WxResponse){
            t = (T)object;
        }
        return t;
    }
}
