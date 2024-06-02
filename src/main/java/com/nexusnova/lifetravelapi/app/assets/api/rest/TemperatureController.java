package com.nexusnova.lifetravelapi.app.assets.api.rest;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureCommandService;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/temperature")
@Tag(name="Temperature Controller")
@CrossOrigin
public class TemperatureController {
    private final TemperatureCommandService temperatureCommandService;
    private final TemperatureQueryService temperatureQueryService;

    public TemperatureController(TemperatureCommandService temperatureCommandService, TemperatureQueryService temperatureQueryService) {
        this.temperatureCommandService = temperatureCommandService;
        this.temperatureQueryService = temperatureQueryService;
    }


    @GetMapping("/")
    @Operation(summary = "Get Temperatures", description = "Get the temperature of all locations")
    public List<Temperature> getTemperature() {
        return temperatureQueryService.getTemperatures();
    }

}
