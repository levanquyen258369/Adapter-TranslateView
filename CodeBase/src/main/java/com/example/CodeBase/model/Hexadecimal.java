package com.example.CodeBase.model;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Hexadecimal implements Convert<String, String>{

    @Override
    public String encode(String text) {
        byte[] inBytes = text.getBytes();
        String hexadecimalString = Hex.encodeHexString(inBytes);
        return hexadecimalString;
    }

    @Override
    public String decode(String encode) throws DecoderException {
        byte[] outBytes = Hex.decodeHex(encode);
        return new String(outBytes);
    }
}
