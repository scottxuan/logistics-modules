package com.module.system.api;

import com.module.system.entity.SysConfigGroup;
import com.module.system.entity.SysUser;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@RequestMapping("${api}/system/group/config")
public interface SysConfigGroupApi {
    /**
     * 根据账户查询用户
     * @param code
     * @return
     */
    @ApiOperation("001--根据code查询")
    @GetMapping("/{code}")
    ResultDto<SysConfigGroup> findByCode(@PathVariable String code);

    /**
     * 根据账户查询用户
     * @return
     */
    @ApiOperation("002--查询列表")
    @GetMapping
    ResultDto<List<SysConfigGroup>> findAll();
}
