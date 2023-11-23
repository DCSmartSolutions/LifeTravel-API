package com.nexusnova.lifetravelapi.app.iam.profile.service;

import com.nexusnova.lifetravelapi.app.iam.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.iam.profile.domain.queries.GetAgencyByUserId;

public interface AgencyQueryService {

    Agency handle(GetAgencyByUserId query);
}
