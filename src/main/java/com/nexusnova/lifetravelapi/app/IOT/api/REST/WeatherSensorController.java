package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateWeatherCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeatherSensorCommandService;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeatherSensorRequestDto;
import com.nexusnova.lifetravelapi.app.shared.util.MessageUtil;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.WEATHER_SENSOR_UPDATED;

@RestController
@RequestMapping("/api/v1/weather-sensors")
@Tag(name="Weather Sensors Controller")
@CrossOrigin
public class WeatherSensorController {

    private final WeatherSensorCommandService weatherSensorCommandService;
    private final MessageUtil messageUtil;

    @Autowired
    public WeatherSensorController(WeatherSensorCommandService weatherSensorCommandService,
                                   MessageUtil messageUtil) {
        this.weatherSensorCommandService = weatherSensorCommandService;
        this.messageUtil = messageUtil;
    }

    @PutMapping("/update-weather/{sensorId}")
    @Operation(summary = "Actualizar Ubicacion", description = "Permite actualizar la ubicacion del GPS Tracker.")
    public void updateLocation(@Parameter @PathVariable("sensorId") Long sensorId,
                               @RequestBody @Valid WeatherSensorRequestDto requestDto,
                               HttpServletResponse response) {
        weatherSensorCommandService.handle(UpdateWeatherCommandFromRequestDtoAssembler.toCommandFromDto(sensorId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(WEATHER_SENSOR_UPDATED));
    }
}
