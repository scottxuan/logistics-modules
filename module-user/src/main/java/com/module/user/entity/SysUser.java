package com.module.user.entity;

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
 * 系统账户
 * </p>
 *
 * @author scottxuan
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table(name = "sys_user")
@ApiModel(value="SysUser对象", description="系统账户")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
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

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "加密盐值")
    @Column(name = "salt")
    private String salt;

    @ApiModelProperty(value = "是否是主账户")
    @Column(name = "isSystem")
    private Boolean isSystem;

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
