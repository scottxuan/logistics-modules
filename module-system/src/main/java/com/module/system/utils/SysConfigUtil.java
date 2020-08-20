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
import java.util.stream.Collectors;

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

    /**
     * 获取文本
     * @param code
     * @return
     */
    public static String getText(String code){
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.TEXT.type == configDto.getType()){
                return configDto.getValue();
            }
        }
        return null;
    }

    /**
     * 获取单选code值
     * @param code
     * @return
     */
    public static String getSingle(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.SINGLE.type == configDto.getType()){
                return configDto.getValue();
            }
        }
        return null;
    }

    /**
     * 获取单选code值得Integer类型
     * @param code
     * @return
     */
    public static Integer getSingleInt(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.SINGLE.type == configDto.getType()){
                return Integer.parseInt(configDto.getValue());
            }
        }
        return null;
    }

    /**
     * 获取多选code集合
     * @param code
     * @return
     */
    public static List<String> getMultiple(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.MULTIPLE.type == configDto.getType()){
                return configDto.getSelectValueList();
            }
        }
        return Lists.newArrayList();
    }

    /**
     * 获取多选code Integer集合
     * @param code
     * @return
     */
    public static List<Integer> getMultipleInt(String code) {
        ResultDto<SysConfigDto> resultDto = sysConfigUtil.sysConfigClient.findByCode(code);
        if (resultDto.isPresent()) {
            SysConfigDto configDto = resultDto.get();
            if (SysConfigTypeEnum.MULTIPLE.type == configDto.getType()){
                return configDto.getSelectValueList().stream().map(Integer::parseInt).collect(Collectors.toList());
            }
        }
        return Lists.newArrayList();
    }

    /**
     * 获取开关是否打开
     * @param code
     * @return
     */
    public static Boolean getIsOpen(String code) {
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
