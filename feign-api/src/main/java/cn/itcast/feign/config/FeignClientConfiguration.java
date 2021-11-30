package cn.itcast.feign.config;
/*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-26  15:18
 */

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {
    @Bean
    public  Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }

}
