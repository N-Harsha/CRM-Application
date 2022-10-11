package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Manager extends Person{

    @Builder
    public Manager(String name, String phoneNo, Address address, Long id,@Singular Set<Report> reports,@Singular Set<Distributor> distributors,@Singular Set<Attendance> attendances,@Singular Set<Representative> representatives) {
        super(name, phoneNo, address, id);
        this.reports = reports;
        this.distributors = distributors;
        this.attendanceList = attendanceList;
        this.representatives=representatives;
    }

    @OneToMany
    private Set<Report> reports=new HashSet<>();
    @OneToMany(mappedBy = "manager")
    private Set<Distributor> distributors=new HashSet<>();

    @OneToMany(mappedBy = "manager")
    private Set<Representative> representatives=new HashSet<>();
    @OneToMany
    private Set<Attendance> attendanceList=new HashSet<>();


}
