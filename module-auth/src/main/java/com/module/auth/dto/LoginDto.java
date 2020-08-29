package com.module.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@Data
public class LoginDto {
    @NotBlank
    private String account;
    @NotBlank
    private String password;
}
