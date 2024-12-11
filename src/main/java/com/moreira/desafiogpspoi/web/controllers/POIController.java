package com.moreira.desafiogpspoi.web.controllers;

import com.moreira.desafiogpspoi.application.services.POIService;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiRequest;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/poi")
public class POIController {

    private final POIService poiService;

    public POIController(POIService poiService) {
        this.poiService = poiService;
    }

    @PostMapping
    public ResponseEntity<PoiResponse> insert(@RequestBody PoiRequest poiRequest) {

        PoiResponse response = poiService.insert(poiRequest);

        URI uri = URI.create("/api/poi" + response.id());

        return ResponseEntity.created(uri).body(response);
    }
}
