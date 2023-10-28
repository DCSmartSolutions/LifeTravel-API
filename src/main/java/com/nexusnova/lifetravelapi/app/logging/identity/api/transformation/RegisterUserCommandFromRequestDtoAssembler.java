package com.nexusnova.lifetravelapi.app.logging.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;

public class RegisterUserCommandFromRequestDtoAssembler {
    public static RegisterUserCommand ToCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserCommand(requestDto);
    }
}
