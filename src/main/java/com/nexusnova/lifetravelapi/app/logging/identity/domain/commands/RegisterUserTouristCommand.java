package com.nexusnova.lifetravelapi.app.logging.identity.domain.commands;

import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;

public record RegisterUserTouristCommand(UserRequestDto userRequestDto) {
}
