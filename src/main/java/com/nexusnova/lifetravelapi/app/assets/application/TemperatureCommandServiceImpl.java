package com.nexusnova.lifetravelapi.app.assets.application;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;
import com.nexusnova.lifetravelapi.app.assets.domain.repositories.TemperatureRepository;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureCommandServiceImpl implements TemperatureCommandService {

    private final TemperatureRepository temperatureRepository;
    private final RegionRepository regionRepository;

    public TemperatureCommandServiceImpl(TemperatureRepository temperatureRepository, RegionRepository regionRepository) {
        this.temperatureRepository = temperatureRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Temperature addTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    @Override
    public Temperature updateTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    public List<Temperature> addTemperatures(List<Temperature> temperatures) {
        return temperatureRepository.saveAll(temperatures);
    }
}
