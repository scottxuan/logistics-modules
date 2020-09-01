package com.module.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "登录身份信息")
public class Identity {
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

    @ApiModelProperty(value = "是否是超级用户")
    @Column(name = "isSuper")
    private Boolean isSuper;

    @ApiModelProperty(value = "是否锁定")
    @Column(name = "isLocked")
    private Boolean isLocked;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "createTime")
    private LocalDateTime createTime;

}
