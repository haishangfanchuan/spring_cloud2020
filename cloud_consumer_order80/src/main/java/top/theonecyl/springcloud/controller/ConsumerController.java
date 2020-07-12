package top.theonecyl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.theonecyl.springcloud.entity.CommentResult;
import top.theonecyl.springcloud.entity.Payment;
import top.theonecyl.springcloud.loadBalance.LoadBalance;
import top.theonecyl.springcloud.loadBalance.MyLb;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/consumer")
@Slf4j
public class ConsumerController {

    private static final String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;



    @RequestMapping(value = "/getPayment/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommentResult getPayment(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/findPaymentById/"+id,CommentResult.class);

    }

    @GetMapping(value = "/addPayment")
    @ResponseBody
    public CommentResult addPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/addPayment",payment,CommentResult.class);
    }

    @GetMapping("/myRule/lb")
    @ResponseBody
    public String myRule(){
//       return restTemplate.getForObject(PAYMENT_URL+"/payment/myRule/lb",String.class);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if(instances!=null || instances.size()<=0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.serviceInstance(instances);
        //获取客户端访问服务提供者的url路径
        URI uri = serviceInstance.getUri();
        System.out.println("**********************"+uri);
        return restTemplate.getForObject(uri+"/payment/myRule/lb",String.class);
    }

}
