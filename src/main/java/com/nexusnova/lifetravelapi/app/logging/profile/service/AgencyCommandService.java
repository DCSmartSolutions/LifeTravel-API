package com.nexusnova.lifetravelapi.app.logging.profile.service;

import com.nexusnova.lifetravelapi.app.logging.profile.domain.commands.UpdateAgencyPhotoCommand;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Agency;

public interface AgencyCommandService {
    Agency handle(UpdateAgencyPhotoCommand updateAgencyPhotoCommand);
}
