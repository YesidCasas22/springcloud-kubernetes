package org.ymcasas.springcloud.msvc.users.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(String.format("User with ID %d not found", id));
    }

}
