package com.nexusnova.lifetravelapi.app.core.booking.application;

import com.nexusnova.lifetravelapi.app.core.booking.domain.commands.CreateBookingCommand;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.repositories.BookingRepository;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingCommandService;
import com.nexusnova.lifetravelapi.app.core.booking.resources.requests.BookingRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourExperience;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import com.nexusnova.lifetravelapi.app.shared.domain.model.SerieNumber;
import com.nexusnova.lifetravelapi.app.shared.domain.repositories.SerieNumberRepository;
import com.nexusnova.lifetravelapi.app.shared.util.SerieNumberUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.nexusnova.lifetravelapi.app.shared.util.CoreConstants.BOOKING_TYPE_SERIE_NUMBER;

@Service
public class BookingCommandServiceImpl implements BookingCommandService {

    private final BookingRepository bookingRepository;
    private final ValidationUtil validationUtil;
    private final SerieNumberUtil serieNumberUtil;
    private final SerieNumberRepository serieNumberRepository;

    public BookingCommandServiceImpl(BookingRepository bookingRepository,
                                     ValidationUtil validationUtil,
                                     SerieNumberUtil serieNumberUtil,
                                     SerieNumberRepository serieNumberRepository) {
        this.bookingRepository = bookingRepository;
        this.validationUtil = validationUtil;
        this.serieNumberUtil = serieNumberUtil;
        this.serieNumberRepository = serieNumberRepository;
    }

    @Override
    public Booking handle(CreateBookingCommand command) {
        BookingRequestDto requestDto = command.requestDto();

        Booking booking = new Booking();
        Tourist tourist = validationUtil.findTouristById(requestDto.getTouristId());
        TourExperience tourExperience = validationUtil.findTourExperienceById(requestDto.getTourExperienceId());
        SerieNumber serieNumber = serieNumberUtil.generateCorrelative(BOOKING_TYPE_SERIE_NUMBER);

        booking.setTourist(tourist);
        booking.setTourExperience(tourExperience);
        booking.setDate(new Date());
        booking.setSerie(serieNumber.getSerie());
        booking.setNumber(serieNumber.getNumber());

        serieNumberRepository.save(serieNumber);
        bookingRepository.save(booking);
        return booking;
    }
}
