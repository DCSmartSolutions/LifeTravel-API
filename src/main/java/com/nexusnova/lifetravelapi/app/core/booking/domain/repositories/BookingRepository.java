package com.nexusnova.lifetravelapi.app.core.booking.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b._deleted=false and b.touristUser.id=:userId")
    List<Booking> findByUserId(@Param("userId") String userId);
}
