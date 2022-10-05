package com.example.CONTROLLERS;

import com.example.MODELS.Expense;
import com.example.SERVICES.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Expense>> getAll(){
        List<Expense> expenses = expenseService.findActiveExpenses();
        return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
    }
    @GetMapping(path = "/all/removed")
    public ResponseEntity<List<Expense>> getAllRemoved(){
        List<Expense> expenses = expenseService.findNonActiveExpenses();
        return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        Expense expense1 = expenseService.addExpense(expense);
        return new ResponseEntity<Expense>(expense1,HttpStatus.CREATED);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        Expense expense1 = expenseService.updateExpense(expense);
        return new ResponseEntity<Expense>(expense1,HttpStatus.OK);
    }
    @PutMapping(path = "/remove/{id}")
    public void deActivate(@PathVariable("id")Long id){
        Expense expense = expenseService.findExpenseById(id);
        expense.setActive(false);
        expenseService.updateExpense(expense);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Expense> findById(@PathVariable("id")Long id){
        Expense expense = expenseService.findExpenseById(id);
        return new ResponseEntity<Expense>(expense,HttpStatus.OK);
    }
}
