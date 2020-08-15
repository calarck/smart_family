package com.example.family.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        System.out.println("redis key过期：{}" + expiredKey);
        //业务逻辑处理。。。

    }

}
