package com.nodamu.cargotracker.booking.adapter.out.persistence.config;

import com.nodamu.cargotracker.booking.adapter.out.persistence.CargoPersistenceAdaptor;
import com.nodamu.cargotracker.booking.adapter.out.persistence.repository.CargoJpaRepository;
import com.nodamu.cargotracker.booking.application.ports.out.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author profnick
 * 8/26/20
 **/

@Configuration
public class CargoPersistenceAdaptorConfig {
    @Autowired
    private CargoJpaRepository cargoJpaRepository;

    @Bean
    public CargoRepository cargoRepository(){
        return new CargoPersistenceAdaptor(cargoJpaRepository);
    }


}
