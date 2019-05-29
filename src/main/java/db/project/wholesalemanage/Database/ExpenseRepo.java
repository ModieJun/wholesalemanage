package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepo extends CrudRepository<Expense,Long> {
}
