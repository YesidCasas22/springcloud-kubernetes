package org.ymcasas.springcloud.msvc.users.services;

import org.ymcasas.springcloud.msvc.users.models.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User byId(Long id);
    User save(User user);
    void delete(Long id);
}
