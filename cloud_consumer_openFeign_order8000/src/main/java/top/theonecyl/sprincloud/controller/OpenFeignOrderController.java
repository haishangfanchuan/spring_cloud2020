package top.theonecyl.sprincloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.theonecyl.sprincloud.service.IOpenFeignService;
import top.theonecyl.springcloud.entity.CommentResult;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OpenFeignOrderController {

    @Resource
    private IOpenFeignService openFeignService;

    @GetMapping("/consumer/payment/findPaymentById/{id}")
    public CommentResult getPaymentById(@PathVariable("id") long id){
        return openFeignService.findPaymentById(id);
    }

    @GetMapping("/consumer/payment/openfeign/timeout")
    public String timeout(){
        return openFeignService.timeout();
    }
}
