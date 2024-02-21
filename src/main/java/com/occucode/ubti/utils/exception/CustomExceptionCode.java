package com.occucode.ubti.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomExceptionCode {

    USER_EXISTS(409, "이미 등록된 닉네임 입니다.");

    private final int status;
    private final String message;

}

