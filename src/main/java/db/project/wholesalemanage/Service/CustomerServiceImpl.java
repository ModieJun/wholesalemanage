package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.CustomerRepo;
import db.project.wholesalemanage.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Iterable<Customer> getAll() {
        return customerRepo.findAll();
    }

    @Override
    public Boolean addNewCustomer(Customer customer) {
        if (customerRepo.findByName(customer.getName())!=null) {
            return false;
        }

        customerRepo.save(customer);
        return true;
    }

    @Override
    public Customer getCustomer(String customername) {
        Customer customer = customerRepo.findByName(customername);
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer tobechanged = customerRepo.findById(customer.getId()).get();
        tobechanged.setName(customer.getName());
        tobechanged.setAddress(customer.getAddress());
        customerRepo.save(tobechanged);
    }
}
