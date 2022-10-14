package com.ennea.valuemanage.Controllers.v1;

import com.ennea.valuemanage.API.v1.DTO.OrderDTO;
import com.ennea.valuemanage.Model.Comment;
import com.ennea.valuemanage.Services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"retailer/{id}/orders","distributor/{id}/orders"})
    public ResponseEntity<List<OrderDTO>> getCustomerOrders(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getOrders(id), HttpStatus.OK);
    }

    @GetMapping({"retailer/{id}/comments","distributor/{id}/comments"})
    public ResponseEntity<List<Comment>> getCustomerComments(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getComments(id),HttpStatus.OK);
    }


}
