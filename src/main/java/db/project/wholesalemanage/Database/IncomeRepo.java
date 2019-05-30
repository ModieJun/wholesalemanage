package db.project.wholesalemanage.Database;

import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Model.Type;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepo extends CrudRepository<Income,Long> {
    Iterable<Income> findByType(Type type);
    Iterable<Income> findByDateContaining(Long month);
}
