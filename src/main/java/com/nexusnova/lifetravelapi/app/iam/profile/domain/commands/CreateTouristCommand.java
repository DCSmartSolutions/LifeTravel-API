package com.nexusnova.lifetravelapi.app.iam.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.iam.profile.resources.requests.TouristRequestDto;

public record CreateTouristCommand(Long id, TouristRequestDto touristRequestDto) {
}
