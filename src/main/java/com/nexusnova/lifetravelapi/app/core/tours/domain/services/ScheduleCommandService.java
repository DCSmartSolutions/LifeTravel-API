package com.nexusnova.lifetravelapi.app.core.tours.domain.services;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.CreateScheduleCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;

public interface ScheduleCommandService {

    Schedule handle(CreateScheduleCommand command);
}
