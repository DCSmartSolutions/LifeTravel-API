package com.nexusnova.lifetravelapi.app.iam.profile.service;

import com.nexusnova.lifetravelapi.app.iam.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.queries.GetTouristByUserId;

public interface TouristQueryService {

    Tourist handle(GetTouristByUserId query);
}
