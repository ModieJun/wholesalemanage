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

    @GetMapping("/{stockname}")
    public String stockInfo(@PathVariable String stockname,Model model) {
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

    @GetMapping("/emergency/{amount}")
    public String getEmergency(Model model,@PathVariable Long amount) {
        model.addAttribute("emergencystocks",stockService.getEmergencyStocks(amount));
        return "stock";
    }


}
