package com.nexusnova.lifetravelapi.app.core.tours.domain.commands;

import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;

public record CreateScheduleCommand(Long packageId, ScheduleDto scheduleDto){
}
