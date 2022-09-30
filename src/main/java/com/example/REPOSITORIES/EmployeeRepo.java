package com.example.REPOSITORIES;

import com.example.MODELS.Client;
import com.example.MODELS.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
@Query(value = "select * from employee ORDER BY rand() limit 1;",nativeQuery = true)
public Employee findRandomEmployee();

    @Query(value = "SELECT * FROM employee WHERE is_active=1;",nativeQuery = true)
    public List<Employee> findActiveEmployees();

    @Query(value = "SELECT * FROM employee WHERE is_active=0;",nativeQuery = true)
    public List<Employee> findRemovedEmployees();



//TODO add a query to find a employee by his name for an appointment
}
