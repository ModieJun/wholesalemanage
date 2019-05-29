package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;

public interface TransactionService {
    Iterable<Income> getAllIncome();

    Iterable<Expense> getAllExpense();

    void addNewIncome(Income income);

    void addNewExpense(Expense expense) ;

    Iterable<Income> getPaidIncome();

    Iterable<Income> getPendingIncome();

}
