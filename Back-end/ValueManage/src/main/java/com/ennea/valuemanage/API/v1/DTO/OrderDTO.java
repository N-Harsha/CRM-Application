package com.ennea.valuemanage.API.v1.DTO;

import lombok.Data;

@Data
public class OrderDTO {
    String productName;
    Integer quantity;
    Float amount;
}
