package com.occucode.ubti.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MbtiItemEnum {
    E("E"), I("I"),
    N("N"), S("S"),
    F("F"), T("T"),
    P("P"), J("J");

    private final String value;

    MbtiItemEnum(String value) {
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
    public static MbtiItemEnum fromString(String value) {
        for (MbtiItemEnum item : MbtiItemEnum.values()) {
            if (item.value.equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }
}
