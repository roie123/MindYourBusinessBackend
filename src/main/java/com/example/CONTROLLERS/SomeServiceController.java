package com.example.CONTROLLERS;

import com.example.MODELS.SomeService;
import com.example.SERVICES.SomeServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/services")
public class SomeServiceController {

    private final SomeServiceService someServiceService;

    public SomeServiceController(SomeServiceService someServiceService) {
        this.someServiceService = someServiceService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<SomeService>> getAll(){
        List<SomeService> someServiceList = someServiceService.findAllServices();
        return new ResponseEntity<>(someServiceList, HttpStatus.OK);
    }


}
