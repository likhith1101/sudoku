package com.sudoku.game.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex) {
        // Log the exception or perform custom error handling here
        return "error"; // Redirect to the custom error page
    }
}
