package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Customer;
import db.project.wholesalemanage.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/find")
    public String findCustomer(@RequestParam String customername,Model model){
        Customer customer = customerService.getCustomer(customername);
        if (customer!=null){
            model.addAttribute("customerinfo",customer);
            return "customer";
        }else{
            return "redirect:/customer?customerexist=false";
        }
    }

    @GetMapping("/edit")
    public String editCustomer(@RequestParam String customername,@RequestParam String customeraddress, Model model, RedirectAttributes redirectAttributes){
        Customer customer= customerService.getCustomer(customername);
//        System.out.println(customer.getName());
        model.addAttribute("editcustomer",customer);
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

    @PostMapping("/update")
    public String updateCustome(@ModelAttribute("editCustomer")Customer editcustomer){
        customerService.updateCustomer(editcustomer);
        return "success";
    }
}
