package com.moreira.desafiogpspoi.application.services;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;
import com.moreira.desafiogpspoi.domain.repositories.POIRepository;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiRequest;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PoiResponse findPoiById(Long id) {
        PointOfInterest entity = poiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Point of interest not found"));

        return PoiResponse.from(entity);
    }

    public Page<PoiResponse> findAllPoiByPage(Pageable pageable) {
        Page<PointOfInterest> entityPage = poiRepository.findAll(pageable);

        return entityPage.map(PoiResponse::from);
    }

    public Page<PoiResponse> findPoiByCoordinates(Pageable pageable, int x, int y, int maximumDistance) {
        Page<PointOfInterest> poiPage = poiRepository.findPointOfInterestByCoordinates(x, y, maximumDistance, pageable);


        List<PoiResponse> poiResponses = poiPage.getContent().stream()
                .filter(poi -> calculateDistance(poi.getX(), poi.getY(), x, y) <= maximumDistance)
                .map(PoiResponse::from)
                .toList();

        return new PageImpl<>(poiResponses, pageable, poiPage.getTotalElements());
    }

    private Double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
