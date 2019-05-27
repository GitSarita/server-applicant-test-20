package com.mytaxi.exception;

import java.util.Date;

class ErrorDetails {
    private final String description;
    private final Date date;
    private final String message;

    ErrorDetails(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;

    }
}
