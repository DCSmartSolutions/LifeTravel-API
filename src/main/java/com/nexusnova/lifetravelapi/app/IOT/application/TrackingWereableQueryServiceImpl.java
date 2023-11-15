package com.nexusnova.lifetravelapi.app.IOT.application;

import com.nexusnova.lifetravelapi.app.IOT.domain.queries.GetTrackingWereablesByAgencyQuery;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.TrackingWereableRepository;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWereableQueryService;
import com.nexusnova.lifetravelapi.app.IOT.resources.summaries.TrackingWereableSummayDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingWereableQueryServiceImpl implements TrackingWereableQueryService {

    private final TrackingWereableRepository trackingWereableRepository;

    public TrackingWereableQueryServiceImpl(TrackingWereableRepository trackingWereableRepository) {
        this.trackingWereableRepository = trackingWereableRepository;
    }

    @Override
    public List<TrackingWereableSummayDto> handle(GetTrackingWereablesByAgencyQuery query) {
        return null;
    }
}
