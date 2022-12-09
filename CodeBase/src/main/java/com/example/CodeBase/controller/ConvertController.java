package com.example.CodeBase.controller;

import com.example.CodeBase.load.TransRequest;
import com.example.CodeBase.model.ConvertAdapter;
import com.example.CodeBase.utill.Contansts;
import lombok.RequiredArgsConstructor;
import org.springframework.core.codec.CodecException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
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
        convertList.add("Image");
    }
    ///Gọi xem danh sách
    @CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/{from}/{to}")
    ResponseEntity<Object> convert(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to,@PathVariable(value = "to") String total , @RequestBody TransRequest transRequest) throws Exception {
        String textData = transRequest.getData();
        String result;
        result = trans.convert(textData,textData,from,to);
        return ResponseEntity.ok().body(Map.of("result", result));
    }
}
