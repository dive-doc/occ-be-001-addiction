package com.occucode.ubti.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MbtiEnum {
    ISTJ("ISTJ"),
    ISFJ("ISFJ"),
    INFJ("INFJ"),
    INTJ("INTJ"),
    ISTP("ISTP"),
    ISFP("ISFP"),
    INFP("INFP"),
    INTP("INTP"),
    ESTP("ESTP"),
    ESFP("ESFP"),
    ENFP("ENFP"),
    ENTP("ENTP"),
    ESTJ("ESTJ"),
    ESFJ("ESFJ"),
    ENFJ("ENFJ"),
    ENTJ("ENTJ");


    private final String value;

    MbtiEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonValue
    public String toValue() {
        return value.toLowerCase();
    }

    @JsonCreator
    public static MbtiEnum fromString(String value) {
        for (MbtiEnum mbti : MbtiEnum.values()) {
            if (mbti.value.equalsIgnoreCase(value)) {
                return mbti;
            }
        }
        return null;
    }
}
