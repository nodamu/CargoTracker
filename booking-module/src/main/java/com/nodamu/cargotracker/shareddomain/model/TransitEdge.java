package com.nodamu.cargotracker.shareddomain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.sql.Date;

/**
 * @author profnick
 * 9/11/20
 **/

@AllArgsConstructor
@Data
public class TransitEdge {

    private String voyageNumber;
    private String fromUnLocCode;
    private String toUnLocCode;
    private Date fromDate;
    private Date toDate;

    public TransitEdge() {
    }


}
