package com.nodamu.cargotracker.booking.adapter.out.persistence.config;

import com.nodamu.cargotracker.booking.adapter.out.persistence.CargoPersistenceAdaptor;
import com.nodamu.cargotracker.booking.adapter.out.persistence.repository.CargoJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author profnick
 * 8/26/20
 **/

@Configuration
@EnableJpaRepositories
public class CargoPersistenceAdaptorConfig {

    @Bean
    CargoPersistenceAdaptor cargoPersistenceAdaptor(CargoJpaRepository cargoJpaRepository){
        return new CargoPersistenceAdaptor(cargoJpaRepository);
    }

}
