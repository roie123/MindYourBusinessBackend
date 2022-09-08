package com.example.REPOSITORIES;

import com.example.MODELS.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
@Query(value = "select * from employee ORDER BY rand() limit 1;",nativeQuery = true)
public Employee findRandomEmployee();


}
