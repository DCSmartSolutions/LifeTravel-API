package com.nexusnova.lifetravelapi.app.logging.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.logging.profile.resources.requests.AgencyRequestDto;

public record UpdateAgencyInfoCommand (AgencyRequestDto agencyRequestDto) {
}
