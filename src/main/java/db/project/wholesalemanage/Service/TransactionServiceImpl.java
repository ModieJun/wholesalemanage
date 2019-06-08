package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.*;
import db.project.wholesalemanage.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private IncomeRepo incomeRepo;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    private  Date currentDate;

    @Override
    public Iterable<Income> getAllIncome() {
        return incomeRepo.findAll();
    }

    @Override
    public Iterable<Expense> getAllExpense() {
        return expenseRepo.findAll();
    }

    @Override
    public Boolean addNewIncome(Income income) {
//        If the stock and customer dont exist
        Stock stock = stockRepo.findByName(income.getStockname());
        Customer customer = customerRepo.findByName(income.getCustomername());
        if (stock==null||customer==null){
            return false;
        }else if (stock.getQuantity()<income.getQuantity()){
            return false;
        }
//        Update the stock  since we sold
        stock.setQuantity(stock.getQuantity()-income.getQuantity());
        stockRepo.save(stock);
        currentDate= new Date(System.currentTimeMillis());
        income.setDate(currentDate);
        incomeRepo.save(income);
        return true;
    }

    @Override
    public Boolean addNewExpense(Expense expense) {
        Stock stock= stockRepo.findByName(expense.getStockname());
        Supplier supplier= supplierRepo.findByName(expense.getSuppliername());
        if (stock == null || supplier == null) {
            return false;
        }
//        Update the stock since we added
        stock.setQuantity(stock.getQuantity()+expense.getQuantity());
        stockRepo.save(stock);
        currentDate= new Date(System.currentTimeMillis());
        expense.setDate(currentDate);
        expenseRepo.save(expense);
        return true;
    }

    @Override
    public Iterable<Income> getPaidIncome() {
        Type t = Type.PAID;
        Iterable<Income> paidIncomes =  incomeRepo.findByType(t);
        return paidIncomes;
    }

    @Override
    public Iterable<Income> getPendingIncome() {
        Type t = Type.PENDING;
        Iterable<Income> pendingIncome = incomeRepo.findByType(t);
        return pendingIncome;
    }

    @Override
    public Iterable<Expense> getExpensesBySupplierName(String suppliername) {
        return expenseRepo.findBySuppliername(suppliername);
    }
}
