package com.example.miniproject.presenter;

import com.example.miniproject.database.ExpenseDatabaseHelper;
import com.example.miniproject.utils.ExpenseCollection;
import com.example.miniproject.view.CurrentWeekExpenseView;

public class CurrentWeekExpensePresenter {

    private CurrentWeekExpenseView view;
    private ExpenseDatabaseHelper database;
    private ExpenseCollection expenseCollection;

    public CurrentWeekExpensePresenter(ExpenseDatabaseHelper database, CurrentWeekExpenseView view) {
        this.database = database;
        this.view = view;
        expenseCollection = new ExpenseCollection(this.database.getCurrentWeeksExpenses());
    }

    public void renderTotalExpenses() {
        view.displayTotalExpenses(expenseCollection.getTotalExpense());
    }

    public void renderCurrentWeeksExpenses() {
        view.displayCurrentWeeksExpenses(expenseCollection.groupByDate());
    }
}
