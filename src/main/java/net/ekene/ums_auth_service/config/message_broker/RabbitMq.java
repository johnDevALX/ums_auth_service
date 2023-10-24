package net.ekene.ums_auth_service.config.message_broker;

import lombok.RequiredArgsConstructor;
import net.ekene.ums_auth_service.config.util.AppConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMq {
    private final AppConfig appConfig;

    @Bean
    public Queue queue (){
        return new Queue(appConfig.getRabbitConfig().getQueue());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(appConfig.getRabbitConfig().getExchange());
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(appConfig.getRabbitConfig().getRoutingKey());
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
