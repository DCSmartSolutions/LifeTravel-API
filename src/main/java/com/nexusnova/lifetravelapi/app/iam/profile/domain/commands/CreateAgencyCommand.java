package com.nexusnova.lifetravelapi.app.iam.profile.domain.commands;

import com.nexusnova.lifetravelapi.app.iam.profile.resources.requests.AgencyRequestDto;

public record CreateAgencyCommand(String id, AgencyRequestDto agencyRequestDto) {
}
