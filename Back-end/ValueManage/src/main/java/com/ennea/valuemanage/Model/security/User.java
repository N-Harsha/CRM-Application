package com.ennea.valuemanage.Model.security;

import com.ennea.valuemanage.Model.BaseEntity;
import com.ennea.valuemanage.Model.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CRM_USER")
public class User extends BaseEntity {
    String userName;
    String password;
    @OneToOne
    Employee employee;


    @ManyToMany
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID"))
    private Set<Authority> authorities;

    @Builder
    public User(Long id, String userName, String password, Employee employee,@Singular Set<Authority> authorities) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.employee = employee;
        this.authorities=authorities;
    }
}
