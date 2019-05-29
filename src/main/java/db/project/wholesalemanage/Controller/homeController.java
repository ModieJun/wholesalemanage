package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeController {

    @Autowired
    private StockService stockService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute(new Stock());
        return "home";
    }

    @PostMapping("/stock/add")
    public String addStock(@ModelAttribute Stock stock){
        if (stockService.addNewStock(stock)) {
            return "success";
        }
        return "home";

    }

}
