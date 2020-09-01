package com.module.system.api;

import com.module.system.entity.SysUser;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author : pc
 * @date : 2020/8/5
 */
public interface SysUserApi {
    String MAPPING = "${api}/system/user";
    /**
     * 根据账户查询用户
     * @param account
     * @return
     */
    @ApiOperation("001--根据账户查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/login")
    ResultDto<SysUser> findByAccount(@RequestParam String account);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @ApiOperation("002--根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "账户id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/{id}")
    ResultDto<SysUser> findById(@PathVariable Integer id);
}
