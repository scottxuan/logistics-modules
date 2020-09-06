package com.module.common.http;

import com.scottxuan.base.utils.JsonUtils;
import com.scottxuan.core.http.HttpClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author scottxuan
 */
@Slf4j
public class HttpUtils {

    /**
     * 发送http请求
     *
     * @param httpRequest
     * @return
     */
    public static String request(HttpRequest httpRequest) {
        String result;
        switch (httpRequest.getUrl().method()) {
            case GET:
                result = HttpClient.get(httpRequest.getUrl().url());
                break;
            case POST:
                result = HttpClient.post(httpRequest.getUrl().url(), httpRequest.getParameters());
                break;
            default:
                result = "";
        }
        return result;
    }

    /**
     * json转map
     * @param parameters
     * @return
     */
    private static Map<String, String> getMap(String parameters){
        Map<String, String> map = null;
        Object object = JsonUtils.parseObject(parameters, Map.class);
        if (object instanceof Map){
            map = (Map<String, String>)object;
        }
        return map;
    }
}
