package com.module.auth.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : pc
 * @date : 2020/8/4
 */
@Data
public class LoginResult {
    private Object userInfo;
    private String accessToken;
    private Date accessTokenExpireDate;
    private String refreshToken;
}
