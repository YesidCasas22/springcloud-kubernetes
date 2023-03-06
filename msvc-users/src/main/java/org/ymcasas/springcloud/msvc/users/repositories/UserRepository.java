package org.ymcasas.springcloud.msvc.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.ymcasas.springcloud.msvc.users.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
