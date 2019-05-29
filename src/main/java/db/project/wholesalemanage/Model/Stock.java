package db.project.wholesalemanage.Model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long quantinty;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantinty() {
        return quantinty;
    }

    public void setQuantinty(Long quantinty) {
        this.quantinty = quantinty;
    }
}
