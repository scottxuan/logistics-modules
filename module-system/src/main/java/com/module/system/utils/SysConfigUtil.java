package com.module.system.utils;

import com.google.common.collect.Lists;
import com.module.system.client.SysConfigClient;
import com.module.system.dto.SysConfigDto;
import com.module.system.enums.SysConfigTypeEnum;
import com.scottxuan.web.result.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author : pc
 * @date : 2020/8/19
 */
@Component
public class SysConfigUtil {
    private static SysConfigUtil sysConfigUtil;

    @Autowired
    private SysConfigClient sysConfigClient;

    @PostConstruct
    public void init() {
        sysConfigUtil = this;
    }

    public static String findTextByCode(String code){
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.TEXT.type == configDto.getType()){
                return configDto.getValue();
            }
        }
        return null;
    }

    public static String findSingleByCode(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.SINGLE.type == configDto.getType()){
                return configDto.getValue();
            }
        }
        return null;
    }

    public static List<String> findMultipleByCode(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.MULTIPLE.type == configDto.getType()){
                return configDto.getSelectValueList();
            }
        }
        return Lists.newArrayList();
    }

    public static Boolean findBooleanByCode(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.BOOLEAN.type == configDto.getType()){
                return "1".equals(configDto.getValue());
            }
        }
        return Boolean.FALSE;
    }
}
