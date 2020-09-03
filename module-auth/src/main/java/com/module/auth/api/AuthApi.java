package com.module.auth.api;

import com.module.auth.dto.LoginDto;
import com.module.auth.dto.LoginResult;
import com.module.auth.dto.TokenPair;
import com.module.system.constants.JwtConstant;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author : pc
 * @date : 2020/8/4
 */
public interface AuthApi {
    String MAPPING = "${api}/auth";
    /**
     * 系统用户账户密码登录
     * @param dto
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("001--系统用户账户密码登录")
    ResultDto<LoginResult> login(@RequestBody @Validated LoginDto dto);

    /**
     * 系统用户小程序登录
     * @param code
     * @return
     */
    @GetMapping("/login/mini")
    @ApiOperation("002--系统用户小程序登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "小程序登录code", dataType = "boolean", paramType = "query")
    })
    ResultDto<LoginResult> miniLogin(@RequestParam String code);


    /**
     * 客户账户密码登录
     * @param dto
     * @return
     */
    @PostMapping("/customer/login")
    @ApiOperation("003--客户账户密码登录")
    ResultDto<LoginResult> customerLogin(@RequestBody @Validated LoginDto dto);

    /**
     * 客户小程序登录
     * @param code
     * @return
     */
    @GetMapping("/customer/login/mini")
    @ApiOperation("004--客户小程序登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "小程序登录code", dataType = "boolean", paramType = "query")
    })
    ResultDto<LoginResult> customerMiniLogin(@RequestParam String code);

    /**
     * token刷新
     * @param accessToken
     * @param refreshToken
     * @return
     */
    @GetMapping("/token/refresh")
    @ApiOperation("006--token刷新")
    ResultDto<TokenPair> refreshToken(@RequestHeader(name = JwtConstant.ACCESS_TOKEN) String accessToken, @RequestHeader(name = JwtConstant.REFRESH_TOKEN) String refreshToken);
}
