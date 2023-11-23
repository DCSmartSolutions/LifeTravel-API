package com.nexusnova.lifetravelapi.app.iam.profile.service;

import com.nexusnova.lifetravelapi.app.iam.profile.domain.commands.CreateAgencyCommand;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.commands.UpdateAgencyPhotoCommand;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.model.Agency;

public interface AgencyCommandService {
    Agency handle(UpdateAgencyPhotoCommand command);
    Agency handle(CreateAgencyCommand command);
}
