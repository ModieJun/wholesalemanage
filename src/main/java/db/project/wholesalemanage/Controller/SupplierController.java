package db.project.wholesalemanage.Controller;

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

    @GetMapping("/add")
    public String addSupplierPage(Model model) {
        model.addAttribute("supplier",new Supplier());
        return "supplier";
    }

    @GetMapping("/{suppliername}")
    public String supplierInfo(Model model, @PathVariable String suppliername) {
        Supplier supplier = supplierService.getSupplierByName(suppliername);
        model.addAttribute("supplierinfo",supplier);
        return "supplier";
    }

    /*
    *   Post Mappings
    * */

    @PostMapping("/add")
    public  String addSupplier(@ModelAttribute Supplier supplier) {
        if (supplierService.addNewSupplier(supplier)) {

            return "supplier";
        }

        return "supplier";
    }
}
