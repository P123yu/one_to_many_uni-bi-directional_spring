package com.one_to_many.controller;

import java.util.List;
import com.one_to_many.model.AddressModel;
import com.one_to_many.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    public AddressServiceImpl addressServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<?>getAll(){
        List<AddressModel>address=addressServiceImpl.getAll();
        if(!address.isEmpty()){
            return ResponseEntity.ok(address);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched getAll");
        }

    }
}
