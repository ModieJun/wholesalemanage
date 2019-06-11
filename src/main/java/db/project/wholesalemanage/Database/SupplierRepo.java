package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier,Long> {
    Supplier findByName(String name);
    Supplier findByStock(Stock stock);
}
