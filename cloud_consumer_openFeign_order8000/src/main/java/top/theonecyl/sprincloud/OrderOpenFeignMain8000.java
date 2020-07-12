package top.theonecyl.sprincloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderOpenFeignMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain8000.class,args);
    }
}
