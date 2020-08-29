package com.module.system.client;

import com.module.common.constants.ServiceConstant;
import com.module.system.api.SysConfigApi;
import com.module.system.api.SysUserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@FeignClient(value = ServiceConstant.SERVICE_SYSTEM, path = SysConfigApi.MAPPING)
public interface SysConfigClient extends SysConfigApi {
}
