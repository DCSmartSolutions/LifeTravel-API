package com.nexusnova.lifetravelapi.app.assets.application;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateWeatherCommand;
import com.nexusnova.lifetravelapi.app.assets.domain.model.WeatherSensor;
import com.nexusnova.lifetravelapi.app.assets.domain.repositories.WeatherSensorRepository;
import com.nexusnova.lifetravelapi.app.assets.domain.services.WeatherSensorCommandService;
import com.nexusnova.lifetravelapi.app.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WeatherSensorCommandServiceImpl implements WeatherSensorCommandService {

    private final WeatherSensorRepository weatherSensorRepository;

    public WeatherSensorCommandServiceImpl(WeatherSensorRepository weatherSensorRepository) {
        this.weatherSensorRepository = weatherSensorRepository;
    }

    @Override
    public void handle(UpdateWeatherCommand command) {
        WeatherSensor weatherSensor = weatherSensorRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("WeatherSensor not found with id: " + command.id()));

        weatherSensor.setTemperature(command.requestDto().getTemperature());
        weatherSensor.setHumidity(command.requestDto().getHumidity());

        weatherSensorRepository.save(weatherSensor);
    }
}
