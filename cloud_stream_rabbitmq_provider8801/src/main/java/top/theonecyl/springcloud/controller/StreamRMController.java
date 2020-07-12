package top.theonecyl.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.theonecyl.springcloud.service.IStreamRabbitmqProviderService;

import javax.annotation.Resource;

@RestController
public class StreamRMController {

    @Resource
    private IStreamRabbitmqProviderService streamRabbitmqProviderService;

    @GetMapping("/provider/sendMessage")
    public String sendMessage(){
        return streamRabbitmqProviderService.sentMessage();
    }
}
