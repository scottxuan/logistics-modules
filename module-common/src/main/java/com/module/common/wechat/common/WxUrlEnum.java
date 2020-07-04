package com.module.common.wechat.common;

import com.module.common.http.HttpMethod;
import com.module.common.http.HttpUrl;

public enum WxUrlEnum implements HttpUrl {
    //小程序登录
    code2Session(HttpMethod.GET,"https://api.weixin.qq.com/sns/jscode2session"),
    //统一下单
    order_unified(HttpMethod.POST,"https://api.mch.weixin.qq.com/pay/unifiedorder"),
    //订单查询
    order_query(HttpMethod.POST,"https://api.mch.weixin.qq.com/pay/orderquery"),
    //关闭订单
    order_close(HttpMethod.POST,"https://api.mch.weixin.qq.com/pay/closeorder"),
    //申请退款
    order_refund(HttpMethod.POST,"https://api.mch.weixin.qq.com/secapi/pay/refund"),
    //查询退款
    order_refund_query(HttpMethod.POST,"https://api.mch.weixin.qq.com/secapi/pay/refund"),
    //下载对账单
    download_bill(HttpMethod.POST,"https://api.mch.weixin.qq.com/pay/downloadbill"),
    ;

    private HttpMethod method;
    private String url;

    WxUrlEnum(HttpMethod method, String url){
        this.method = method;
        this.url = url;
    }

    @Override
    public HttpMethod method(){
        return this.method;
    }

    @Override
    public String url(){
        return this.url;
    }

}
