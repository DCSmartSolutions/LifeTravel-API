package com.nexusnova.lifetravelapi.app.assets.api.transformation;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateWeightCommand;
import com.nexusnova.lifetravelapi.app.assets.resources.requests.WeightBalanceRequestDto;

public class UpdateWeightBalanceCommandFromRequestDtoAssembler {
    public static UpdateWeightCommand toCommandFromDto(Long id, WeightBalanceRequestDto requestDto) {
        return new UpdateWeightCommand(id, requestDto);
    }
}
