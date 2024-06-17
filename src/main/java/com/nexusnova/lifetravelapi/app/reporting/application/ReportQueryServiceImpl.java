package com.nexusnova.lifetravelapi.app.reporting.application;

import com.nexusnova.lifetravelapi.app.reporting.domain.model.GetReportByAgencyQuery;
import com.nexusnova.lifetravelapi.app.reporting.domain.model.Report;
import com.nexusnova.lifetravelapi.app.reporting.domain.repositories.ReportRepository;
import com.nexusnova.lifetravelapi.app.reporting.domain.services.ReportQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {
    private final ReportRepository reportRepository;

    public ReportQueryServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> handle(GetReportByAgencyQuery query) {
        return reportRepository.findByAgencyId(query.agencyId());
    }
}
