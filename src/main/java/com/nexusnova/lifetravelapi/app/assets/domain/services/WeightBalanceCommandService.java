package com.nexusnova.lifetravelapi.app.assets.domain.services;


import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateWeightCommand;
import com.nexusnova.lifetravelapi.app.assets.domain.model.WeightBalance;
import com.nexusnova.lifetravelapi.app.assets.domain.queries.GetWeightBalanceByIdQuery;

public interface WeightBalanceCommandService {
    WeightBalance handle(UpdateWeightCommand command);
    WeightBalance handle(GetWeightBalanceByIdQuery command);

}
