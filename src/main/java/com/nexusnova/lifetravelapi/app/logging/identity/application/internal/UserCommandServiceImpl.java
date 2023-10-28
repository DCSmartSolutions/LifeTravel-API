package com.nexusnova.lifetravelapi.app.logging.identity.application.internal;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.commands.RegisterUserCommand;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.logging.identity.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RegisterUserCommand registerUserCommand) {
        User user = new User();
        user.setId(registerUserCommand.userRequestDto().getId());
        user.setEmail(registerUserCommand.userRequestDto().getEmail());
        user.setGoogleName(registerUserCommand.userRequestDto().getName());
        user.setGooglePhotoUrl(registerUserCommand.userRequestDto().getPhotoUrl());

        userRepository.save(user);
        return user;
    }
}
