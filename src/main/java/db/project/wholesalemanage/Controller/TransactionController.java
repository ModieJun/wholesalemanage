package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public String transactionHome() {
        return "transaction";
    }

    @GetMapping("/all")
    public String allTransaction(Model model) {
        model.addAttribute("expenses",transactionService.getAllExpense());
        model.addAttribute("incomes",transactionService.getAllIncome());

        return  "transaction";
    }

    @GetMapping("/paid")
    public String paidTransaction(Model model) {
        model.addAttribute("paidtrans",transactionService.getPaidIncome());
        return "paidtrans";
    }

    @GetMapping("/pending")
    public String pendingTransaction(Model model) {
        model.addAttribute("pendingtrans",transactionService.getPendingIncome());
        return "pending";
    }

    @GetMapping("/income/add")
    public String addIncomePage(Model model) {
        model.addAttribute("income",new Income());
        return"income";
    }

    @GetMapping("/expense/add")
    public String addExpensePage(Model model) {
        model.addAttribute("expense",new Expense());
        return "expense";
    }


    /*
    *   Post mappings
    *
    * */

    @PostMapping("/expense/add")
    public String addExpense(@ModelAttribute Expense expense) {
        transactionService.addNewExpense(expense);
        return "expense";
    }

    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute Income income) {
        transactionService.addNewIncome(income);
        return "income";
    }
}
