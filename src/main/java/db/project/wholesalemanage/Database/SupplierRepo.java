package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier,Long> {
}
