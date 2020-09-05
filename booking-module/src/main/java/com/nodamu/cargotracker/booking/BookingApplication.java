package com.nodamu.cargotracker.booking;

import com.nodamu.cargotracker.booking.adapter.out.messagebrokers.CargoEventSource;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import com.nodamu.cargotracker.booking.application.services.commandservices.BookCargoCommandService;
import com.nodamu.cargotracker.booking.domain.aggregates.Cargo;
import com.nodamu.cargotracker.booking.domain.commands.BookCargoCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.nodamu.cargotracker.booking.adapter.out.persistence.model.entities"})  // scan JPA entities
@EnableJpaRepositories
@EnableBinding(CargoEventSource.class)
public class BookingApplication  {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {

//
//        service.bookCargo(command);
//
//        List<Cargo> cargos = cargoRepository.findAll();
//        cargos.forEach(cargo -> logger.info( "-> {}",cargo.getId()));
//    }
}
