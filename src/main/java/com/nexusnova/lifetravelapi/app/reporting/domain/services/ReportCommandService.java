package com.nexusnova.lifetravelapi.app.reporting.domain.services;

import com.nexusnova.lifetravelapi.app.reporting.domain.commands.GenerateReportCommand;
import com.nexusnova.lifetravelapi.app.reporting.domain.model.Report;

public interface ReportCommandService {
    Report handle(GenerateReportCommand command);
}
