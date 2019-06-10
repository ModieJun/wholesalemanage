package db.project.wholesalemanage.Controller;

import db.project.wholesalemanage.Model.Expense;
import db.project.wholesalemanage.Model.Income;
import db.project.wholesalemanage.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public String transactionHome() {return "transaction"; }

    @GetMapping("/all")
    public String allTransaction(Model model) {
        model.addAttribute("expenses",transactionService.getAllExpense());
        model.addAttribute("incomes",transactionService.getAllIncome());
        return  "transaction";
    }

    @GetMapping("/paid")
    public String paidTransaction(Model model) {
        model.addAttribute("paidtrans",transactionService.getPaidIncome());
        return "transaction";
    }

    @GetMapping("/pending")
    public String pendingTransaction(Model model) {
        model.addAttribute("pendingtrans",transactionService.getPendingIncome());
        return "transaction";
    }

    @GetMapping("/income/add")
    public String addIncomePage(Model model) {
        model.addAttribute("income",new Income());
        return"transaction";
    }

    @GetMapping("/income/customer/{customername}")
    public String getIncomeByCustomerName(@PathVariable String customername,Model model){
        model.addAttribute("customerTrans",transactionService.getIncomesByCustomerName(customername));
        return "customer";
    }

    @GetMapping("/expense/add")
    public String addExpensePage(Model model) {
        model.addAttribute("expense",new Expense());
        return "transaction";
    }

    /*
        @suppliername :  is passed in froms stock html

        This @Code will find all expenses that we have paid to the
        supplier

     */
    @GetMapping("/expense/{suppliername}")
    public String getSupplierTransactions(@PathVariable String suppliername,Model model){
        Iterable<Expense> result = transactionService.getExpensesBySupplierName(suppliername);
        model.addAttribute("suppliertransaction",result);
        return "supplier";
    }

    /*

     */
    @GetMapping("/stock/{stockname}")
    public String getStockTransactions(@PathVariable String stockname,Model model){
        Iterable<Income> incomeResult = transactionService.getIncomeByStockname(stockname);
        Iterable<Expense> expenseResult = transactionService.getExpenseByStockname(stockname);
        model.addAttribute("stockIncome",incomeResult);
        model.addAttribute("stockExpense",expenseResult);
        return "stock";
    }

    /*
        @ProftCalculation
            Calculate the profit to date
     */
    @GetMapping("/profit")
    public String profitCalc(){
        return "profit";
    }


    /*
    *   Post mappings
    *
    * */

    @PostMapping("/expense/add")
    public String addExpense(@ModelAttribute Expense expense) {
        if(transactionService.addNewExpense(expense)){
            return "redirect:/transaction?expenseadd=true";
        }else{
            return "redirect:/transaction?expenseerror=true";
        }
    }

    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute Income income) {
//        System.out.println(income.getType().getCode().toString());
        if(transactionService.addNewIncome(income)){
            return "redirect:/transaction?incomeadded=true";
        }else{
            return "redirect:/transaction?incomeerror=true";
        }
    }
}
