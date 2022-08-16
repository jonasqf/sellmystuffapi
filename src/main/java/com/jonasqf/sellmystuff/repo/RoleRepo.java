package com.jonasqf.sellmystuff.repo;

import com.jonasqf.sellmystuff.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
