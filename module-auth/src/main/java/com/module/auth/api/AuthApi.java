package com.module.auth.api;

import com.module.auth.dto.LoginDto;
import com.module.auth.dto.LoginResult;
import com.module.auth.dto.TokenPair;
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
     * accessToken过期检查
     * @param accessToken
     * @return
     */
    @GetMapping("/token/check")
    @ApiOperation("005--accessToken校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "refreshToken", dataType = "string", paramType = "query")
    })
    ResultDto<Boolean> checkAccessToken(@RequestParam String accessToken);

    /**
     * token刷新
     * @param tokenPair
     * @return
     */
    @PostMapping("/token/refresh")
    @ApiOperation("006--token刷新")
    ResultDto<TokenPair> refreshToken(@RequestBody @Validated TokenPair tokenPair);
}
