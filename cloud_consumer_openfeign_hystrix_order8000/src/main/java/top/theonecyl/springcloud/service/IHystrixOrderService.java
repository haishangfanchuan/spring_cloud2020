package top.theonecyl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.theonecyl.springcloud.service.fallbackMethod.FallBaceMethodService;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = FallBaceMethodService.class)
public interface IHystrixOrderService {

    @GetMapping("/payment/hystix/ok/{id}")
     String hystrix_ok(@PathVariable("id") int id);
    @GetMapping("/payment/hystix/timeout/{id}")
     String hystrix_timeout(@PathVariable("id") int id);
}
