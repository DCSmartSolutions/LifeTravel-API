package com.nexusnova.lifetravelapi.app.iam.profile.api.transformation;

import com.nexusnova.lifetravelapi.app.iam.profile.domain.commands.CreateAgencyCommand;
import com.nexusnova.lifetravelapi.app.iam.profile.resources.requests.AgencyRequestDto;

public class RegisterAgencyCommandFromDtoAssembler {
    public static CreateAgencyCommand toCommandFromDto(String uid, AgencyRequestDto requestDto){
        return new CreateAgencyCommand(uid, requestDto);
    }
}
