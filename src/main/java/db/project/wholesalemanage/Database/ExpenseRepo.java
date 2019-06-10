package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ExpenseRepo extends CrudRepository<Expense,Long> {
    Iterable<Expense> findBySuppliername(String suppliername);
    Iterable<Expense> findByStockname(String stockname);
    Iterable<Expense> findAllByDateBetween(Date startMonth,Date endOfMonth);
}
