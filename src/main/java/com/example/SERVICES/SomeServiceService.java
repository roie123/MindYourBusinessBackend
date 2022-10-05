package com.example.SERVICES;

import com.example.MODELS.SomeService;
import com.example.REPOSITORIES.SomeServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SomeServiceService { ///HAHAHAHAH FUNNY

    private final SomeServiceRepo someServiceRepo;

    @Autowired
    public SomeServiceService(SomeServiceRepo someServiceRepo) {
        this.someServiceRepo = someServiceRepo;
    }
    public SomeService addSomeService(SomeService someService){   //////////// ADD
        return someServiceRepo.save(someService);
    } //////ADD

    public List<SomeService> findAllServices(){
        return someServiceRepo.findAll();
    }  //////GET ALL
    public List<SomeService> findAllActiveServices(){
        return someServiceRepo.findAll().stream().filter(new Predicate<SomeService>() {
            @Override
            public boolean test(SomeService someService) {
                return someService.isActive();
            }
        }).collect(Collectors.toList());
    }
    public SomeService updateService(SomeService someService){
        return someServiceRepo.save(someService);
    } //////UPDATE EMPLOYEE

    public void deleteService(Long id){
        someServiceRepo.deleteById(id);
    } //////DELETE BY ID

    public SomeService findById(Long id){
        return someServiceRepo.findById(id).orElseThrow();
    } ///FIND BY ID


    public SomeService findRandomService(){
        return someServiceRepo.findRandomService();
    }



}
