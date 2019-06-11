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

    @ManyToOne
    @JoinColumn(name = "stockid")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private  Customer customer;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
