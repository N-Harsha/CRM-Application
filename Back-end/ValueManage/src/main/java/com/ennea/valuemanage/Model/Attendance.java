package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Attendance extends BaseEntity{
    Date presenceDate;

    public Attendance(Long id, Date presenceDate) {
        super(id);
        this.presenceDate = presenceDate;
    }
}
