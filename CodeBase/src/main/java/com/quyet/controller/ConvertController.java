package com.quyet.controller;

import com.quyet.load.TransRequest;
import com.quyet.model.ConvertAdapter;
import com.quyet.model.DataTypeEnum;
import com.quyet.utill.Contansts;
import lombok.RequiredArgsConstructor;
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
    private final ConvertAdapter convertAdapter;

    ///Gọi xem danh sách
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list-convert")
    ResponseEntity<Object> getConvertList() {
        return ResponseEntity.ok().body(DataTypeEnum.getAllCodes());
    }

    //Chuyển đổi dữ liệu
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/convert")
    ResponseEntity<Object> convert(@RequestBody TransRequest transRequest) throws Exception {
        return ResponseEntity.ok().body(
                convertAdapter.convert(transRequest.getData(), transRequest.getFrom(), transRequest.getTo())
        );
    }
}
