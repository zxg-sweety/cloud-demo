package cn.itcast.order.web;

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;
  /* @Autowired
   private RestTemplate restTemplate;*/
  @Autowired
  private UserClient userClient;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order =  orderService.queryOrderById(orderId);
      /*  String url = "http://userservice/user/"+order.getUserId();*/
        //远程调用
        User user = userClient.findById(order.getUserId());
/*        User user = restTemplate.getForObject(url, User.class);*/
        order.setUser(user);
        return  order;
    }


}
