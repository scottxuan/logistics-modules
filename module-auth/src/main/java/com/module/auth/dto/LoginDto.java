package com.module.auth.dto;

import lombok.Data;

/**
 * @author : pc
 * @date : 2020/8/4
 */
@Data
public class LoginDto {
    private Object userInfo;
    private String accessToken;
    private String refreshToken;
}
