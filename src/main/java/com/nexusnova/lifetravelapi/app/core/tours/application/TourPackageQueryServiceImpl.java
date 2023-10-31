package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackageByIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByRegionQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageQueryService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageQueryServiceImpl implements TourPackageQueryService {

    private final TourPackageRepository tourPackageRepository;

    public TourPackageQueryServiceImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public List<TourPackage> handle() {
        return tourPackageRepository.findAll();
    }

    @Override
    public List<TourPackage> handle(GetTourPackagesByRegionQuery query) {
        return tourPackageRepository.findByRegionId(query.regionId());
    }

    @Override
    public TourPackage handle(GetTourPackageByIdQuery query) {
        return tourPackageRepository.findById(query.tourPackageId())
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + query.tourPackageId()));
    }
}
