package com.jonasqf.sellmystuff.repo;

import com.jonasqf.sellmystuff.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
