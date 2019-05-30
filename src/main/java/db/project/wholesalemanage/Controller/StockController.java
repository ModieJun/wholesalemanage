package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public String homeStock(Model model) {
        model.addAttribute("stocks",stockService.getAll());
        return "stock";
    }

    @GetMapping("/stock/{stockname}")
    public String stockInfo(@PathVariable String stockName) {
        Stock stock = stockService.getStock(stockName);

        return "stockinfo";
    }

    @PostMapping("/stock/add")
    public String addStock(@ModelAttribute Stock stock) {
        if (stockService.addNewStock(stock)) {
            return "success";
        }
        return "failure";
    }

    @GetMapping("/stock/emergency")
    public String getEmergency(Model model) {
        model.addAttribute("stocks",stockService.getEmergencyStocks());
        return "stock";
    }


}
