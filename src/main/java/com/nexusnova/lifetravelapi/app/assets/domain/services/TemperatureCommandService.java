package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;

public interface TemperatureCommandService {
    Temperature createTemperature(Temperature temperature);
    Temperature updateTemperature(Temperature temperature);
}
