package org.ymcasas.springcloud.msvc.users.services;

import org.ymcasas.springcloud.msvc.users.models.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> list();
    Optional<User> byId(Long id);
    User save(User user);
    void delete(Long id);
}
