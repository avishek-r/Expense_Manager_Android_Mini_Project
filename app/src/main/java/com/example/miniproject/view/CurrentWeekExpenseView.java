package com.example.miniproject.view;
import java.util.List;
import java.util.Map;

import com.example.miniproject.model.Expense;

public interface CurrentWeekExpenseView {
    void displayCurrentWeeksExpenses(Map<String, List<Expense>> expensesByDate);

    void displayTotalExpenses(Long totalExpense);
}
