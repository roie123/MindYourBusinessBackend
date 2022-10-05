package com.example.SERVICES;

import com.example.MODELS.IncomeItem;
import com.example.REPOSITORIES.IncomItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class IncomeService {

    private final IncomItemRepo incomItemRepo;

    @Autowired
    public IncomeService(IncomItemRepo incomItemRepo) {
        this.incomItemRepo = incomItemRepo;
    }
    public List<IncomeItem> getAllActive(){
        List<IncomeItem>incomeItems = incomItemRepo.findAll().stream().filter(new Predicate<IncomeItem>() {
            @Override
            public boolean test(IncomeItem incomeItem) {
              return   incomeItem.isActive();
            }
        }).collect(Collectors.toList());
        return incomeItems;
    }
    public List<IncomeItem> getAllNonActive(){
        List<IncomeItem> list = incomItemRepo.findAll().stream().filter(new Predicate<IncomeItem>() {
            @Override
            public boolean test(IncomeItem incomeItem) {
                return                 incomeItem.isActive();
            }
        }).collect(Collectors.toList());
        return list;
    }

    public IncomeItem addIncome(IncomeItem incomeItem){
        incomeItem.setActive(true);
        return incomItemRepo.save(incomeItem);

    }
    public  IncomeItem updateIncomeItem(IncomeItem incomeItem){
        return incomItemRepo.save(incomeItem);
    }
    public IncomeItem deactivateIncomItem(long id){
        IncomeItem incomeItem =incomItemRepo.findById(id).orElseThrow();
        incomeItem.setActive(false);
        return incomeItem;
    }


}
