package cn.itcast.user.config;/*
 *创建人:
 *创建时间:2021-11-22 17:37
 *描述:
 *//*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-22  17:37
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
}
