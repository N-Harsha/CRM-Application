package com.ennea.valuemanage.Services;


import com.ennea.valuemanage.Model.Customer;

import com.ennea.valuemanage.Repositories.AddressRepository;
import com.ennea.valuemanage.Repositories.CommentRepository;
import com.ennea.valuemanage.Repositories.CustomerRepository;
import com.ennea.valuemanage.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    AddressRepository addressRepository;
    OrderRepository orderRepository;
    CommentRepository commentRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository, OrderRepository orderRepository, CommentRepository commentRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Customer save(Customer customer) {

        if(customer.getAddress()!=null&&customer.getAddress().getId()==null){
            customer.setAddress(addressRepository.save(customer.getAddress()));
        }

        Customer savedCustomer=customerRepository.save(customer);

         customer.setOrders(customer.getOrders().stream()
                 .map(order -> {
                     {
                         order.setCustomer(savedCustomer);
                         return order.getId() != null ? order : orderRepository.save(order);
                     }
                 })
                 .collect(Collectors.toSet()));

        customer.setComments(customer.getComments().stream()
                .map(comment -> comment.getId()!=null?comment:commentRepository.save(comment))
                .collect(Collectors.toSet()));

        return savedCustomer;
    }

}
