package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails extends BaseEntity{
    String userName;
    String password;
    @OneToOne
    Employee employee;

    @Builder
    public UserDetails(Long id, String userName, String password, Employee employee) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }
}
