package com.module.common.wechat.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.module.common.wechat.common.WxResponse;
import lombok.Data;

@Data
public class WxCode2SessionResponse extends WxResponse {

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("unionid")
    private String unionId;
}
