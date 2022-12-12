package com.quyet.model;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder implements StringEncoder {

    @Override
    public String encode(byte[] input) {
        return Base64.encodeBase64String(input);
    }

    @Override
    public byte[] decode(String input) {
        return Base64.decodeBase64(input);
    }
}
