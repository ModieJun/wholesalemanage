package db.project.wholesalemanage.Service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;

import java.sql.Date;

public interface TransactionService {
    Iterable<Income> getAllIncome();

    Iterable<Expense> getAllExpense();

    Boolean addNewIncome(Income income);

    Boolean addNewExpense(Expense expense) ;

    Iterable<Income> getPaidIncome();

    Iterable<Income> getPendingIncome();

    Iterable<Expense> getExpensesBySupplierName(String suppliername);

    Iterable<Income> getIncomesByCustomerName(String customername);

    Iterable<Income> getIncomeByStockname(String stockname);

    Iterable<Expense> getExpenseByStockname(String stockname);

    Iterable<Income> getIncomeBetweenDates(Date startMonth, Date endMonth);

    Iterable<Expense> getExpenseBetweenDates(Date startMonth,Date endOfMonth);

    Float calcProfit(Iterable<Income> incomes,Iterable<Expense> expenses);
}
