package com.boot.redis.controller;

import com.boot.redis.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @packageName: com.boot.redis.controller
 * @name: RedisController
 * @description:
 * @author: 董定卓
 * @dateTime: 2019/7/25 14:09
 */
@RestController
public class RedisController {

    /**
     * 设置数据到redis
     *
     * @return
     */
    @RequestMapping("/set")
    public Object redisSet() {
        String k = "test";
        String v = "测试";
        long time = 1;
        TimeUnit unit = TimeUnit.MINUTES;
        //设置一个字符串到redis中，过期时间为1分钟
        RedisUtil.setString(k, v, time, unit);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("key", k);
        resultMap.put("value", v);
        resultMap.put("time", unit.toSeconds(time) + "秒");
        return resultMap;
    }

    /**
     * 从redis中获取数据
     *
     * @return
     */
    @RequestMapping("/get")
    public Object redisGet() {
        String k = "test";
        //根据key从redis中获取字符串
        String v = RedisUtil.getString(k);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("key", k);
        resultMap.put("value", v);
        return resultMap;
    }

}
