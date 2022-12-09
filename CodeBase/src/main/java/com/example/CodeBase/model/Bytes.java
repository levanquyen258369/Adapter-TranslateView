package com.example.CodeBase.model;

import org.apache.commons.codec.DecoderException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Bytes implements Convert<byte[], String> {

    @Override
    public byte[] encode(String text) {
        byte[] output = text.getBytes(StandardCharsets.UTF_8);
        String base64encoded = Base64.getEncoder().encodeToString(output);
        return base64encoded.getBytes();
    }

    @Override
    public byte[] decode(String encode) throws Exception {
        byte[] output = encode.getBytes(StandardCharsets.UTF_8);
        byte[] base64encoded = Base64.getDecoder().decode(encode);
        return output;
    }
}