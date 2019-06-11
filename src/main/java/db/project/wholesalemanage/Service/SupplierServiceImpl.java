package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.StockRepo;
import db.project.wholesalemanage.Database.SupplierRepo;
import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private StockRepo stockRepo;

    @Override
    public Iterable<Supplier> getAll() {
        return supplierRepo.findAll();
    }

    @Override
    public Boolean addNewSupplier(Supplier supplier) {
        Supplier supp= supplierRepo.findByName(supplier.getName());
        Stock stock = stockRepo.findByName(supplier.getStock().getName());
//        If the supplier exists or stock doesnt exist;
        if (supp!=null || stock==null){
            return false;
        }
        supplier.setStock(stock);
        supplierRepo.save(supplier);
        return true;

    }

    @Override
    public Supplier getSupplierByName(String name) {
        return supplierRepo.findByName(name);
    }
}
