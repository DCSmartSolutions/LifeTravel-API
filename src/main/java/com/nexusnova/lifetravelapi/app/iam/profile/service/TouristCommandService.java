package com.nexusnova.lifetravelapi.app.iam.profile.service;

import com.nexusnova.lifetravelapi.app.iam.profile.domain.commands.CreateTouristCommand;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.commands.UpdateTouristInfoCommand;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.model.Tourist;

public interface TouristCommandService {

    Tourist handle(UpdateTouristInfoCommand command);
    Tourist handle(CreateTouristCommand command);
}
