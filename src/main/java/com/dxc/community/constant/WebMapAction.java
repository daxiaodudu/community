package com.dxc.community.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * description: WebMapAction <br>
 * date: 2020/3/15 13:37 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public class WebMapAction {
    public  static Map<String,String> ProfileMap=new HashMap<>();

    static {
        ProfileMap.put("","我的问题");
        ProfileMap.put("myQuestion","我的问题");
        ProfileMap.put("myFollow","我的关注");
    }
}
