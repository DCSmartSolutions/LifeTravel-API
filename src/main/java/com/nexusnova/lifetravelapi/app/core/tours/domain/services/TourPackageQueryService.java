package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackageByIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByRegionQuery;

import java.util.List;

public interface TourPackageQueryService {

    List<TourPackage> handle();
    List<TourPackage> handle(GetTourPackagesByRegionQuery query);
    TourPackage handle(GetTourPackageByIdQuery query);
}
