package com.example.CONTROLLERS;

import com.example.MODELS.SomeService;
import com.example.SERVICES.EmployeeService;
import com.example.SERVICES.SomeServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/services")
public class SomeServiceController {

    private final SomeServiceService someServiceService;
    private  final EmployeeService employeeService;
    public SomeServiceController(SomeServiceService someServiceService, EmployeeService employeeService) {
        this.someServiceService = someServiceService;
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<SomeService>> getAll(){
        List<SomeService> someServiceList = someServiceService.findAllActiveServices();
        return new ResponseEntity<>(someServiceList, HttpStatus.OK);
    }

    @PostMapping(path = "/add/{employeeId}")
    public ResponseEntity<SomeService> addSomeService(@RequestBody SomeService someService,@PathVariable("employeeId") Long employeeId){
        someService.setEmployee(employeeService.findById(employeeId));
        someService.setActive(true);
        SomeService someService1 = someServiceService.addSomeService(someService);

        return new ResponseEntity<SomeService>(someService1,HttpStatus.CREATED);
    }

    @PutMapping(path = "/remove/{id}")
    public ResponseEntity<SomeService> remove(@PathVariable("id")Long id){
        SomeService someService =someServiceService.findById(id);
        someService.setActive(false);
        someServiceService.updateService(someService);
        return new ResponseEntity<SomeService>(someService,HttpStatus.OK);
    }
}
