package com.module.common.wechat.core;

import com.module.system.error.ErrorCodes;
import com.module.common.http.HttpClient;
import com.module.common.http.HttpRequest;
import com.module.common.wechat.common.WxResponse;
import com.scottxuan.base.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


@Slf4j
public class WxClient {

    /**
     * 发送微信请求
     * @param httpRequest
     * @param <T>
     * @return
     */
    public static <T extends WxResponse> T request(HttpRequest<T> httpRequest) {
        log.info("wechat " + httpRequest.getUrl().toString() + " request:" + httpRequest.getParameters());
        String result = HttpClient.request(httpRequest);
        log.info("wechat " + httpRequest.getUrl().toString() + " response:" + result);
        if (StringUtils.isBlank(result)) {
            result = "{\"errcode\":-1,\"errmsg\":[微信]系统超时!}";
        }
        return parseObject(result, httpRequest.getResponse());
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
