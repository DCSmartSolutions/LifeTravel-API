package com.nexusnova.lifetravelapi.app.core.booking.application;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetBookingByTouristUserIdQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.repositories.BookingRepository;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {

    private final BookingRepository bookingRepository;

    public BookingQueryServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> handle(GetBookingByTouristUserIdQuery query) {
        return bookingRepository.findByUserId(query.touristUserId());
    }
}
