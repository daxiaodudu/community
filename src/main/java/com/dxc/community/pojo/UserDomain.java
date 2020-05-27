package com.dxc.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.PrivateKey;

/**
 * description: UserDomain <br>
 * date: 2020/3/12 13:48 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain implements Serializable {
    private  Integer uid;
    private  String username;
    private  String password;
    private  String email;
    private  String homeUrl;
    private  String screenName;
    private  Long created;
    private  Long activated;
    private  Long logged;
    private  String groupName;
}
