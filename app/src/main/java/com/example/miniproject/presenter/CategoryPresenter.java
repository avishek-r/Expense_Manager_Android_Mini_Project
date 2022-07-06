package com.example.miniproject.presenter;

import com.example.miniproject.database.ExpenseDatabaseHelper;
import com.example.miniproject.model.ExpenseType;
import com.example.miniproject.view.AddCategoryView;

public class CategoryPresenter {
    private final AddCategoryView view;
    private final ExpenseDatabaseHelper database;

    public CategoryPresenter(AddCategoryView view, ExpenseDatabaseHelper database) {
        this.view = view;
        this.database = database;
    }

    public boolean addCategory() {
        String newCategory = view.getCategory();
        if(newCategory.isEmpty()){
            view.displayError();
            return false;
        }

        database.addExpenseType(new ExpenseType(newCategory));
        return true;
    }
}
