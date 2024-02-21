package com.occucode.ubti.utils.exception;

import lombok.Getter;

@Getter
public class ExceptionResponse {
  private final int status;
  private final String message;

  public ExceptionResponse(CustomExceptionCode errorCode){
    this.status = errorCode.getStatus();
    this.message = errorCode.getMessage();
  }
}
