package top.theonecyl.springcloud.loadBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

    //获取能够正常运行的服务提供者
    ServiceInstance serviceInstance(List<ServiceInstance> list);
}
