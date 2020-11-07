package com.example.family.config;

import com.example.family.msgpush.service.MessagePushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {
    @Autowired
    private MessagePushService service;
    //每月一号中文12时触发
    @Scheduled(cron = "0 0 12 1 * ?")
    public void deleteOutTimeToken(){
        service.sendMessage("请及时查阅上月消费情况");
    }
}
