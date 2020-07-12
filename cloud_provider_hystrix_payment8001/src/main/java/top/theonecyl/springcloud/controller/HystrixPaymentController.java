package top.theonecyl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.theonecyl.springcloud.service.IHystrixPaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixPaymentController {

    @Resource
    private IHystrixPaymentService hystrixPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") int id){
        return hystrixPaymentService.hystrix_ok(id)+"***服务端口号为："+serverPort;
    }

    @GetMapping("/payment/hystix/timeout/{id}")
    public String hystrix_timeout(@PathVariable("id") int id){
        return hystrixPaymentService.hystrix_timeout(id)+"***服务端口号为："+serverPort;
    }

    @GetMapping("/paymnet/hystrix/cricuitBorker/{id}")
    public String CricuitBorker(@PathVariable("id") int id){
        return hystrixPaymentService.CricuitBorker(id);
    }
}
