package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Customer;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Type;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface IncomeRepo extends CrudRepository<Income,Long> {
    Iterable<Income> findByType(Type type);
    Iterable<Income> findByCustomer(Customer customerName);
    Iterable<Income> findByStock(Stock stockname);
    Iterable<Income> findAllByDateBetween(Date startMonth,Date endOfMonth);
}
