package com.nexusnova.lifetravelapi.app.logging.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;

public class RegisterUserAgencyCommandFromRequestDtoAssembler {

    public static RegisterUserAgencyCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserAgencyCommand(requestDto);
    }
}
