package com.module.base.api;

import com.module.base.entity.Area;
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
 * @date : 2020/7/2
 */
public interface AreaApi {
    String MAPPING = "${api}/area";

    /**
     * 国家查询(分页)
     * @param pageIndex
     * @param pageSize
     * @param sort
     * @param asc
     * @return
     */
    @GetMapping("/country_page")
    @ApiOperation("001--国家查询(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", defaultValue = "1", example = "1",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", defaultValue = "10", example = "10",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", defaultValue = "ordinal", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "asc", value = "排序 true升序,false倒序", defaultValue = "true", example = "true", dataType = "boolean", paramType = "query")
    })
    ResultDto<List<Area>> country(@RequestParam(required = false,defaultValue = "1") int pageIndex,
                                  @RequestParam(required = false,defaultValue = "10") int pageSize,
                                  @RequestParam(required = false,defaultValue = "ordinal") String sort,
                                  @RequestParam(required = false,defaultValue = "true") boolean asc);

    /**
     * 国家查询
     * @return
     */
    @GetMapping("/country")
    @ApiOperation("002--国家查询")
    ResultDto<List<Area>> country();

    /**
     * 根据code查询下级地区
     * @param parentCode
     * @param pageIndex
     * @param pageSize
     * @param sort
     * @param asc
     * @return
     */
    @GetMapping("/parent_page")
    @ApiOperation("003--下级区域查询(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", defaultValue = "1", example = "1",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", defaultValue = "10", example = "10",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序字段", defaultValue = "ordinal", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "asc", value = "排序 true升序,false倒序", defaultValue = "true", example = "true",dataType = "boolean", paramType = "query")
    })
    ResultDto<List<Area>> findByParent(@RequestParam(required = false) String parentCode,
                                       @RequestParam(required = false,defaultValue = "1") int pageIndex,
                                       @RequestParam(required = false,defaultValue = "10") int pageSize,
                                       @RequestParam(required = false,defaultValue = "ordinal") String sort,
                                       @RequestParam(required = false,defaultValue = "true") boolean asc);

    /**
     * 下级区域查询
     * @param parentCode
     * @return
     */
    @GetMapping("/parent")
    @ApiOperation("004--下级区域查询")
    ResultDto<List<Area>> findByParent(@RequestParam(required = false) String parentCode);

    /**
     * 根据code查询
     * @param code
     * @return
     */
    @GetMapping("/code/{code}")
    @ApiOperation("005--根据code查询")
    ResultDto<Area> findByCode(@PathVariable String code);
}
