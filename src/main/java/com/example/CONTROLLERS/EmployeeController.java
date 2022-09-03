package com.example.CONTROLLERS;

import com.example.CONTROLLERS.RANDOMIZE.RandomFirstNames;
import com.example.CONTROLLERS.RANDOMIZE.RandomLastNames;
import com.example.CONTROLLERS.RANDOMIZE.RandomPositions;
import com.example.MODELS.Employee;
import com.example.MODELS.SomeService;
import com.example.SERVICES.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(path = "/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
    List<Employee> list = employeeService.findAllEmployees();
    return new ResponseEntity<>(list, HttpStatus.OK);

    }
 @GetMapping(path = "/find/{id}")
 public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
 }

 @PostMapping(path = "/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
 }

 @PutMapping(path = "/update")
 public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
     Employee employee1 = employeeService.updateEmployee(employee);
     return new ResponseEntity<>(employee, HttpStatus.OK);
 }

 @DeleteMapping(path = "delete/{id}")
 public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") Long id){
     Employee employee = employeeService.findById(id);
     return new ResponseEntity<>(HttpStatus.OK);
 }

@PutMapping(path = "/add_allowed_service/{id}")
    public ResponseEntity<Employee> addAllowedService(@PathVariable("id") Long id,@RequestBody SomeService someService ){
        Employee employee =employeeService.findById(id);
        employee.addAllowedService(someService);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
}

@PostMapping(path = "/add_random")
    public ResponseEntity<Employee> addRandomEmployee() {
    Random random =new Random();
    RandomPositions randomPositions =new RandomPositions();
    randomPositions.fillPositions();
    Employee employee1 = new Employee();

    employee1.setFirstName(RandomFirstNames.values()[random.nextInt(0,RandomFirstNames.values().length)].toString());
    employee1.setLastName(RandomLastNames.values()[random.nextInt(0,RandomLastNames.values().length)].toString());
    employee1.setEmail(employee1.getFirstName()+"_"+employee1.getLastName()+"@gmail.com");
    employee1.setPosition(randomPositions.getRandomPosition());
    employee1.setYearsOfExperience(random.nextInt(0,15));
    employeeService.addEmployee(employee1);
    return new ResponseEntity<>(employee1, HttpStatus.CREATED);
}


}
