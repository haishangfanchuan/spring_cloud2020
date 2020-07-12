package top.theonecyl.springcloud.config;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GateWayConfig {

    /**
     * 通过编码方式配置动态路由
     * @return
     */
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator gateway_route01 = routes.route("gateway_route01", new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("/guonei").uri("https://news.baidu.com");
            }
        }).build();
        return gateway_route01;

    }
}
