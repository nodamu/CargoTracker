package com.nodamu.cargotracker.shareddomain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author profnick
 * 9/11/20
 **/

@Getter
@Setter
@ToString
public class TransitPath implements Serializable {
    List<TransitEdge> transitEdges;

    public TransitPath(List<TransitEdge> transitEdges) {
        this.transitEdges = transitEdges;
    }

    public TransitPath() {
    }
}
