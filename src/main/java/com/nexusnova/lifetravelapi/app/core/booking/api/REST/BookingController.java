package com.nexusnova.lifetravelapi.app.core.booking.api.REST;

import com.nexusnova.lifetravelapi.app.core.booking.api.transformation.BookingSummaryAssembler;
import com.nexusnova.lifetravelapi.app.core.booking.api.transformation.CreateBookingCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingTouristQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.queries.GetWeekBookingAgencyQuery;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingCommandService;
import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingQueryService;
import com.nexusnova.lifetravelapi.app.core.booking.mapper.BookingMapper;
import com.nexusnova.lifetravelapi.app.core.booking.resources.requests.BookingRequestDto;
import com.nexusnova.lifetravelapi.app.core.booking.resources.summaries.BookingSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.BOOKING_CREATED;

@RestController
@RequestMapping("/api/v1/booking")
@Tag(name="Bookings Controller")
@CrossOrigin
public class BookingController {

    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;
    private final BookingMapper bookingMapper;
    private final BookingSummaryAssembler bookingSummaryAssembler;

    @Autowired
    public BookingController(BookingCommandService bookingCommandService,
                             BookingQueryService bookingQueryService,
                             BookingMapper bookingMapper,
                             BookingSummaryAssembler bookingSummaryAssembler) {
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
        this.bookingMapper = bookingMapper;
        this.bookingSummaryAssembler = bookingSummaryAssembler;
    }

    @GetMapping("tourist/{touristId}")
    @Operation(summary = "Listado", description = "Listado de Bookings Por Turista.")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingSummaryDto> getBookingsByTourist(@Parameter @PathVariable("touristId") String touristId) {
        List<Map<String, Object>> bookings = bookingQueryService.handle(new GetWeekBookingTouristQuery(touristId));
        return bookingSummaryAssembler.toSummaryFromData(bookings);
    }

    @GetMapping("agency/{agencyId}")
    @Operation(summary = "Listado", description = "Listado de Bookings Por Agencia.")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingSummaryDto> getBookingsByAgency(@Parameter @PathVariable("agencyId") String agencyId) {
        List<Map<String, Object>> bookings = bookingQueryService.handle(new GetWeekBookingAgencyQuery(agencyId));
        return bookingSummaryAssembler.toSummaryFromData(bookings);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar Booking", description = "Permite registrar un booking.")
    public BookingSummaryDto save(@RequestBody @Valid BookingRequestDto bookingRequestDto,
                                      HttpServletResponse response) {
        Booking booking =
                bookingCommandService.handle(CreateBookingCommandFromRequestDtoAssembler.toCommandFromDto(bookingRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, BOOKING_CREATED);
        return bookingMapper.bookingToSummaryDto(booking);
    }
}
