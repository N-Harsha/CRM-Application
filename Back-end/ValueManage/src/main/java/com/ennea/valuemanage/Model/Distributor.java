package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Distributor extends AbstractCustomer {
    private String ERP;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Builder
    public Distributor(String name, String phoneNo, Address address, Long id, String businessName,@Singular Set<Order> orders,@Singular Set<Comment> comments, String ERP, Manager manager) {
        super(name, phoneNo, address, id, businessName, orders, comments);
        this.ERP = ERP;
        this.manager = manager;
    }

}
