package com.quyet.model;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HexEncoder implements StringEncoder {

    @Override
    public String encode(byte[] input) {
        return Hex.encodeHexString(input);
    }

    @Override
    public byte[] decode(String input) throws DecoderException {
        return Hex.decodeHex(input);
    }
}
