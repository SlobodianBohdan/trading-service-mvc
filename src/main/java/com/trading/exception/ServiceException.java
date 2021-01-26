package com.trading.exception;

import javax.persistence.EntityNotFoundException;

public class ServiceException extends EntityNotFoundException {
    public ServiceException(String message) {
        super(message);
    }
}
