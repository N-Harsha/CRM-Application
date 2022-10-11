package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Representative extends Person{

    @OneToMany
    @Singular
    private Set<Report> reports=new HashSet<>();

    @OneToMany(mappedBy = "representative")
    @Singular
    private Set<Retailer> retailers=new HashSet<>();

    @OneToMany
    @Singular
    private Set<Attendance> attendanceList=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "manager_id")
    Manager manager;

    @Builder
    public Representative(String name, String phoneNo, Address address, Long id, @Singular Set<Report> reports,@Singular Set<Retailer> retailers,@Singular Set<Attendance> attendances) {
        super(name, phoneNo, address, id);
        this.reports = reports;
        this.retailers = retailers;
        this.attendanceList = attendanceList;
    }
}
