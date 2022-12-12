package com.quyet.model;

import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DataTypeEnum {
    HEX("hex"), BASE64("base64");

    private String code;
    private static List<String> allCodes = null;

    DataTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public StringEncoder getEncoder() throws NotFoundException {
        switch (code) {
            case "hex":
                return new HexEncoder();
            case "base64":
                return new Base64Encoder();
            default:
        }
        throw new NotFoundException("Encoder not found!");
    }

    public static List<String> getAllCodes() {
        if (allCodes == null)
            allCodes = Arrays.stream(DataTypeEnum.values()).map(DataTypeEnum::getCode).collect(Collectors.toList());
        return allCodes;
    }
}
