package com.module.common.config;

import lombok.Data;

/**
 * @author scottxuan
 */
@Data
public class HostConfig {
    /**
     * 微信host
     */
    private String weChatHost = "";

    /**
     * 支付宝host
     */
    private String alipayHost = "";

    /**
     * 易宝host
     */
    private String yiBaoHost;
}
