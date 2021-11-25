package cn.itcast.order.clients;/*
 *创建人:
 *创建时间:2021-11-25 10:37
 *描述:
 */

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;

@FeignClient("userservice")
public interface UserClient {

@GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
