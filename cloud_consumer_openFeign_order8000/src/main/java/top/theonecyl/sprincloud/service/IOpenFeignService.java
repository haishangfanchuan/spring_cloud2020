package top.theonecyl.sprincloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.theonecyl.springcloud.entity.CommentResult;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface IOpenFeignService {

    @GetMapping(value = "/payment/findPaymentById/{id}")
    CommentResult findPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/openfeign/timeout")
    String timeout();
}
