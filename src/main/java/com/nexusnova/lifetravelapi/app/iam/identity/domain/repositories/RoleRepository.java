package com.nexusnova.lifetravelapi.app.iam.identity.domain.repositories;

import com.nexusnova.lifetravelapi.app.iam.identity.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

