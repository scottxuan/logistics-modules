package com.module.auth.api;

import com.module.auth.dto.LoginDto;
import com.module.auth.dto.LoginResult;
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
@RequestMapping("${api}/auth")
public interface AuthApi {
    /**
     * 系统用户账户密码登录
     * @param dto
     * @return
     */
    @ApiOperation("001--系统用户账户密码登录")
    @PostMapping("/login")
    ResultDto<LoginResult> login(@RequestBody @Validated LoginDto dto);

    /**
     * 系统用户小程序登录
     * @param code
     * @return
     */
    @ApiOperation("002--系统用户小程序登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "小程序登录code", dataType = "boolean", paramType = "query")
    })
    @GetMapping("/login/mini")
    ResultDto<LoginResult> miniLogin(@RequestParam String code);


    /**
     * 客户账户密码登录
     * @param dto
     * @return
     */
    @ApiOperation("003--客户账户密码登录")
    @PostMapping("/customer/login")
    ResultDto<LoginResult> customerLogin(@RequestBody @Validated LoginDto dto);

    /**
     * 客户小程序登录
     * @param code
     * @return
     */
    @ApiOperation("004--客户小程序登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "小程序登录code", dataType = "boolean", paramType = "query")
    })
    @GetMapping("/customer/login/mini")
    ResultDto<LoginResult> customerMiniLogin(@RequestParam String code);

    /**
     * accessToken过期检查
     * @param accessToken
     * @return
     */
    @ApiOperation("005--accessToken校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessToken", value = "refreshToken", dataType = "string", paramType = "query")
    })
    @GetMapping("/token/check")
    ResultDto<Boolean> checkAccessToken(@RequestParam String accessToken);

    /**
     * token刷新
     * @param refreshToken
     * @return
     */
    @ApiOperation("006--token刷新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "refreshToken", value = "refreshToken", dataType = "string", paramType = "query")
    })
    @GetMapping("/token/refresh")
    ResultDto<LoginResult> refreshToken(@RequestParam String refreshToken);
}
