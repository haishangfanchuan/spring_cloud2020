package top.theonecyl.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.theonecyl.springcloud.service.IHystrixPaymentService;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentSerivce implements IHystrixPaymentService {

    @Override
    public String hystrix_ok(int id) {
        return "线程--->"+Thread.currentThread().getName();
    }

    @Override
    public String hystrix_timeout(int id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程--->"+Thread.currentThread().getName()+"***线程睡眠3秒";
    }


    //**********服务熔断********
    //服务降级—>服务熔断—>服务链路恢复
    @HystrixCommand(fallbackMethod = "CricuitBrokerMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    @Override
    public String CricuitBorker(int id) {
        //id小于零服务降级
        if(id<=0){
            throw new RuntimeException("id不可小于0");
        }
        return Thread .currentThread().getName()+"服务请求成功"+"****id:"+id;
    }

    public String CricuitBrokerMethod(int id){
        return Thread .currentThread().getName()+"服务请求失败/(ㄒoㄒ)/~~"+"****id:"+id;
    }
}
