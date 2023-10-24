package net.ekene.ums_auth_service.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ekene.payload.EmailPayload;
import net.ekene.ums_auth_service.config.util.AppConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqProducer {

    private final AppConfig appConfig;
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(EmailPayload emailPayload) {
        log.info("payload {}", emailPayload);
        rabbitTemplate.convertAndSend(appConfig.getRabbitConfig().getExchange(),
                appConfig.getRabbitConfig().getRoutingKey(), emailPayload);
    }
}
