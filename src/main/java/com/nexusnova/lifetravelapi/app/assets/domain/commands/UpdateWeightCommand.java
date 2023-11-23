package com.nexusnova.lifetravelapi.app.assets.domain.commands;

import com.nexusnova.lifetravelapi.app.assets.resources.requests.WeightBalanceRequestDto;

public record UpdateWeightCommand(Long id, WeightBalanceRequestDto requestDto) {
}
