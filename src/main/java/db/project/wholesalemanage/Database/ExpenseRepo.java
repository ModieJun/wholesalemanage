package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Model.Stock;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ExpenseRepo extends CrudRepository<Expense,Long> {
    Iterable<Expense> findBySuppliername(String suppliername);
    Iterable<Expense> findByStock(Stock stock);
    Iterable<Expense> findAllByDateBetween(Date startMonth,Date endOfMonth);
}
