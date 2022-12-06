package com.example.CodeBase.model;

import lombok.Data;
import org.apache.commons.codec.DecoderException;
import org.apache.logging.log4j.util.Base64Util;

import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

@Data
@Configuration
public class ConvertAdapter {

    private Convert trans;
    private Hexadecimal hex;
    private Base64 base64;
    private  Bytes bytes;



    public ConvertAdapter(Convert trans, Hexadecimal hex, Base64 base64) {
        this.trans = trans;
        this.hex = hex;
        this.base64 = base64;

    }

    //Convert Base64 -> String
    public String convertBase64ToString(String base64ToString) throws DecoderException {
        setTrans(this.base64);
        return (String) trans.decode(base64ToString);
    }
    //Convert Hexadecimal -> String
    public String convertHexadecimalToString(String hexaString) throws DecoderException {
        setTrans(this.hex);
        return (String) trans.decode(hexaString);
    }
    //Convert String -> Hexadecimal
    public String convertStringToHexa(String stringToHexa){
        setTrans(this.hex);
        return (String) trans.encode(stringToHexa);
    }
    //Convert String -> Base64
    public String convertStringToBase64(String stringToBase){
        if(!(trans instanceof Base64Coder)){
            setTrans(this.base64);
        }
        return (String) trans.encode(stringToBase);
    }
    //Convert Base64 -> Hexadecimal
    public String convertBase64ToHexa(String baseToHex) throws DecoderException {
        String text = convertBase64ToString(baseToHex);
        setTrans(this.hex);
        return convertStringToHexa(text);
    }
    //Convert Hexadecimal -> Base64
    public String convertHexaToBase64(String hexaToBase) throws DecoderException {
        String text = convertHexadecimalToString(hexaToBase);
        setTrans(this.base64);
        return convertStringToBase64(text);
    }

    public String convertStringToByte(String stringToByte) throws DecoderException {
        String text = convertBase64ToHexa(stringToByte);
        setTrans(this.bytes);
        return convertStringToHexa(text);
    }

}
