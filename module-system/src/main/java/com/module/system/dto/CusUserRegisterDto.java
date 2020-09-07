package com.module.system.dto;

import com.scottxuan.web.validate.Mobile;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : pc
 * @date : 2020/9/4
 */
@Data
public class CusUserRegisterDto {
    @NotBlank
    @Mobile
    private String mobile;
    @NotBlank
    private String smsCode;
}
