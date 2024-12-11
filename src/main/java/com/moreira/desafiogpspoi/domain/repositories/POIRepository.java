package com.moreira.desafiogpspoi.domain.repositories;

import com.moreira.desafiogpspoi.domain.model.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface POIRepository extends JpaRepository<PointOfInterest, Long> {
}
