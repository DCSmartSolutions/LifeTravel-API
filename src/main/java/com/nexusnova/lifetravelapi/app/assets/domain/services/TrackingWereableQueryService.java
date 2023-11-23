package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.queries.GetTrackingWereablesByAgencyQuery;
import com.nexusnova.lifetravelapi.app.assets.resources.summaries.TrackingWereableSummayDto;

import java.util.List;

public interface TrackingWereableQueryService {

    List<TrackingWereableSummayDto> handle(GetTrackingWereablesByAgencyQuery query);
}
