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

/**
 * <p>
 * 航公公司表
 * </p>
 *
 * @author scottxuan
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "basic_airline")
@ApiModel(value="Airline对象", description="航公公司表")
public class Airline extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "航司id")
    @Id
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "航空公司二字代码")
    @Column(name = "iataCode")
    private String iataCode;

    @ApiModelProperty(value = "航空公司三位数字代码")
    @Column(name = "iacoCode")
    private String iacoCode;

    @ApiModelProperty(value = "航司全称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "航司简称")
    @Column(name = "shortName")
    private String shortName;

    @ApiModelProperty(value = "排序")
    @Column(name = "ordinal")
    private Integer ordinal;


}
