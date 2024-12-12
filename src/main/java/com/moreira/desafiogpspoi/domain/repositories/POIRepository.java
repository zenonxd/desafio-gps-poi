package com.moreira.desafiogpspoi.domain.repositories;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface POIRepository extends JpaRepository<PointOfInterest, Long> {

    @Query(value =
        "SELECT * FROM tb_point_of_interest POI WHERE " +
                "SQRT(POW(poi.x - :x, 2) + POW(poi.y - :y, 2)) <= :maximumDistance",
    nativeQuery = true)
    Page<PointOfInterest> findPointOfInterestByCoordinates(@Param("x") int x,
                                                           @Param("y") int y,
                                                           @Param("maximumDistance") int maximumDistance,
                                                           Pageable pageable);
}
