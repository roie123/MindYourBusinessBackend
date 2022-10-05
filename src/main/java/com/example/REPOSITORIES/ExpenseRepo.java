package com.example.REPOSITORIES;

import com.example.MODELS.Employee;
import com.example.MODELS.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    @Query(value = "SELECT * FROM expense WHERE is_active=1;",nativeQuery = true)
    public List<Expense> findActiveExpenses();

    @Query(value = "SELECT * FROM expense WHERE is_active=0;",nativeQuery = true)
    public List<Expense> findRemovedExpenses();


//    SELECT * FROM expense WHERE month=0;
}
