package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Attendance extends BaseEntity{
    Date presenceDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    public Attendance(Long id, Date presenceDate,Employee employee) {
        super(id);
        this.presenceDate = presenceDate;
        this.employee=employee;
    }
}
