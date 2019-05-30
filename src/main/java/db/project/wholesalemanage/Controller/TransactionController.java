package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public String transactionHome() {
        return "transaction";
    }

    @GetMapping("/transaction/all")
    public String allTransaction(Model model) {
        model.addAttribute("expenses",transactionService.getAllExpense());
        model.addAttribute("incomes",transactionService.getAllIncome());

        return  "transaction";
    }
}
