package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CarSelectionException extends Exception {

    private static final long serialVersionUID = -3414139914304527947L;

    public CarSelectionException(String message)
    {
        super(message);
    }
}
