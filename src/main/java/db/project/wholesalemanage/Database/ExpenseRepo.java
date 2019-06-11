package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ExpenseRepo extends CrudRepository<Expense,Long> {
    Iterable<Expense> findBySupplier(Supplier supplier);
    Iterable<Expense> findByStock(Stock stock);
    Iterable<Expense> findAllByDateBetween(Date startMonth,Date endOfMonth);
}
