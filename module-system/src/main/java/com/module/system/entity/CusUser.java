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
import java.time.LocalDateTime;

/**
 * <p>
 * 客户账户
 * </p>
 *
 * @author scottxuan
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "cus_user")
@ApiModel(value="CusUser对象", description="客户账户")
public class CusUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "账户")
    @Column(name = "account")
    private String account;

    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "手机号码")
    @Column(name = "mobile")
    private String mobile;

    @ApiModelProperty(value = "加密盐值")
    @Column(name = "salt")
    private String salt;

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "openId")
    @Column(name = "openId")
    private String openId;

    @ApiModelProperty(value = "用户类型 1:普通用户  2:供应商  3:销代  4:供应商和销代")
    @Column(name = "type")
    private Integer type;

    @ApiModelProperty(value = "是否锁定")
    @Column(name = "isLocked")
    private Boolean isLocked;

    @ApiModelProperty(value = "是否删除")
    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最近一次修改时间")
    @Column(name = "lastUpdateTime")
    private LocalDateTime lastUpdateTime;



}
