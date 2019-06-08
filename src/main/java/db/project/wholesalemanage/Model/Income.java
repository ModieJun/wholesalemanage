package db.project.wholesalemanage.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long incomeid;

    @Enumerated(EnumType.STRING)
    private Type type;


    private String stockname;


    private  String customername;

    private Double amount;

    private Long quantity;

    private Date date;

    public Long getIncomeid() {
        return incomeid;
    }

    public void setIncomeid(Long incomeid) {
        this.incomeid = incomeid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
