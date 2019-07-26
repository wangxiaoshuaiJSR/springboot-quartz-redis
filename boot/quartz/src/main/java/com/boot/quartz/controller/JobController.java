package com.boot.quartz.controller;

import com.boot.quartz.job.OrderTimeOutJob;
import com.boot.quartz.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @packageName: com.boot.quartz
 * @name: JobController
 * @description:
 * @author: 董定卓
 * @dateTime: 2019/7/24 12:06
 */
@RestController
public class JobController {

    @Autowired
    QuartzService service;

    /**
     * 添加新任务
     *
     * @return
     */
    @RequestMapping("/addJob")
    public Object addJob() {
        Map<String, Object> resultMap = new HashMap<>();
        //任务组名
        String groupName = "order";
        //任务名
        String jobName = "20190724120322389224";
        //CRON表达式
        String cronExp = "0/10 * * * * ? *";
        service.addJob(OrderTimeOutJob.class, jobName, groupName, cronExp, null);
        resultMap.put("groupName", groupName);
        resultMap.put("jobName", jobName);
        resultMap.put("cronExp", cronExp);
        return resultMap;
    }


    /**
     * 删除任务
     *
     * @return
     */
    @RequestMapping("/delJob")
    public Object delJob() {
        Map<String, Object> resultMap = new HashMap<>();
        //任务组名
        String groupName = "order";
        //任务名
        String jobName = "20190724120322389224";
        service.deleteJob(jobName, groupName);
        resultMap.put("groupName", groupName);
        resultMap.put("jobName", jobName);
        return resultMap;
    }

}
