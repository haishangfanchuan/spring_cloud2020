package top.theonecyl.springcloud.service.fallbackMethod;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.stereotype.Component;
import top.theonecyl.springcloud.service.IHystrixOrderService;

@Component
@DefaultProperties(defaultFallback = "GlobalFallBackMethod")
public class FallBaceMethodService  implements IHystrixOrderService{
    @Override
    public String hystrix_ok(int id) {
        return "hystrix_ok /(ㄒoㄒ)/~~";
    }

    @Override
    public String hystrix_timeout(int id) {
        return "hystrix_timeout /(ㄒoㄒ)/~~";
    }

    public String GlobalFallBackMethod(){
        return "不对起，服务器繁忙，请稍后再试/(ㄒoㄒ)/~~";
    }
}
