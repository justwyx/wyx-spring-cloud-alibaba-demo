package com.wyx.consumerserver.sao;

import com.wyx.feign.UserFeign;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : Just wyx
 * @Date : 2021/2/25
 */
@FeignClient("provide-code")
public interface UserFeignClient extends UserFeign {
}
