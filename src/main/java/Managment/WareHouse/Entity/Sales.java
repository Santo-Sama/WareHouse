package Managment.WareHouse.Entity;


import Managment.WareHouse.Enum.ShipmentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime payment_date;
    private Double total_amount;
    private ShipmentStatus shipment_status;
    private LocalDateTime shipment_date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customers customer;

    public Sales() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

}
