package db.project.wholesalemanage.Model;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierid;

    private String name;
    private String Address;

    @OneToOne()
    @JoinColumn(name = "stock_id",unique = true,updatable = true)
    private Stock stock;

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
