package com.module.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author : pc
 * @date : 2020/8/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenPair {
    @NotBlank
    private String accessToken;
    @NotBlank
    private String refreshToken;
    private Date accessTokenExpireDate;
}
