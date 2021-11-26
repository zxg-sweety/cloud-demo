package cn.itcast.feign.client;/*
 *创建人:
 *创建时间:2021-11-26 15:21
 *描述:
 *//*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-26  15:21
 */

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}
