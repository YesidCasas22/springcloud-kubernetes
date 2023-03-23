package org.ymcasas.springcloud.msvc.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ymcasas.springcloud.msvc.users.exceptions.NoDataFoundException;
import org.ymcasas.springcloud.msvc.users.exceptions.UserNotFoundException;
import org.ymcasas.springcloud.msvc.users.models.User;
import org.ymcasas.springcloud.msvc.users.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> list() {

        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException();
        }
        return users;

    }

    @Override
    @Transactional(readOnly = true)
    public User byId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
