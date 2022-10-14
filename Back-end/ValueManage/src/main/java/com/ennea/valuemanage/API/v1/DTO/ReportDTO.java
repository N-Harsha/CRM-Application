package com.ennea.valuemanage.API.v1.DTO;

import com.ennea.valuemanage.Model.Comment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportDTO {
    Long totalMet;
    Long newOnboarded;
    Long existingMet;
    Long ordersPlaced;
    LocalDate date;
    Comment comment;
}
