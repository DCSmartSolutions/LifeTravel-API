package com.nexusnova.lifetravelapi.app.IOT.domain.repositories;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWereable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingWereableRepository extends JpaRepository<TrackingWereable, Long> {
}
