package com.example.CodeBase.model;

import org.apache.commons.codec.DecoderException;

//P: kiểu trả về
//H: Kiểu Mã Hóa
public interface Convert <P, H>{
    P encode(H text);
    P decode(H encode) throws DecoderException;
}
