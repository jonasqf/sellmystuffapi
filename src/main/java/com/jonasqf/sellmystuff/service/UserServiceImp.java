package com.jonasqf.sellmystuff.service;

import com.jonasqf.sellmystuff.domain.Role;
import com.jonasqf.sellmystuff.domain.User;
import com.jonasqf.sellmystuff.repo.RoleRepo;
import com.jonasqf.sellmystuff.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("saving user {} to the DB", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {} to the DB", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        log.info("saving role {} to user {} to the DB", role.getName(), user.getUsername());
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("getting user {} from the DB", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all user from the DB");
        return userRepo.findAll();
    }
}
