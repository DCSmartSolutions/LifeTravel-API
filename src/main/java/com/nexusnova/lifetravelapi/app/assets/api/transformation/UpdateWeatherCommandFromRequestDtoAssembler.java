package com.nexusnova.lifetravelapi.app.assets.api.transformation;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateWeatherCommand;
import com.nexusnova.lifetravelapi.app.assets.resources.requests.WeatherSensorRequestDto;

public class UpdateWeatherCommandFromRequestDtoAssembler {
    public static UpdateWeatherCommand toCommandFromDto(Long id, WeatherSensorRequestDto requestDto) {
        return new UpdateWeatherCommand(id, requestDto);
    }
}