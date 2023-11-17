package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.RegionRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.RegionQueryService;
import org.springframework.stereotype.Service;

@Service
public class RegionQueryServiceImpl implements RegionQueryService {
    RegionRepository regionRepository;
    public RegionQueryServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }
    @Override
    public Region handle(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Region not found"));
    }
}
