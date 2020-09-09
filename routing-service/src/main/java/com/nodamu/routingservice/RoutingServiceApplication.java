package com.nodamu.routingservice;

import com.nodamu.routingservice.domain.valueobjects.VoyageNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.nodamu.routingservice.adapters.out.persistence.model.entities"}) //Scan JPA entities
@EnableJpaRepositories
public class RoutingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApplication.class, args);
    }

}
