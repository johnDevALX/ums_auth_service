package net.ekene.ums_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "net.ekene.model")
public class UmsAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmsAuthServiceApplication.class, args);
    }

}
