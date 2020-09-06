package com.module.common.runner;

import com.module.common.config.ConfigManager;
import com.module.common.config.HostConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author scottxuan
 */
@Component
@Slf4j
public class ApplicationHostInit implements CommandLineRunner {

    @Value("${we.chat.host:https://api.weixin.qq.com}")
    private String weChatHost;

    @Value("${alipay.host:}")
    private String alipayHost;

    @Value("${yi.bao.host:}")
    private String yiBaoHost;

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationHostInit -- run -- start");
        HostConfig hostConfig = new HostConfig();
        hostConfig.setWeChatHost(weChatHost);
        hostConfig.setAlipayHost(alipayHost);
        hostConfig.setYiBaoHost(yiBaoHost);
        ConfigManager.setConfig(hostConfig);
        log.info("ApplicationHostInit -- run -- end");
    }
}
