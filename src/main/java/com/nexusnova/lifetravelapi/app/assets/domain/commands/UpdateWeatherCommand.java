package com.nexusnova.lifetravelapi.app.assets.domain.commands;


import com.nexusnova.lifetravelapi.app.assets.resources.requests.WeatherSensorRequestDto;

public record UpdateWeatherCommand(Long id, WeatherSensorRequestDto requestDto) {
}
