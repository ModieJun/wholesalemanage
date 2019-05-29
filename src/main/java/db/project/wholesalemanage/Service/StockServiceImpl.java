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

    }
    //TODO
    @Override
    public Iterable<Stock> getEmergencyStocks() {
        return null;
    }

    @Override
    public Iterable<Stock> getAll() {
        return stockRepo.findAll();
    }
}
