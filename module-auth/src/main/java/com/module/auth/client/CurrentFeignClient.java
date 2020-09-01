package com.module.auth.client;

import com.module.auth.api.CurrentApi;
import com.module.common.constants.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/27
 */
@FeignClient(value = ServiceConstant.SERVICE_AUTH,path = CurrentApi.MAPPING)
public interface CurrentFeignClient extends CurrentApi {
}
