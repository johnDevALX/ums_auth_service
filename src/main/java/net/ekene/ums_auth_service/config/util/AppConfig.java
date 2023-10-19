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

    @Data
    public static class JwtConfig{
        private String secretKey;
    }
}
