package com.example.demo.Controllers;

import com.example.demo.Entities.Bill;
/*
import com.example.demo.Repositories.BillRepository;
import com.example.demo.Repositories.ProductItemRepository;
*/

import com.example.demo.Repositories.BillRepository;
import com.example.demo.Repositories.ProductItemRepository;
import com.example.demo.Services.CustomerServiceClient;
import com.example.demo.Services.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired

    private CustomerServiceClient customerServiceClient;

    @Autowired
    private InventoryServiceClient inventoryServiceClient;


    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id ){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerId()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        System.out.println(bill.getProductItems().size());
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductId()));
        });
        return bill ;
    }


}
