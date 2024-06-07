package com.nexusnova.lifetravelapi.app.iam.identity.application;

import com.nexusnova.lifetravelapi.app.iam.identity.domain.commands.RegisterUserAgencyCommand;
import com.nexusnova.lifetravelapi.app.iam.identity.domain.commands.RegisterUserTouristCommand;
import com.nexusnova.lifetravelapi.app.iam.identity.domain.model.Role;
import com.nexusnova.lifetravelapi.app.iam.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.iam.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.iam.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.iam.identity.service.UserCommandService;
import com.nexusnova.lifetravelapi.app.shared.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository,
                                  ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public User handle(RegisterUserTouristCommand registerUserCommand) {
        User user = new User();
        Role role = validationUtil.getTouristRole();

        return getUser(user, role, registerUserCommand.userRequestDto());
    }

    @Override
    public User handle(RegisterUserAgencyCommand registerUserCommand) {
        User user = new User();
        Role role = validationUtil.getAgencyRole();

        return getUser(user, role, registerUserCommand.userRequestDto());
    }

    private User getUser(User user, Role role, UserRequestDto userRequestDto) {
        user.setEmail(userRequestDto.getEmail());
        user.setGoogleName(userRequestDto.getName());
        if (userRequestDto.getPhotoUrl() != null)  {
            user.setGooglePhotoUrl(userRequestDto.getPhotoUrl());
        }
        user.setRole(role);

        userRepository.save(user);
        return user;
    }
}
