package com.occucode.ubti.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * CustomException 발생시 동작
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = CustomException.class)
  public ResponseEntity<?> handleCustomException(CustomException e) {
    ExceptionResponse response = new ExceptionResponse(e.getCustomExceptionCode());

    return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
  }

}
