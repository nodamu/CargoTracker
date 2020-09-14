package com.nodamu.cargotracker.booking;

import com.nodamu.cargotracker.booking.adapter.out.messagebrokers.CargoEventSource;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.application.services.commandservices.BookCargoCommandService;
import com.nodamu.cargotracker.booking.application.services.commandservices.RouteCargoCommandService;
import com.nodamu.cargotracker.booking.domain.aggregates.BookingId;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;
import com.nodamu.cargotracker.booking.domain.commands.RouteCargoCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities"})  // scan JPA entities
@EnableJpaRepositories
@EnableBinding(CargoEventSource.class)
@EnableDiscoveryClient
public class BookingApplication  implements CommandLineRunner{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookCargoCommandService bookCargoCommandService;

    @Autowired
    private RouteCargoCommandService routeCargoCommandService;

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        BookCargoCommand bookCargoCommand = new BookCargoCommand(
                300,
                "PUM",
                "DEL",
                new Date(2020,9,14)
        );
       BookingId id = bookCargoCommandService.bookCargo(bookCargoCommand);

        RouteCargoCommand routeCargoCommand = new RouteCargoCommand(id.getBookingId());
        routeCargoCommandService.routeCargo(routeCargoCommand);
}
}