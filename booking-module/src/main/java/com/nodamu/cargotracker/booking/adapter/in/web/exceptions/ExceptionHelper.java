package com.nodamu.cargotracker.booking.adapter.in.web.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author profnick
 * 9/17/20
 **/

/**
 * Exception handling class
 */
@ControllerAdvice
public class ExceptionHelper {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRoutingServiceNotAvailable(RuntimeException e){
            logger.error("Routing service not available: {}", e.getMessage());
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
