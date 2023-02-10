package com.omer.CRUDSpring.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("No se encuentra el id " + id);
    }
}
