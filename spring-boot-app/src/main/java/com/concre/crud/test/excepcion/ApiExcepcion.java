package com.concre.crud.test.excepcion;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiExcepcion {
    private final String message;
    private final HttpStatus httpStatus;
    private final String httpStatusInfo;
    private final ZonedDateTime timestamp;

    public ApiExcepcion(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusInfo = " (" + httpStatus.value() + ")"; // Nombre y número del estado HTTP
        this.timestamp = timestamp;
    }


}
