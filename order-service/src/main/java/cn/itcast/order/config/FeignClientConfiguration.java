package cn.itcast.order.config;/*
 *创建人:
 *创建时间:2021-11-25 17:16
 *描述:
 *//*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-25  17:16
 */


import feign.Logger;
import org.springframework.context.annotation.Bean;


public class FeignClientConfiguration {
    @Bean
    public Logger.Level  ferignLogLevel(){
        return Logger.Level.BASIC;
    }
}
