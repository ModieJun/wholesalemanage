package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Customer;
import db.project.wholesalemanage.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    private String home(Model model) {
        model.addAttribute(new Customer());
        return "customer";
    }


    /*
    *       Post mappings
    *
    *
     */


    @PostMapping("/customer/add")
    private String addCustomer(@ModelAttribute Customer customer) {
        if (customerService.addNewCustomer(customer)) {
            return "success";
        }
        return "failure";
    }
}
