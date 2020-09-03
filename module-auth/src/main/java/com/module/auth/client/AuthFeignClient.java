package com.module.auth.client;

import com.module.auth.api.AuthApi;
import com.module.system.constants.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/8/27
 */
@FeignClient(value = ServiceConstant.SERVICE_AUTH,path = AuthApi.MAPPING)
public interface AuthFeignClient extends AuthApi {
}
