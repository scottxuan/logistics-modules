package com.module.base.client;

import com.module.system.constants.ServiceConstant;
import com.module.base.api.AirlineApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : scottxuan
 */
@FeignClient(value = ServiceConstant.SERVICE_BASE, path = AirlineApi.MAPPING)
public interface AirlineFeignClient extends AirlineApi {
}
