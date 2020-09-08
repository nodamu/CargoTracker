package com.nodamu.routingservice.shareddomain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author profnick
 * 9/8/20
 **/

@Getter
@Setter
@ToString
public class TransitPath implements Serializable {

    private List<TransitEdge> transitEdges;

    public TransitPath(List<TransitEdge> transitEdges) {
        this.transitEdges = transitEdges;
    }

    public TransitPath() {
        this.transitEdges = new ArrayList<>();
    }
}
