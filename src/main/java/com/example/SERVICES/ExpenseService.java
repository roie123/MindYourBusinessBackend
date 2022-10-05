package com.example.SERVICES;

import com.example.MODELS.Expense;
import com.example.REPOSITORIES.EmployeeRepo;
import com.example.REPOSITORIES.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ExpenseService  {
    private final ExpenseRepo expenseRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public ExpenseService(ExpenseRepo expenseRepo, EmployeeRepo employeeRepo) {
        this.expenseRepo = expenseRepo;
        this.employeeRepo = employeeRepo;

    }

    public Expense addExpense(Expense expense){
        expense.setActive(true);
        return  this.expenseRepo.save(expense);
    }
    public Expense updateExpense(Expense expense){
      return   this.expenseRepo.save(expense);
    }
    public void removeExpense(long expenseId){
        Expense expense=this.expenseRepo.findById(expenseId).orElseThrow();
        expense.setActive(false);
        this.expenseRepo.save(expense);
    }
    public Expense findExpenseById(long id){
        return this.expenseRepo.findById(id).orElseThrow();
    }

    public List<Expense> findActiveExpenses(){
        return this.expenseRepo.findActiveExpenses();
    }
    public List<Expense> findNonActiveExpenses(){
        return this.expenseRepo.findRemovedExpenses();
    }
    public List<Expense> findExpensesByMonth(int month){
        return this.expenseRepo.findAll().stream().filter(new Predicate<Expense>() {
            @Override
            public boolean test(Expense expense) {
                return (expense.getMonth()==month);
            }
        }).collect(Collectors.toList());
    }







}
