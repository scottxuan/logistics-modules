package com.module.system.entity;

import com.scottxuan.base.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author scottxuan
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "sys_config")
@ApiModel(value="SysConfig对象", description="系统配置表")
public class SysConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "编码")
    @Column(name = "code")
    private String code;

    @ApiModelProperty(value = "sys_config_group:code")
    @Column(name = "groupCode")
    private String groupCode;

    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "参数类型 1:文本  2:单选框  3:复选框	4:开关")
    @Column(name = "type")
    private Integer type;

    @ApiModelProperty(value = "值列表")
    @Column(name = "allValue")
    private String allValue;

    @ApiModelProperty(value = "值")
    @Column(name = "value")
    private String value;

    @ApiModelProperty(value = "序号")
    @Column(name = "ordinal")
    private Integer ordinal;

    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "isDeleted")
    private Boolean isDeleted;



}
