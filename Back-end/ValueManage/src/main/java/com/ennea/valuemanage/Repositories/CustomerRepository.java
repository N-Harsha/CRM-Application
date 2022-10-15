package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Comment;
import com.ennea.valuemanage.Model.Customer;
import com.ennea.valuemanage.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("select ord from Order ord where ord.customer.id=?1")
    List<Order> findAllOrders(Long id);

    @Query("select cust.comments from Customer cust where cust.id=?1")
    List<Comment> findAllComments(Long id);
}
