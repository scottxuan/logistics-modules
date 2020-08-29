package com.module.base.client;

import com.module.common.constants.ServiceConstant;
import com.module.base.api.AreaApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : scottxuan
 */
@FeignClient(value = ServiceConstant.SERVICE_BASE,path = AreaApi.MAPPING)
public interface AreaFeignClient extends AreaApi {
}
