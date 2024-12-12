package com.moreira.desafiogpspoi.web.controllers;

import com.moreira.desafiogpspoi.application.services.POIService;
import com.moreira.desafiogpspoi.web.controllers.dtos.ApiResponse;
import com.moreira.desafiogpspoi.web.controllers.dtos.PaginationDTO;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiRequest;
import com.moreira.desafiogpspoi.web.controllers.dtos.PoiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<PoiResponse> findPoiById(@PathVariable Long id) {

        PoiResponse response = poiService.findPoiById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<PoiResponse>> findAllPoiByPage(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<PoiResponse> response = poiService.findAllPoiByPage(pageable);

        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/coordinates")
    public ResponseEntity<ApiResponse<PoiResponse>> findPoiByCoordinates(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                                  @RequestParam(required = true) Integer x,
                                                                  @RequestParam(required = true) Integer y,
                                                                  @RequestParam(required = true) Integer maximumDistance) {

        if (x < 0 || y < 0 || maximumDistance < 0) {
            throw new IllegalArgumentException("x, y, and maximumDistance must be greater than or equal to 0");
        }

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<PoiResponse> response = poiService.findPoiByCoordinates(pageable, x, y, maximumDistance);

        return ResponseEntity.ok(new ApiResponse<>(
                response.getContent(),
                PaginationDTO.fromPage(response)
        ));
    }
}
