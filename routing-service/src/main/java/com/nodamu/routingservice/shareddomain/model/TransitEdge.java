package com.nodamu.routingservice.shareddomain.model;

import lombok.*;

import java.sql.Date;

/**
 * @author profnick
 * 9/8/20
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransitEdge {
    private String voyageNumber;
    private String fromUnLocCode;
    private String toUnLocCode;
    private Date fromDate;
    private Date toDate;
}
