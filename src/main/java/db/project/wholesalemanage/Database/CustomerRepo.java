package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
