package com.module.system.dto;

import com.module.system.entity.SysConfig;
import com.scottxuan.base.pair.Pair;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel(value="SysConfigDto对象", description="系统配置")
@Data
public class SysConfigDto extends SysConfig {
    private static final long serialVersionUID = 1664263438860893571L;

    @ApiModelProperty(value = "值列表")
    private List<Pair<String,String>> valueList;

    @ApiModelProperty(value = "值")
    private List<String> selectValueList;
}
