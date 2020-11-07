package com.example.family.msgpush.service;

import com.example.family.baseHandler.BaseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessagePushService implements RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessagePushService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(this);
    }

    //消息发送到转换器的时候没有对列,配置了queueFanout对列该回调则不生效
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.info("消息确认:"+message);
    }

    /**
     * 消息确认回调
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("消息确认:"+s);
    }

    public String sendMessage(String message){
        if (BaseHandler.getCurrentUserType().contains("1")){
            rabbitTemplate.convertAndSend("exchange.ae","exchange.ae",message);
            return "已经发送";
        }
        return "您无权限";
    }
}
