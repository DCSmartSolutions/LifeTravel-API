package com.nexusnova.lifetravelapi.app.assets.api.rest;

import com.nexusnova.lifetravelapi.app.assets.api.transformation.RegisterTemperatureCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureCommandService;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureQueryService;
import com.nexusnova.lifetravelapi.app.assets.mapper.IOTMapper;
import com.nexusnova.lifetravelapi.app.assets.resources.requests.TemperatureRequestDto;
import com.nexusnova.lifetravelapi.app.assets.resources.summaries.TemperatureSummaryDto;
import com.nexusnova.lifetravelapi.app.shared.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.app.shared.messages.ConfigurationMessages.TEMPERATURE_REGISTERED;
import java.util.List;

@RestController
@RequestMapping("/api/v1/temperature")
@Tag(name="Temperature Controller")
@CrossOrigin
public class TemperatureController {
    private final TemperatureCommandService temperatureCommandService;
    private final TemperatureQueryService temperatureQueryService;
    private final IOTMapper iotMapper;

    public TemperatureController(TemperatureCommandService temperatureCommandService, TemperatureQueryService temperatureQueryService, IOTMapper iotMapper) {
        this.temperatureCommandService = temperatureCommandService;
        this.temperatureQueryService = temperatureQueryService;
        this.iotMapper = iotMapper;
    }


    @GetMapping("/")
    @Operation(summary = "Get Temperatures", description = "Get the temperature of all locations")
    public List<Temperature> getTemperature() {
        return temperatureQueryService.getTemperatures();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Temperature", description = "Get the temperature of a location by id")
    public Temperature getTemperatureById(@PathVariable Long id) {
        return temperatureQueryService.getTemperatureById(id);
    }

    @PostMapping("/")
    @Operation(summary = "Add Temperature", description = "Add a new temperature")
    public Temperature addTemperature(@RequestBody Temperature temperature) {
        return temperatureCommandService.addTemperature(temperature);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register Temperature", description = "Register a new temperature")
    public TemperatureSummaryDto registerTemperature(@RequestBody @Valid TemperatureRequestDto temperatureRequestDto, HttpServletResponse response) {
        Temperature temperature = temperatureCommandService.handle(RegisterTemperatureCommandFromRequestDtoAssembler.toCommandFromDto(temperatureRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, TEMPERATURE_REGISTERED);
        return iotMapper.temperatureToSummaryDto(temperature);
    }
}
