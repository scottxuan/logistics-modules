package com.module.system.api;

import com.module.system.dto.CusUserRegisterDto;
import com.module.system.entity.CusUser;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : pc
 * @date : 2020/9/4
 */
public interface CusUserApi {
    String MAPPING = "${api}/customer/user";

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "001--根据id查询用户")
    @GetMapping("/id/{id}")
    ResultDto<CusUser> findById(@PathVariable Integer id);

    /**
     * 根据openId查询用户
     * @param openId
     * @return
     */
    @ApiOperation(value = "002--根据openId查询用户")
    @GetMapping("/openId/{openId}")
    ResultDto<CusUser> findByOpenId(@PathVariable Integer openId);

    /**
     * 根据account查询用户
     * @param account
     * @return
     */
    @ApiOperation(value = "003--根据account查询用户")
    @GetMapping("/account/{account}")
    ResultDto<CusUser> findByAccount(@PathVariable String account);

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @ApiOperation(value = "004--用户注册")
    @PostMapping("/register")
    ResultDto<Boolean> register(@RequestBody CusUserRegisterDto dto);
}
