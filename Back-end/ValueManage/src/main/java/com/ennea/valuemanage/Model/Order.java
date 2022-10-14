package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_Table")

public class Order extends BaseEntity implements Serializable {
    String productName;
    Integer quantity;

    Float amount;
    String supplierName;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Builder
    public Order(Long id, String productName, Integer quantity,Float amount,Customer customer,String supplierName) {
        super(id);
        this.productName = productName;
        this.quantity = quantity;
        this.amount=amount;
        this.customer=customer;
        this.supplierName=supplierName;
    }
}
