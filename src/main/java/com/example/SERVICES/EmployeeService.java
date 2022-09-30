package com.example.SERVICES;

import antlr.collections.impl.LList;
import com.example.MODELS.Client;
import com.example.MODELS.Employee;
import com.example.REPOSITORIES.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {   //////////// ADD
        return employeeRepo.save(employee);
    } //////ADD

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }  //////GET ALL

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    } //////UPDATE EMPLOYEE

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    } //////DELETE BY ID

    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    } ///FIND BY ID

    public Employee findRandomEmployee() {
        return employeeRepo.findRandomEmployee();
    }

    public List<Employee> findActiveEmployees(){
        return employeeRepo.findActiveEmployees();
    }  //////GET ALL

    public List<Employee> findRemovedEmployees(){
        return employeeRepo.findRemovedEmployees();
    }


public List<Employee> getEmplyeeeByName(String firstName, String lastName){
        List<Employee> employeeList =employeeRepo.findActiveEmployees();
        List<Employee> employeesWithName = new ArrayList<>();
        employeeList.stream().forEach(employee -> {
            if (employee.getFirstName().equals(firstName) || employee.getLastName().equals(lastName)){
                employeesWithName.add(employee);
            }
        });
        return employeesWithName;
}

}
