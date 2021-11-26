package cn.itcast.feign.pojo;
/*
 *@Author:Administrator
 *@Description:
 *@Date:2021-11-26  15:19
 */

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;
}
