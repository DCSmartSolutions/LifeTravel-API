package com.nexusnova.lifetravelapi.app.logging.identity.service;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;

public interface UserCommandService {
    User handle(RegisterUserCommand registerUserCommand);
}
