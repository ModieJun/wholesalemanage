package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepo extends CrudRepository<Stock,Long> {
    Stock findByName(String name);
}
