package com.module.system.identity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "登录身份信息")
public class Identity {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "账户")
    private String account;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "是否是超级用户")
    private Boolean isSuper;

    @ApiModelProperty(value = "是否锁定")
    private Boolean isLocked;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
