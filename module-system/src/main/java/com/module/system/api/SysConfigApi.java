package com.module.system.api;

import com.module.system.entity.SysUser;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@RequestMapping("${api}/system/config")
public interface SysConfigApi {
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
}