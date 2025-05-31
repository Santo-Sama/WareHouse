package Managment.WareHouse.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer quantity_available;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private WareHouse warehouse;

    public Products() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long product_id) {
        this.id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(Integer quantity_available) {
        this.quantity_available = quantity_available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public WareHouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WareHouse warehouse) {
        this.warehouse = warehouse;
    }
}
