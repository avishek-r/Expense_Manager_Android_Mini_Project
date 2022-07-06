package com.example.miniproject.presenter;


import com.echo.holographlibrary.Bar;

import java.util.ArrayList;
import java.util.List;

import com.example.miniproject.database.ExpenseDatabaseHelper;
import com.example.miniproject.model.Expense;
import com.example.miniproject.utils.ExpenseCollection;
import com.example.miniproject.view.CurrentMonthExpenseView;


public class CurrentMonthExpensePresenter {
    private final CurrentMonthExpenseView view;
    private final ExpenseCollection expenseCollection;

    public CurrentMonthExpensePresenter(CurrentMonthExpenseView view, ExpenseDatabaseHelper database) {
        this.view = view;
        List<Expense> expenses = database.getExpensesForCurrentMonthGroupByCategory();
        expenseCollection = new ExpenseCollection(expenses);
    }

    public void plotGraph() {
        List<Bar> points = new ArrayList<Bar>();

        for (Expense expense : expenseCollection.withoutMoneyTransfer()) {
            Bar bar = new Bar();
            bar.setColor(view.getGraphColor());
            bar.setName(expense.getType());
            bar.setValue(expense.getAmount());
            points.add(bar);
        }

        view.displayGraph(points);
    }

    public void showTotalExpense() {
        view.displayTotalExpense(expenseCollection.getTotalExpense());
    }
}
