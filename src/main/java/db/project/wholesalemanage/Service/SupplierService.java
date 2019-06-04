package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Model.Supplier;

public interface SupplierService {
    Iterable<Supplier> getAll();
    Boolean addNewSupplier(Supplier supplier,String stockname);
    Supplier getSupplierByName(String name);
}
