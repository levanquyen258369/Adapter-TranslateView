package com.example.CodeBase.controller;

import com.example.CodeBase.load.TransRequest;
import com.example.CodeBase.model.ConvertAdapter;
import com.example.CodeBase.utill.Contansts;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.DecoderException;
import org.springframework.core.codec.CodecException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "htpp://localhost:4200", maxAge = 3600)
@RequestMapping(Contansts.Api.Path.PREFIX + "/convert")
public class ConvertController {
    private final ConvertAdapter trans;
    private static List<String> convertList;
    //dữ liệu cứng để test
    static{
        convertList = new ArrayList<>();
        convertList.add("String");
        convertList.add("Base64");
        convertList.add("Hex");
        convertList.add("Byte");
    }
    ///Gọi xem danh sách
    @GetMapping("/listconvert")
    ResponseEntity<Object> getConvertList() {
        return ResponseEntity.ok().body(convertList);
    }
    //Kiểm tra ngoại lệ
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handdecodeEx(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }
    //Chuyển đổi dữ liệu
    @PostMapping(value = "/{from}/{to}")
    ResponseEntity<Object> convert(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to, @RequestBody TransRequest transRequest) throws DecoderException {
        String textData = transRequest.getData();
        String result = null;
        switch (from){
            case "String":{
                result = trans.convertStringToHexa(textData);
                if(to.equals("Base64")){
                    result = trans.convertStringToBase64(textData);
                }
            }break;
            case "Base64": {
                result = trans.convertBase64ToString(textData);
                if(to.equals("Hex")){
                    result = trans.convertBase64ToHexa(textData);
                }

            }break;
            case "Hex":{
                result = trans.convertHexadecimalToString(textData);
                if(to.equals("Base64")){
                    result = trans.convertHexaToBase64(textData);
                }
            }break;
            case "Byte":{
                result = trans.convertStringToByte(textData);
                if(to.equals("Byte")){
                    result = trans.convertStringToHexa(textData);
                }
            }break;
            default:
                throw  new CodecException("Loại dữ liệu cần chuyển đổi, hiện tại không hợp lệ !");
        }
        return ResponseEntity.ok().body(Map.of("result", result));
    }
}
