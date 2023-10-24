package net.ekene.ums_auth_service.config.util;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties("app")
public class AppConfig {
    private JwtConfig jwtConfig;
    private RabbitConfig rabbitConfig;

    @Data
    public static class JwtConfig{
        private String secretKey;
    }

    @Data
    public static class RabbitConfig{
        private String queue;
        private String exchange;
        private String routingKey;
    }
}
