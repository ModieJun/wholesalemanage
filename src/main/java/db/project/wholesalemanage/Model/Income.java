package db.project.wholesalemanage.Model;

import javax.persistence.*;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Long stockId;

    private  Long customerId;

    private Double amount;

    private Long quantity;

}
