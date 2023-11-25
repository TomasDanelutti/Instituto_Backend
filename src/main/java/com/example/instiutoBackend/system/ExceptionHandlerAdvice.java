package com.example.instiutoBackend.system;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefault(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDefault(DataIntegrityViolationException e) {
        e.printStackTrace();
        logger.error(e.getMostSpecificCause().getMessage());
        Throwable cause = e.getCause();

        if (cause instanceof ConstraintViolationException) {
            return new ResponseEntity<>("La operación solicitada no puede realizarse - El registro está siendo utilizado", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("No se pudo acceder a la base de datos", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
