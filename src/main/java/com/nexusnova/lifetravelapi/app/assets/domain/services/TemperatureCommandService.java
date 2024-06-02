package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;

import java.util.List;

public interface TemperatureCommandService {
    Temperature addTemperature(Temperature temperature);
    Temperature updateTemperature(Temperature temperature);
    List<Temperature> addTemperatures(List<Temperature> temperatures);
}
