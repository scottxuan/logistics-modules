package com.module.auth.api;

import com.module.auth.dto.LoginDto;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : pc
 * @date : 2020/8/4
 */
@RequestMapping("${api}/auth")
public interface AuthApi {
    /**
     * 系统用户账户密码登录
     * @param account
     * @param password
     * @return
     */
    @ApiOperation("001--系统用户账户密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "boolean", paramType = "query")
    })
    @GetMapping("/login")
    ResultDto<LoginDto> login(@RequestParam String account, @RequestParam String password);

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
    ResultDto<LoginDto> miniLogin(@RequestParam String code);


    /**
     * 客户账户密码登录
     * @param account
     * @param password
     * @return
     */
    @ApiOperation("003--客户账户密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "boolean", paramType = "query")
    })
    @GetMapping("/customer/login")
    ResultDto<LoginDto> customerLogin(@RequestParam String account, @RequestParam String password);

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
    ResultDto<LoginDto> customerMiniLogin(@RequestParam String code);
}
