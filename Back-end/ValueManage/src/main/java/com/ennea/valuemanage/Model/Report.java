package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Report extends BaseEntity {
    Long totalMet;
    Long newOnboarded;
    Long existingMet;
    Long ordersPlaced;
    Date date;

    @OneToOne
    Comment comment;

    public Report(Long id, Long totalMet, Long newOnboarded, Long existingMet, Long ordersPlaced, Date date, Comment comment) {
        super(id);
        this.totalMet = totalMet;
        this.newOnboarded = newOnboarded;
        this.existingMet = existingMet;
        this.ordersPlaced = ordersPlaced;
        this.date = date;
        this.comment = comment;
    }
}
