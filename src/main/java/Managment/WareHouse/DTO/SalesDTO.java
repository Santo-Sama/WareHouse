package Managment.WareHouse.DTO;

import Managment.WareHouse.Entity.Customers;
import Managment.WareHouse.Entity.SaleItem;
import Managment.WareHouse.Enum.ShipmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class SalesDTO {

    private Integer id;

    private LocalDateTime payment_date;
    private Double total_amount;
    private ShipmentStatus shipment_status;
    private LocalDateTime shipment_date;

    private Long customer_id;

    public SalesDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public ShipmentStatus getShipment_status() {
        return shipment_status;
    }

    public void setShipment_status(ShipmentStatus shipment_status) {
        this.shipment_status = shipment_status;
    }

    public LocalDateTime getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(LocalDateTime shipment_date) {
        this.shipment_date = shipment_date;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
