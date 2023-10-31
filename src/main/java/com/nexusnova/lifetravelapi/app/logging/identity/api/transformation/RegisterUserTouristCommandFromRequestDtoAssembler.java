package com.nexusnova.lifetravelapi.app.logging.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;

public class RegisterUserTouristCommandFromRequestDtoAssembler {
    public static RegisterUserTouristCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserTouristCommand(requestDto);
    }
}
