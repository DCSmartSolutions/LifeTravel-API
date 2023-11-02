package com.nexusnova.lifetravelapi.app.core.booking.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Agency;
import com.sun.source.tree.LambdaExpressionTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b._deleted=false and b.tourist.user.id=:userId")
    List<Booking> findByUserId(@Param("userId") String userId);
}
