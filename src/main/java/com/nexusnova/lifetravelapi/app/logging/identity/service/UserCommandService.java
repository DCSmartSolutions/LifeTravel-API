package com.nexusnova.lifetravelapi.app.logging.identity.service;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;

public interface UserCommandService {
    User handle(RegisterUserTouristCommand registerUserCommand);
    User handle(RegisterUserAgencyCommand registerUserCommand);
}
