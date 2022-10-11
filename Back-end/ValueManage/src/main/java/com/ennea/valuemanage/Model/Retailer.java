package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Retailer extends AbstractCustomer {
    @ManyToOne
    @JoinColumn(name = "representative_id")
    Representative representative;

    @Builder
    public Retailer(String name, String phoneNo, Address address, Long id, String businessName,@Singular Set<Order> orders,@Singular Set<Comment> comments, Representative representative) {
        super(name, phoneNo, address, id, businessName, orders, comments);
        this.representative=representative;
    }
}
