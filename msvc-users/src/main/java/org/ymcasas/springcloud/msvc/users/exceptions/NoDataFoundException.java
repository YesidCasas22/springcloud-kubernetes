package org.ymcasas.springcloud.msvc.users.exceptions;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
        super("No data found");
    }

}
