package com.ennea.valuemanage.API.v1.DTO;

import lombok.Data;

@Data
public class OrderDTO {
    Long id;
    String productName;
    Integer quantity;
    Float amount;
}
