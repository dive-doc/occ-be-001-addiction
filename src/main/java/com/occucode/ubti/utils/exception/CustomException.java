package com.occucode.ubti.utils.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

  private CustomExceptionCode customExceptionCode;

  public CustomException(CustomExceptionCode customExceptionCode) {
    super(customExceptionCode.getMessage());
    this.customExceptionCode = customExceptionCode;
  }

}