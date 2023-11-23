package com.nexusnova.lifetravelapi.app.assets.api.transformation;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateLocationCommand;
import com.nexusnova.lifetravelapi.app.assets.resources.requests.TrackingWereableRequestDto;

public class UpdateLocationCommandFromRequestDtoAssembler {
    public static UpdateLocationCommand toCommandFromDto(Long id, TrackingWereableRequestDto requestDto) {
        return new UpdateLocationCommand(id, requestDto);
    }
}
