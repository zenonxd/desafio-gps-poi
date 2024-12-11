package com.moreira.desafiogpspoi.web.controllers.dtos;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;

public record PoiRequest(String name,
                         Integer x,
                         Integer y) {

    public PointOfInterest toEntity() {
        return new PointOfInterest(
                name,
                x,
                y
        );
    }
}
