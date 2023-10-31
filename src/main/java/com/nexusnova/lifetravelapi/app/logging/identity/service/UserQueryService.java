package com.nexusnova.lifetravelapi.app.logging.identity.service;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.queries.GetUserByIdQuery;

public interface UserQueryService {

    User handle(GetUserByIdQuery query);
}
