package com.example.family.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class RabbitMqConfig {
    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    //需要哪种类型的转换器就创建哪种类型的转换器
    @Bean
    public DirectExchange exchangeDirect(){
        Map<String,Object> args = new HashMap<>();
        args.put("alternate-exchange", "exchange.ae");
        return new DirectExchange("exchange.hello",true,false,args);
    }

    @Bean
    public FanoutExchange exchangeFanout(){
        return new FanoutExchange("exchange.ae",true,false,null);
    }

    @Bean
    public TopicExchange exchangeTopic(){
        return new TopicExchange("exchange.dlx",true,false,null);
    }

    @Bean
    public Queue queueDirect(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "exchange.dlx");
        args.put("x-dead-letter-routing-key", "dlx.test" );
        args.put("x-message-ttl", 5000);
        return new Queue("queue.hello",true,false,false,args);
    }

    @Bean
    public Queue queueFanout(){
        return new Queue("queue.ae",true,false,false,null);
    }

    @Bean
    public Queue queueTopic(){
        return new Queue("queue.dlx",true,false,false,null);
    }

    @Bean
    public Binding bindingExchangeDirect(@Qualifier("queueDirect") Queue queueDirect,@Qualifier("exchangeDirect") DirectExchange exchangeDirect){
        return BindingBuilder.bind(queueDirect).to(exchangeDirect).with("directKey");
    }

    @Bean
    public Binding bindingExchangeFanout(@Qualifier("queueFanout") Queue queueFanout,@Qualifier("exchangeFanout") FanoutExchange exchangeFanout){
        return BindingBuilder.bind(queueFanout).to(exchangeFanout);
    }

    @Bean
    public Binding bindingExchangeTopic(@Qualifier("queueTopic") Queue queueTopic,@Qualifier("exchangeTopic") TopicExchange exchangeTopic){
        return BindingBuilder.bind(queueTopic).to(exchangeTopic).with("dlx.*");
    }

    /**
     * 如果需要在生产者需要消息发送后的回调，
     * 需要对rabbitTemplate设置ConfirmCallback对象，
     * 由于不同的生产者需要对应不同的ConfirmCallback，
     * 如果rabbitTemplate设置为单例bean，
     * 则所有的rabbitTemplate实际的ConfirmCallback为最后一次申明的ConfirmCallback。
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        return rabbitTemplate;
    }
}
