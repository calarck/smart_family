package com.example.family.commen;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMessagePushConsumer {
    @RabbitHandler
    @RabbitListener(queues = "queue.ae")
    public void pushMessageToAll(Message message, Channel channel) throws IOException {
        //消费消息确认回调
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
