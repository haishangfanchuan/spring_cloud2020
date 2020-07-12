package top.theonecyl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.theonecyl.springcloud.service.IHystrixOrderService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixOrderController {

    @Resource
    private IHystrixOrderService iHystrixOrderService;

    @GetMapping("/consumer/payment/hystix/ok/{id}")
    public String order_hystrix_ok(@PathVariable("id") int id) {
        return iHystrixOrderService.hystrix_ok(id);
    }

    @GetMapping("/consumer/payment/hystix/timeout/{id}")
    public String order_hystrix_timeout(@PathVariable("id") int id) {
        return iHystrixOrderService.hystrix_timeout(id);
    }
}
