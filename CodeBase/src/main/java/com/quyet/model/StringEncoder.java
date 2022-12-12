package com.quyet.model;

public interface StringEncoder {

    public String encode(byte[] input) throws Exception;

    public byte[] decode(String input) throws Exception;
}
