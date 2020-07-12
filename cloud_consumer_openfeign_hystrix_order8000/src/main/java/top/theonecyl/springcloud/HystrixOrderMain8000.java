package top.theonecyl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//向eureka注册服务,客户端
@EnableFeignClients//开启OpenFeign负载均衡和服务调度
@EnableDiscoveryClient//
@EnableHystrix//开启服务降级/熔断功能
public class HystrixOrderMain8000 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain8000.class,args);
    }
}
