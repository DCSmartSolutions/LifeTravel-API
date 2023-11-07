package com.nexusnova.lifetravelapi.app.IOT.domain.services;


import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateWeightCommand;

public interface WeightBalanceCommandService {
    void handle(UpdateWeightCommand command);

}
