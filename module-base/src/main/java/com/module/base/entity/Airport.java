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
 * 机场表
 * </p>
 *
 * @author scottxuan
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "basic_airport")
@ApiModel(value="Airport对象", description="机场表")
public class Airport extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机场id")
    @Id
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "机场三字码")
    @Column(name = "code")
    private String code;

    @ApiModelProperty(value = "机场名称")
    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "cityEnglish")
    private String cityEnglish;

    @Column(name = "country")
    private String country;

    @ApiModelProperty(value = "排序")
    @Column(name = "ordinal")
    private Integer ordinal;

    @ApiModelProperty(value = "地址path")
    @Column(name = "address")
    private String address;


}
