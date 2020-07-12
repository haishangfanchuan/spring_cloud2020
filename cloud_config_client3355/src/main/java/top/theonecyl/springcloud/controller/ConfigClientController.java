package top.theonecyl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope   //自动刷新配置中心修改内容
public class ConfigClientController {

    @Value("springCloud.configServer")
    private String configInfo;

    @GetMapping("/configClient/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
