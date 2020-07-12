package top.theonecyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMqMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMqMain8801.class,args);
    }
}
