package com.module.common.wechat.condition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WxCode2Session {

    @JsonProperty("appid")
    private String appId;

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("js_code")
    private String jsCode;

    @JsonProperty("grant_type")
    private String grantType="authorization_code";

    public WxCode2Session(String appId,String secret,String jsCode){
        this.appId = appId;
        this.secret=secret;
        this.jsCode = jsCode;
    }
}
