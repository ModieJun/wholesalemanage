package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.SupplierRepo;
import db.project.wholesalemanage.Model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;


    @Override
    public Iterable<Supplier> getAll() {
        return supplierRepo.findAll();
    }

    @Override
    public Boolean addNewSupplier(Supplier supplier,String stockname) {
        Supplier supp= supplierRepo.findByName(supplier.getName());
        if (supp!=null){
            return false;
        }
        supplierRepo.save(supplier);
        return true;

    }

    @Override
    public Supplier getSupplierByName(String name) {
        return supplierRepo.findByName(name);
    }
}
