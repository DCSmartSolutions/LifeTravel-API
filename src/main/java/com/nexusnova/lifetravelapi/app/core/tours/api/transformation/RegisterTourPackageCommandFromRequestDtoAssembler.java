package com.nexusnova.lifetravelapi.app.core.tours.api.transformation;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterTourPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;

public class RegisterTourPackageCommandFromRequestDtoAssembler {
    public static RegisterTourPackageCommand toCommandFromDto(TourPackageRequestDto requestDto) {
        return new RegisterTourPackageCommand(requestDto);
    }
}