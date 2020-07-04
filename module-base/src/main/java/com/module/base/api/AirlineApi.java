package com.module.base.api;

import com.module.base.entity.Airline;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author : pc
 * @date : 2020/7/3
 */
@RequestMapping("${api}/airline")
public interface AirlineApi {

    /**
     * 航空公司查询(分页)
     *
     * @param query
     * @param pageIndex
     * @param pageSize
     * @param sort
     * @param asc
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("001--航空公司查询(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "搜索关键字(名称,二字码)", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", defaultValue = "1", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", defaultValue = "10", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", defaultValue = "ordinal", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "asc", value = "排序 true升序,false倒序", defaultValue = "true", dataType = "Boolean", paramType = "query")
    })
    ResultDto<List<Airline>> findListPage(@RequestParam(required = false) String query,
                                          @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false, defaultValue = "ordinal") String sort,
                                          @RequestParam(required = false, defaultValue = "true") Boolean asc);
}
