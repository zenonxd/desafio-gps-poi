package com.moreira.desafiogpspoi.web.controllers.dtos;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;

public record PoiResponse(Long id,
                          String name,
                          Integer x,
                          Integer y) {

    public static PoiResponse from(PointOfInterest pointOfInterest) {
        return new PoiResponse(
                pointOfInterest.getId(),
                pointOfInterest.getName(),
                pointOfInterest.getX(),
                pointOfInterest.getY()
        );
    }
}
