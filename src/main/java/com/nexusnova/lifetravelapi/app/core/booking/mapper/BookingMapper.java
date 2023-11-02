package com.nexusnova.lifetravelapi.app.core.booking.mapper;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.core.booking.resources.summaries.BookingSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "tourPackageId", source = "entity.tourExperience.tourPackage.id"),
            @Mapping(target = "tourExperienceDate", source = "entity.tourExperience.startDate"),
            @Mapping(target = "tourPackageTitle", source = "entity.tourExperience.tourPackage.title"),
            @Mapping(target = "agencyName", source = "entity.tourExperience.tourPackage.agency.legalName"),
            @Mapping(target = "imgUrl", source = "entity.tourExperience.tourPackage.imgUrl"),
    })
    BookingSummaryDto bookingToSummaryDto(Booking entity);
    List<BookingSummaryDto> bookingToSummaryDtos(List<Booking> entities);
}
