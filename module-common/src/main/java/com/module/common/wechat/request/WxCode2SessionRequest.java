package com.module.common.wechat.request;

import com.module.common.http.HttpRequest;
import com.module.common.wechat.common.WxUrlEnum;
import com.module.common.wechat.condition.WxCode2Session;
import com.module.common.wechat.response.WxCode2SessionResponse;
import com.scottxuan.base.utils.JsonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author scottxuan
 */
@Data
@AllArgsConstructor
public class WxCode2SessionRequest implements HttpRequest<WxCode2SessionResponse> {

    private WxCode2Session wxCode2Session;

    @Override
    public WxUrlEnum getUrl() {
        return WxUrlEnum.code2Session;
    }

    @Override
    public String getParameters() {
        return JsonUtils.toJsonString(wxCode2Session);
    }

    @Override
    public Class<WxCode2SessionResponse> getResponse() {
        return WxCode2SessionResponse.class;
    }
}
