package top.theonecyl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.theonecyl.springcloud.service.IPaymentService;
import top.theonecyl.springcloud.entity.CommentResult;
import top.theonecyl.springcloud.entity.Payment;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/addPayment",method = RequestMethod.POST)
    @ResponseBody
    public CommentResult addPayment(Payment payment){
        int i = paymentService.addPayment(payment);
        if(i>0){
            return new CommentResult(200,"添加支付模块成功！ServerPort:"+serverPort,payment);
        }else{
            return new CommentResult(444,"添加支付模块失败！",payment);
        }
    }

    @GetMapping(value = "/findPaymentById/{id}")
    @ResponseBody
    public CommentResult findPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.selectPaymentById(id);
        if(payment!=null){
            return new CommentResult(200,"查询支付模块成功ServerPort:"+serverPort,payment);
        }else{
            return new CommentResult(444,"查询支付模块失败",payment);
        }
    }

    @GetMapping("/myRule/lb")
    @ResponseBody
    public String myRule(){
        return "客户端访问服务提供者的端口为"+serverPort;
    }

    @GetMapping("/openfeign/timeout")
    @ResponseBody
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
