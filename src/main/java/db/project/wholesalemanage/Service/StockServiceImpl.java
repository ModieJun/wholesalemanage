package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Database.StockRepo;
import db.project.wholesalemanage.Model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepo stockRepo;

    @Override
    public Boolean addNewStock(Stock stock) {
        if (stockRepo.findByName(stock.getName())!=null) {
            return false;
        }

        stockRepo.save(stock);
        return true;
    }

    //TODO
    @Override
    public void UpdateStock(Stock stock) {
        stockRepo.save(stock);
    }
    //TODO
    @Override
    public Iterable<Stock> getEmergencyStocks(Long amount) {
        return stockRepo.findAllByQuantityIsLessThan(amount);
    }

    @Override
    public Iterable<Stock> getAll() {
        return stockRepo.findAll();
    }

    @Override
    public Stock getStock(String stockName) {
        Stock stock = stockRepo.findByName(stockName);
        return stock;
    }
}
