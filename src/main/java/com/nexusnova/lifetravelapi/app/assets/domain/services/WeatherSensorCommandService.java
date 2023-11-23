package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateWeatherCommand;

public interface WeatherSensorCommandService {

    void handle(UpdateWeatherCommand command);

}
