package com.nexusnova.lifetravelapi.app.assets.application;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;
import com.nexusnova.lifetravelapi.app.assets.domain.repositories.TemperatureRepository;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureCommandService;
import org.springframework.stereotype.Service;

@Service
public class TemperatureCommandServiceImpl implements TemperatureCommandService {

    private final TemperatureRepository temperatureRepository;

    public TemperatureCommandServiceImpl(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public Temperature createTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    @Override
    public Temperature updateTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }
}
