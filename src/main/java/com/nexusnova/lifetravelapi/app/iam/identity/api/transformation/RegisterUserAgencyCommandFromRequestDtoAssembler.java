package com.nexusnova.lifetravelapi.app.iam.identity.api.transformation;

import com.nexusnova.lifetravelapi.app.iam.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.iam.identity.resources.requests.UserRequestDto;

public class RegisterUserAgencyCommandFromRequestDtoAssembler {
    public static RegisterUserAgencyCommand toCommandFromDto(UserRequestDto requestDto){
        return new RegisterUserAgencyCommand(requestDto);
    }
}
