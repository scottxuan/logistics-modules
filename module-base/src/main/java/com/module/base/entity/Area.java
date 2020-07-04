package com.module.base.entity;

import com.scottxuan.base.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author scottxuan
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "basic_area")
@ApiModel(value="Area对象", description="区域表")
public class Area extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区域编码")
    @Id
    @Column(name = "code")
    private String code;

    @ApiModelProperty(value = "区域名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "上级区域编码")
    @Column(name = "parentCode")
    private String parentCode;

    @ApiModelProperty(value = "区域编码范围")
    @Column(name = "path")
    private String path;

    @ApiModelProperty(value = "层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(value = "简拼")
    @Column(name = "jianpin")
    private String jianpin;

    @ApiModelProperty(value = "拼音")
    @Column(name = "pinyin")
    private String pinyin;

    @ApiModelProperty(value = "排序")
    @Column(name = "ordinal")
    private Integer ordinal;

    @ApiModelProperty(value = "经度")
    @Column(name = "lng")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度")
    @Column(name = "lat")
    private BigDecimal lat;


}
