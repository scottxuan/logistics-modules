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

/**
 * <p>
 * 系统配置分组表
 * </p>
 *
 * @author scottxuan
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "sys_config_group")
@ApiModel(value="SysConfigGroup对象", description="系统配置分组表")
public class SysConfigGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "编号")
    @Column(name = "code")
    private String code;

    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "分组描述")
    @Column(name = "ordinal")
    private Integer ordinal;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "isDeleted")
    private Boolean isDeleted;



}
