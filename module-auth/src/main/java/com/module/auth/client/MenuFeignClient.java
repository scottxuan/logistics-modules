package com.module.auth.client;

import com.module.auth.api.MenuApi;
import com.module.common.constants.ServiceConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : pc
 * @date : 2020/7/21
 */
@FeignClient(value = ServiceConstant.SERVICE_AUTH, path = MenuApi.MAPPING)
public interface MenuFeignClient extends MenuApi {
}
