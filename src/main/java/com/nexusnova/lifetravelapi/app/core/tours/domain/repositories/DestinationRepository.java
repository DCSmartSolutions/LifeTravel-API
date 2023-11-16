package com.nexusnova.lifetravelapi.app.core.tours.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByLatitudeAndLongitudeAndName(BigDecimal latitude, BigDecimal longitude, String name);
}
