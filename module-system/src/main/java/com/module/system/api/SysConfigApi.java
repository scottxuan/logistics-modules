package com.module.system.api;

import com.module.system.dto.SysConfigDto;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : pc
 * @date : 2020/8/5
 */
public interface SysConfigApi {
    String MAPPING = "${api}/system/config";
    /**
     * 根据groupCode查询
     * @param groupCode
     * @return
     */
    @ApiOperation("001--根据groupCode查询")
    @GetMapping("/groupCode/{groupCode}")
    ResultDto<List<SysConfigDto>> findByGroupCode(@PathVariable String groupCode);

    /**
     * 根据code查询
     * @param code
     * @return
     */
    @ApiOperation("002--根据code查询")
    @GetMapping("/code/{code}")
    ResultDto<SysConfigDto> findByCode(@PathVariable String code);

    /**
     * 更新(仅可更新值selectValueList)
     * @param dtos
     * @return
     */
    @ApiOperation("003--根据code更新")
    @PutMapping
    ResultDto<Integer> updateByDto(@RequestBody List<SysConfigDto> dtos);

    /**
     * 清除缓存
     * @return
     */
    @ApiOperation("004--清除缓存")
    @GetMapping("/cache/clear")
    ResultDto<Boolean> clearCache();

}
