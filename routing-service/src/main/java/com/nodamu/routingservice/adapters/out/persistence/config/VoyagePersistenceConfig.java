package com.nodamu.routingservice.adapters.out.persistence.config;

import com.nodamu.routingservice.adapters.out.persistence.VoyagePersistenceAdaptor;
import com.nodamu.routingservice.adapters.out.persistence.repository.VoyageJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author profnick
 * 9/9/20
 **/

@Configuration
@EnableJpaRepositories
public class VoyagePersistenceConfig {

    @Bean
    VoyagePersistenceAdaptor voyagePersistenceAdaptor(VoyageJpaRepository voyageJpaRepository   ){
        return new VoyagePersistenceAdaptor(voyageJpaRepository);
    }
}
