package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepo extends CrudRepository<Expense,Long> {
    Iterable<Expense> findBySuppliername(String suppliername);
    Iterable<Expense> findByStockname(String stockname);
}
