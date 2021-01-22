package com.trading.srevice.exception;

import javax.persistence.EntityNotFoundException;

public class TradeNotFoundException extends EntityNotFoundException {
    public TradeNotFoundException(String message) {
        super(message);
    }
}
