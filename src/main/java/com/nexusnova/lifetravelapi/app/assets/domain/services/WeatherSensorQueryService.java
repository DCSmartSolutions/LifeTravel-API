package com.nexusnova.lifetravelapi.app.assets.domain.services;

import com.nexusnova.lifetravelapi.app.assets.domain.queries.GetWeaterByTouristQuery;
import com.nexusnova.lifetravelapi.app.assets.resources.summaries.WeatherSummaryDto;

public interface WeatherSensorQueryService {

    WeatherSummaryDto handle(GetWeaterByTouristQuery query);
}
