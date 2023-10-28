package com.nexusnova.lifetravelapi.app.logging.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.logging.profile.resources.requests.TouristRequestDto;

public record CreateTouristCommand(TouristRequestDto touristRequestDto) {
}
