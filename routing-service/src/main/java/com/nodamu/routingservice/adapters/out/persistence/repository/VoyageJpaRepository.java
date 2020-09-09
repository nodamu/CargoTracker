package com.nodamu.routingservice.adapters.out.persistence.repository;

import com.nodamu.routingservice.adapters.out.persistence.model.entities.VoyageJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author profnick
 * 9/9/20
 **/

public interface VoyageJpaRepository extends CrudRepository<VoyageJpaEntity,Long> {

    @Query("select v from VoyageJpaEntity v")
    List<VoyageJpaEntity> findAllVoyages();

}
