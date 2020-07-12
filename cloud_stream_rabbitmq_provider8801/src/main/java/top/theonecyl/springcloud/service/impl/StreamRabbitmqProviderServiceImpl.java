package top.theonecyl.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import top.theonecyl.springcloud.service.IStreamRabbitmqProviderService;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//开启生产者消息通道
@Component
public class StreamRabbitmqProviderServiceImpl implements IStreamRabbitmqProviderService {

    @Resource
    private MessageChannel output; //消息生产者

    @Override
    public String sentMessage() {
        String string = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(string).build());
        System.out.println("*******"+string);
        return string;
    }
}
