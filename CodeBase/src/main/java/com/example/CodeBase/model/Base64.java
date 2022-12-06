package com.example.CodeBase.model;

import org.springframework.stereotype.Component;

@Component
public class Base64 implements Convert<String, String>{
    @Override
    public String encode(String text) {
        byte[] inBytes = text.getBytes();
        String hexadecimalString = org.apache.commons.codec.binary.Base64.encodeBase64String(inBytes);

        return hexadecimalString;
    }

    @Override
    public String decode(String encode){
        byte[] outBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encode);
        return new String(outBytes);
    }
}
