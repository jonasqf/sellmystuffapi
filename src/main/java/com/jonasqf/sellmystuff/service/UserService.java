package com.jonasqf.sellmystuff.service;

import com.jonasqf.sellmystuff.domain.User;
import com.jonasqf.sellmystuff.domain.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
