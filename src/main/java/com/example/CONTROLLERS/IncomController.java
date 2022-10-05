package com.example.CONTROLLERS;

import com.example.MODELS.IncomeItem;
import com.example.SERVICES.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/income")
@CrossOrigin
public class IncomController {


    private final IncomeService incomeService;
@Autowired
    public IncomController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<IncomeItem>> getAllRelevent(){
    List<IncomeItem> list = incomeService.getAllActive();
    return new ResponseEntity<List<IncomeItem>>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<IncomeItem> addIncome(@RequestBody IncomeItem incomeItem){
    IncomeItem incomeItem1 =incomeService.addIncome(incomeItem);
    return new ResponseEntity<>(incomeItem1,HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<IncomeItem> updateIncome(@RequestBody IncomeItem incomeItem){
        IncomeItem incomeItem1 =incomeService.updateIncomeItem(incomeItem);
        return new ResponseEntity<>(incomeItem1,HttpStatus.CREATED);
    }

    @PutMapping(path = "/remove/{id}")
    public void deactivateIncome(@PathVariable("id")Long id){
    IncomeItem incomeItem=incomeService.deactivateIncomItem(id);
    incomeService.updateIncomeItem(incomeItem);
    }




}
