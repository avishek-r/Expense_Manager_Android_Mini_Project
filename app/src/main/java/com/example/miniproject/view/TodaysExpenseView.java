package com.example.miniproject.view;

import java.util.List;

import com.example.miniproject.model.Expense;

public interface TodaysExpenseView {
    void displayTotalExpense(Long totalExpense);
    void displayTodaysExpenses(List<Expense> expenses);
}
