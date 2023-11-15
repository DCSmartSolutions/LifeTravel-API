package com.nexusnova.lifetravelapi.app.core.tours.mapper;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.*;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.*;
import com.nexusnova.lifetravelapi.app.core.tours.resources.summaries.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToursMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
    })
    ActivitySummaryDto activityToSummaryDto(Activity entity);
    List<ActivitySummaryDto> activityToSummaryDtos(List<Activity> entities);

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "departmentName", source = "entity.department.name"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "price", source = "entity.price"),
            @Mapping(target = "rating", source = "entity.rating"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
            @Mapping(target = "visible", source = "entity.visible"),
    })
    TourPackageSummaryDto tourPackageToSummaryDto(TourPackage entity);
    List<TourPackageSummaryDto> tourPackageToSummaryDtos(List<TourPackage> entities);

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "title", source = "entity.title"),
            @Mapping(target = "departmentName", source = "entity.department.name"),
            @Mapping(target = "description", source = "entity.description"),
            @Mapping(target = "imgUrl", source = "entity.imgUrl"),
            @Mapping(target = "rating", source = "entity.rating"),
            @Mapping(target = "meetingPointLatitude", source = "entity.latitude"),
            @Mapping(target = "meetingPointLongitude", source = "entity.longitude"),
    })
    TourPackageDetailDto tourPackageToDetailDto(TourPackage entity);
    List<TourPackageDetailDto> tourPackageToDetailDtos(List<TourPackage> entities);
}
