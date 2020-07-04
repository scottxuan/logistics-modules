package com.module.common.http;

import lombok.Data;

/**
 * @author scottxuan
 */
@Data
public abstract class HttpResponse {
    /**
     * 是否请求成功
     * @return
     */
    public abstract boolean isSuccess();
}
