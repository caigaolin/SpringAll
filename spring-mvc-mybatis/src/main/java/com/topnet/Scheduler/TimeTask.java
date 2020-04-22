package com.topnet.Scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author cgl
 * @ClassName TimeTask
 * @Date Created in 16:23 2020/4/21
 */
@Component
@PropertySource(value = "classpath:config.properties")
public class TimeTask {

    @Value("${taskTime}")
    private String taskTime;

//    @Scheduled(cron = "${taskTime}")
    public void testTask() {
        System.out.println(LocalDate.now()+"*********B任务每5秒执行一次进入测试");
    }
}
