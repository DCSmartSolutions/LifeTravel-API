package com.nexusnova.lifetravelapi.app.IOT.domain.services;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateLocationCommand;

public interface TrackingWereableCommandService {

    void handle(UpdateLocationCommand command);
}
