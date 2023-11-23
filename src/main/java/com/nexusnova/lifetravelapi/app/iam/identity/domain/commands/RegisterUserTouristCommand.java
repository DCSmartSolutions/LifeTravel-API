package com.nexusnova.lifetravelapi.app.iam.identity.domain.commands;

import com.nexusnova.lifetravelapi.app.iam.identity.resources.requests.UserRequestDto;

public record RegisterUserTouristCommand(UserRequestDto userRequestDto) {
}
