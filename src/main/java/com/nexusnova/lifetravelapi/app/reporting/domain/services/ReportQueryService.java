package com.nexusnova.lifetravelapi.app.reporting.domain.services;

import com.nexusnova.lifetravelapi.app.reporting.domain.model.GetReportByAgencyQuery;
import com.nexusnova.lifetravelapi.app.reporting.domain.model.Report;

import java.util.List;

public interface ReportQueryService {
    List<Report> handle(GetReportByAgencyQuery query);
}
