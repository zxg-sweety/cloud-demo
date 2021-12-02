package cn.itcast.gateway.filter;/*
 *创建人:
 *创建时间:2021-11-30 16:42
 *描述:
 *//*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-30  16:42
 */

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.config.FeignClientConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.core.annotation.Order;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Order(-1) //-21亿优先级最高，21亿优先级最低
@Component
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1、获取参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //2、获取参数中的authorized值
        String authorized = queryParams.getFirst("authorization");
        //3、判断是否等于admin
        if(authorized.equals("admin")){
        //4、if等于放行
            return chain.filter(exchange);
        }else{
        //5、不等于拦截
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return  exchange.getResponse().setComplete();
        }
    }
}
