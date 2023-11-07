package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateLocationCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWearableCommandService;
import com.nexusnova.lifetravelapi.app.IOT.mapper.IOTMapper;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.TrackingWereableRequestDto;
import com.nexusnova.lifetravelapi.app.shared.util.MessageUtil;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.GPS_UPDATED;

@RestController
@RequestMapping("/api/v1/gps")
@Tag(name="Tracking Wereable Controller")
@CrossOrigin
public class TrackingWearableController {

    private final TrackingWearableCommandService trackingWereableCommandService;
    private final MessageUtil messageUtil;
    private final IOTMapper iotMapper;


    public TrackingWearableController(TrackingWearableCommandService trackingWereableCommandService,
                                      MessageUtil messageUtil,
                                      IOTMapper iotMapper) {
        this.trackingWereableCommandService = trackingWereableCommandService;
        this.messageUtil = messageUtil;
        this.iotMapper = iotMapper;
    }


    @PutMapping("/update-location/{gpsId}")
    @Operation(summary = "Actualizar Ubicacion", description = "Permite actualizar la ubicacion del GPS Tracker.")
    public void updateLocation(@Parameter @PathVariable("gpsId") Long gpsId,
                               @RequestBody @Valid TrackingWereableRequestDto requestDto,
                               HttpServletResponse response) {
        trackingWereableCommandService.handle(UpdateLocationCommandFromRequestDtoAssembler.toCommandFromDto(gpsId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(GPS_UPDATED));
    }
}
