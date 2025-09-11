package com.ahmadi.onlineshop.exception;

public class UserIdAlreadyExistException extends RuntimeException {
    public UserIdAlreadyExistException(String userIdIsAlreadyTaken) {
        super(userIdIsAlreadyTaken);
    }
}
