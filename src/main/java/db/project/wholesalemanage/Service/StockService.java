package db.project.wholesalemanage.Service;

import db.project.wholesalemanage.Model.Stock;

public interface StockService {
    Boolean addNewStock(Stock stock);

    void UpdateStock(Stock stock);

    Iterable<Stock> getEmergencyStocks();

    Iterable<Stock> getAll();

    Stock getStock(String stockName);
}
