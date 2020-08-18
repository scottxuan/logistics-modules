package com.module.user.client;

import com.module.common.constants.ServiceConstant;
import com.module.user.api.SysUserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@FeignClient(ServiceConstant.SERVICE_USER)
public interface SysUserFeignClient extends SysUserApi {
}
