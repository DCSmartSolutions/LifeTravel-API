package com.nexusnova.lifetravelapi.app.iam.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.iam.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.iam.identity.resources.requests.UserRequestDto;

public class RegisterUserTouristCommandFromRequestDtoAssembler {
    public static RegisterUserTouristCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserTouristCommand(requestDto);
    }
}
