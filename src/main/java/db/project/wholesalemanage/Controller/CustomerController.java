package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Customer;
import db.project.wholesalemanage.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute(new Customer());
        return "customer";
    }

    @GetMapping("/all")
    public String allCustomers(Model model) {
        model.addAttribute("customers",customerService.getAll());
        return "customer";
    }


    /*
    *       Post mappings
    *
    *
     */


    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        if (customerService.addNewCustomer(customer)) {
            return "success";
        }
        return "failure";
    }
}
