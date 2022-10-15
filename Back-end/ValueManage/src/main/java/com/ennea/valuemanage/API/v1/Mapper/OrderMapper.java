package com.ennea.valuemanage.API.v1.Mapper;

import com.ennea.valuemanage.API.v1.DTO.OrderDTO;
import com.ennea.valuemanage.Model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    public OrderDTO orderToOrderDTO(Order order);
    public Order orderDTOToOrder(OrderDTO orderDTO);
}
