package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Supplier;
import db.project.wholesalemanage.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping()
    public String supplierHome() {
        return "supplier";
    }

    @GetMapping("/all")
    public String allSupplier(Model model) {
        model.addAttribute("suppliers",supplierService.getAll());
        return "supplier";
    }
    @GetMapping("/add")
    public String addSupplierPage(Model model) {
        model.addAttribute("supplier",new Supplier());
        return "supplier";
    }

    @GetMapping("/find")
    public String supplierInfo(Model model, @RequestParam String suppliername) {
        Supplier supplier = supplierService.getSupplierByName(suppliername);
        model.addAttribute("supplierinfo",supplier);
        return "supplier";
    }

    /*
    *   Post Mappings
    * */

    @PostMapping("/add")
    public  String addSupplier(@ModelAttribute("supplier") Supplier supplier,@ModelAttribute("stock") Stock stock ) {
        System.err.println("stockname: " + stock.getName());
        System.err.println(supplier.getName());
        if (supplierService.addNewSupplier(supplier,stock.getName())) {

            return "success";
        }

        return "failure";
    }
}
