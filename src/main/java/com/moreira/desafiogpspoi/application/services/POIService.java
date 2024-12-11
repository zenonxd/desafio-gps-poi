package com.moreira.desafiogpspoi.application.services;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;
import com.moreira.desafiogpspoi.domain.repositories.POIRepository;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiRequest;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiResponse;
import org.springframework.stereotype.Service;

@Service
public class POIService {

    private final POIRepository poiRepository;

    public POIService(POIRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public PoiResponse insert(PoiRequest poiRequest) {
        PointOfInterest entity = poiRequest.toEntity();

        PointOfInterest savedEntity = poiRepository.save(entity);

        return PoiResponse.from(savedEntity);
    }
}
