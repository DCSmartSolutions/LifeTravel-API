package com.nexusnova.lifetravelapi.app.IOT.mapper;

import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.TrackingWereableSummayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IOTMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),

    })
    TrackingWereableSummayDto gpsToSummaryDto(TrackingWearable entity);
    List<TrackingWereableSummayDto> gpsToSummaryDtos(List<TrackingWearable> entities);
}
