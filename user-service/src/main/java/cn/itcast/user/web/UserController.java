package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PatternProperties patternProperties;

  /* @Value(value="${pattern.dateformat}")
    private String dateformat;*/

/*    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }
    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return dateformat;
    }*
    * @Author liu-miss
    * @Description //TODO
    * @Date 12:15 2021-11-30
    * @Param
    * @return
    **/
    @GetMapping("prop")
    public  PatternProperties properties() {
        return patternProperties;
    }

    @GetMapping("now")
    public String Now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,@RequestHeader(value = "Truth",required = false) String truth) {
        System.out.println("Truth:"+truth);
        return userService.queryById(id);
    }
}
