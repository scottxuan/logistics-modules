package com.module.system.client;

import com.module.system.api.CusUserApi;
import com.module.system.constants.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/5
 */
@FeignClient(value = ServiceConstant.SERVICE_SYSTEM, path = CusUserApi.MAPPING)
public interface CusUserFeignClient extends CusUserApi {
}
