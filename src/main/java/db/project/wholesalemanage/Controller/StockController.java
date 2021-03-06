package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping()
    public String homeStock(Model model) {
        model.addAttribute("stock",new Stock());
        return "stock";
    }

    @GetMapping("/all")
    public  String allstock(Model model) {
        model.addAttribute("stocks",stockService.getAll());
        return "stock";
    }

    @GetMapping("/find")
    public String stockInfo(@RequestParam String stockname,Model model) {
        Stock stock = stockService.getStock(stockname);
        model.addAttribute("stockinfo",stock);
        return "stock";
    }

    @PostMapping("/add")
    public String addStock(@ModelAttribute Stock stock) {
        if (stockService.addNewStock(stock)) {
            return "success";
        }
        return "failure";
    }

    @GetMapping("/emergency")
    public String getEmergency(Model model,@RequestParam Long quantity) {
        model.addAttribute("emergencystocks",stockService.getEmergencyStocks(quantity));
        return "stock";
    }


}
