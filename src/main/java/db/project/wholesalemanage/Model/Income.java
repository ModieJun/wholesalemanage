package db.project.wholesalemanage.Model;

import javax.persistence.*;
import java.sql.Date;
import db.project.wholesalemanage.Model.Stock;
import db.project.wholesalemanage.Model.Customer;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne
    private Stock stock;

    @OneToOne
    private  Customer customer;

    private Double amount;

    private Long quantity;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
