package com.nodamu.routingservice.adapters.out.persistence.jpaentities;

import com.nodamu.routingservice.domain.valueobjects.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author profnick
 * 9/9/20
 **/
@Getter
@NoArgsConstructor
@Entity
@Table(name = "carrier_movement")
public class CarrierMovementJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="arrival_date")
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(name="departure_Date")
    private Date departureDate;

    @Embedded
    private LocationJpaEntity arrivalLocation;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "departure_location_id"))
    private LocationJpaEntity departureLocation;

    public CarrierMovementJpaEntity(Date arrivalDate, Date departureDate, LocationJpaEntity arrivalLocation, LocationJpaEntity departureLocation) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
    }
}
