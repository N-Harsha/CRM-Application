package com.ennea.valuemanage.Services;


import com.ennea.valuemanage.API.v1.DTO.OrderDTO;
import com.ennea.valuemanage.API.v1.Mapper.OrderMapper;
import com.ennea.valuemanage.Model.Comment;
import com.ennea.valuemanage.Model.Customer;

import com.ennea.valuemanage.Repositories.AddressRepository;
import com.ennea.valuemanage.Repositories.CommentRepository;
import com.ennea.valuemanage.Repositories.CustomerRepository;
import com.ennea.valuemanage.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    AddressRepository addressRepository;
    OrderRepository orderRepository;
    CommentRepository commentRepository;

    OrderMapper orderMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository,
                               OrderRepository orderRepository, CommentRepository commentRepository,
                               OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.commentRepository = commentRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Customer save(Customer customer) {

        if(customer.getAddress()!=null&&customer.getAddress().getId()==null){
            customer.setAddress(addressRepository.save(customer.getAddress()));
        }

        customer.setComments(customer.getComments().stream()
                .map(comment -> comment.getId()!=null?comment:commentRepository.save(comment))
                .collect(Collectors.toSet()));

        Customer savedCustomer=customerRepository.save(customer);

         customer.setOrders(customer.getOrders().stream()
                 .map(order -> {
                     {
                         order.setCustomer(savedCustomer);
                         return order.getId() != null ? order : orderRepository.save(order);
                     }
                 })
                 .collect(Collectors.toSet()));



        return savedCustomer;
    }

    @Override
    public List<OrderDTO> getOrders(Long id) {
        return customerRepository.findAllOrders(id).stream().map(orderMapper::orderToOrderDTO).collect(Collectors.toList());
    }

    @Override
    public List<Comment> getComments(Long id) {
        return customerRepository.findAllComments(id);
    }

}
