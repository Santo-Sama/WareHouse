package Managment.WareHouse.DTO;

import Managment.WareHouse.Entity.Products;
import Managment.WareHouse.Entity.Sales;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SaleItemDTO {

    private Integer id;

    private Integer quantity;
    private Double unit_price;

    private Long product_id;

    private Long sale_id;

    public SaleItemDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getSale_id() {
        return sale_id;
    }

    public void setSale_id(Long sale_id) {
        this.sale_id = sale_id;
    }
}
