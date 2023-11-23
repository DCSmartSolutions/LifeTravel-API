package com.nexusnova.lifetravelapi.app.assets.domain.commands;

import com.nexusnova.lifetravelapi.app.assets.resources.requests.TrackingWereableRequestDto;

public record UpdateLocationCommand(Long id, TrackingWereableRequestDto requestDto) {
}
