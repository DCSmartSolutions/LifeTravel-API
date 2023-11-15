package com.nexusnova.lifetravelapi.app.core.booking.domain.repositories;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b._deleted=false and b.touristUser.id=:userId")
    List<Booking> findByUserId(@Param("userId") String userId);

    @Query("select DISTINCT new map(b.tourPackage.id as tourPackageId, b.selectedDate as selectedDate) " +
            "from Booking b " +
            "where b._deleted=false and b.agencyUser.id=:agencyUserId and b.selectedDate between :startWeek and :endWeek")
    List<Map<String, Object>> findByWeekByAgency(@Param("startWeek") Date startWeek, @Param("endWeek") Date endWeek,
                                                 @Param("agencyUserId") String agencyUserId);

    @Query("select DISTINCT new map(b.tourPackage.id as tourPackageId, b.selectedDate as selectedDate) " +
            "from Booking b " +
            "where b._deleted=false and b.touristUser.id=:touristUserId and b.selectedDate between :startWeek and :endWeek")
    List<Map<String, Object>> findByWeekByTourist(@Param("startWeek") Date startWeek, @Param("endWeek") Date endWeek,
                                                 @Param("touristUserId") String touristUserId);

}
