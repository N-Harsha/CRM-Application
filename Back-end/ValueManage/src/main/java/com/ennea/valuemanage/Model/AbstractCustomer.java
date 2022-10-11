package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AbstractCustomer extends Person{

    String businessName;

    @OneToMany
    Set<Order> orders=new HashSet<>();

    @OneToMany
    Set<Comment> comments=new HashSet<>();


    public AbstractCustomer(String name, String phoneNo, Address address, Long id, String businessName, Set<Order> orders, Set<Comment> comments) {
        super(name, phoneNo, address, id);
        this.businessName = businessName;
        this.orders = orders;
        this.comments = comments;

    }
}
