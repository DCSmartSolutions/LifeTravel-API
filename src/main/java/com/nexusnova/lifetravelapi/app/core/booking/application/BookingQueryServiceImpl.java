package com.nexusnova.lifetravelapi.app.core.booking.application;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingAgencyQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.repositories.BookingRepository;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingQueryService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    private final BookingRepository scheduleRepository;

    public BookingQueryServiceImpl(BookingRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Map<String, Object>> handle(GetWeekBookingTouristQuery query) {
        LocalDate today = LocalDate.now();

        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));

        Instant startWeek = monday.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endWeek = sunday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        List<Map<String, Object>> bookings = scheduleRepository.findByWeekByTourist(java.util.Date.from(startWeek),
                java.util.Date.from(endWeek), query.touristUserId());

        return bookings;
    }

    @Override
    public List<Map<String, Object>> handle(GetWeekBookingAgencyQuery query) {
        LocalDate today = LocalDate.now();

        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));

        Instant startWeek = monday.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant endWeek = sunday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        List<Map<String, Object>> bookings = scheduleRepository.findByWeekByAgency(java.util.Date.from(startWeek),
                java.util.Date.from(endWeek), query.agencyUserId());

        return bookings;
    }
}
