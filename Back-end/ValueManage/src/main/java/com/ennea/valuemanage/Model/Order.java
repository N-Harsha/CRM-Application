package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_Table")

public class Order extends BaseEntity{
    String productName;
    Long quantity;

    Float amount;

    @Builder
    public Order(Long id, String productName, Long quantity,Float amount) {
        super(id);
        this.productName = productName;
        this.quantity = quantity;
        this.amount=amount;
    }
}
