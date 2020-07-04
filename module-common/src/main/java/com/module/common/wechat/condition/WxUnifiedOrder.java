package com.module.common.wechat.condition;

import lombok.Data;

/**
 * 统一下单
 * @author : zhaoxuan
 * @date : 2020/1/20
 */
@Data
public class WxUnifiedOrder {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String body;
    private String out_trade_no;
    private String total_fee;
    private String spbill_create_ip;
    private String notify_url;
    private String trade_type;
}
