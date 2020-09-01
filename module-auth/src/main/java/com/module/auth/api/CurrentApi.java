package com.module.auth.api;

import com.module.common.vo.Identity;
import com.scottxuan.web.result.ResultDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author scottxuan
 */
public interface CurrentApi {
    String MAPPING = "${api}/current";

    /**
     * 系统用户账户密码登录
     * @return
     */
    @GetMapping("/user")
    @ApiOperation("001--当前登录用户id")
    ResultDto<Identity> getCurrentUser();
}
