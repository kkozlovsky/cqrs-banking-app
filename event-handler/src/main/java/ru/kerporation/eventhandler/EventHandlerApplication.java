package ru.kerporation.eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "ru.kerporation")
@ComponentScan(basePackages = "ru.kerporation")
@EnableJpaRepositories(basePackages = "ru.kerporation.*")
public class EventHandlerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(EventHandlerApplication.class, args);
    }

}
