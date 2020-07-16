package com.module.common.wechat.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.module.common.http.HttpResponse;
import lombok.Data;

@Data
public class WxResponse extends HttpResponse {

    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;

    @Override
    public boolean isSuccess() {
        if (this.errCode == null || this.errCode == 0) {
            return true;
        }
        return false;
    }
}
