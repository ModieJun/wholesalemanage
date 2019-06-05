package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Model.Customer;

public interface CustomerService {
    Iterable<Customer> getAll();
    Boolean addNewCustomer(Customer customer);
    Customer getCustomer(String customername);
    void    updateCustomer(Customer customer);
}
