package top.theonecyl.springcloud.loadBalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getCount(){
        int count ;
        int next ;
        do {
            count = atomicInteger.get();
            next = count >= Integer.MAX_VALUE ? 0:count+1;
        }while(!atomicInteger.compareAndSet(count,next));

        System.out.println("****访问次数***"+next);
        return next;
    }

    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> list) {
        int count = getCount();
        int index =  count % list.size();
        return list.get(index);
    }
}
