package com.example.CodeBase.model;

import org.apache.commons.codec.DecoderException;


public class Images implements Convert<String, String>{
    @Override
    public String encode(String text) {
        return "Mã hóa bởi ảnh";
    }

    @Override
    public String decode(String encode) throws DecoderException {
        return "Giải mã bởi mã hóa!";
    }
}
