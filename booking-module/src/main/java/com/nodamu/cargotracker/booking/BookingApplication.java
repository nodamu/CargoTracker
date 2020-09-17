package com.nodamu.cargotracker.booking;

import com.nodamu.cargotracker.booking.adapter.out.messagebrokers.CargoEventSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EntityScan(basePackages = {"com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities"})  // scan JPA entities
@EnableJpaRepositories
@EnableBinding(CargoEventSource.class)
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
public class BookingApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}