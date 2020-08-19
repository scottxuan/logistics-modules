package com.module.system.client;

import com.module.common.constants.ServiceConstant;
import com.module.system.api.SysConfigApi;
import com.module.system.api.SysConfigGroupApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@FeignClient(ServiceConstant.SERVICE_SYSTEM)
public interface SysConfigGroupClient extends SysConfigGroupApi {
}
