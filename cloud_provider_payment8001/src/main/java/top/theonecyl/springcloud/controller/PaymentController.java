package top.theonecyl.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.theonecyl.springcloud.entity.CommentResult;
import top.theonecyl.springcloud.entity.Payment;
import top.theonecyl.springcloud.service.IPaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discoveryClient")
    @ResponseBody
    public DiscoveryClient getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String string : services){
            log.info("-------------所有客户端------"+string);
        }
        List<ServiceInstance> instancesById = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for(ServiceInstance instanceInfo : instancesById){
            log.info("主机名："+instanceInfo.getInstanceId());
            log.info("主机地址："+instanceInfo.getHost());
            log.info("端口号："+instanceInfo.getPort());
            log.info("URI："+instanceInfo.getUri());

        }
        return discoveryClient;
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
