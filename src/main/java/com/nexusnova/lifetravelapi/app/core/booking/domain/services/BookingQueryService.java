package com.nexusnova.lifetravelapi.app.core.booking.domain.services;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetBookingByTouristUserIdQuery;

import java.util.List;

public interface BookingQueryService {

    List<Booking> handle(GetBookingByTouristUserIdQuery query);
}
