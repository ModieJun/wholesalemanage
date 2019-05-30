package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.ExpenseRepo;
import db.project.wholesalemanage.Database.IncomeRepo;
import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private IncomeRepo incomeRepo;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Override
    public Iterable<Income> getAllIncome() {
        return incomeRepo.findAll();
    }

    @Override
    public Iterable<Expense> getAllExpense() {
        return expenseRepo.findAll();
    }

    @Override
    public void addNewIncome(Income income) {
        incomeRepo.save(income);
    }

    @Override
    public void addNewExpense(Expense expense) {
        expenseRepo.save(expense);
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
}
