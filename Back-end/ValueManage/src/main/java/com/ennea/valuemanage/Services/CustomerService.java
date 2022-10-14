package com.ennea.valuemanage.Services;

import com.ennea.valuemanage.API.v1.DTO.OrderDTO;
import com.ennea.valuemanage.Model.Comment;
import com.ennea.valuemanage.Model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer);
    public List<OrderDTO> getOrders(Long id);
    public List<Comment> getComments(Long id);
}
