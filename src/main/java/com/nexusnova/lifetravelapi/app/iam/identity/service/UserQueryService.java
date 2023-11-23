package com.nexusnova.lifetravelapi.app.iam.identity.service;

import com.nexusnova.lifetravelapi.app.iam.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.iam.identity.domain.queries.GetUserByIdQuery;

public interface UserQueryService {

    User handle(GetUserByIdQuery query);
}
