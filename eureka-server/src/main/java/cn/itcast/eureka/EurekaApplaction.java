package cn.itcast.eureka;
/*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-18  16:21
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication


public class EurekaApplaction {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplaction.class,args);
    }
}
