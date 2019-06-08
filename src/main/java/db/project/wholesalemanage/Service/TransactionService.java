package db.project.wholesalemanage.Service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;

public interface TransactionService {
    Iterable<Income> getAllIncome();

    Iterable<Expense> getAllExpense();

    Boolean addNewIncome(Income income);

    Boolean addNewExpense(Expense expense) ;

    Iterable<Income> getPaidIncome();

    Iterable<Income> getPendingIncome();

    Iterable<Expense> getExpensesBySupplierName(String suppliername);

    Iterable<Income> getIncomesByCustomerName(String customername);

}
