package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateLocationCommand;

public interface TrackingWearableCommandService {
    void handle(UpdateLocationCommand command);
}
