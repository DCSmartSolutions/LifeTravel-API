package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterTourPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;

public interface TourPackageCommandService {

    TourPackage handle(RegisterTourPackageCommand registerUserCommand);

}
