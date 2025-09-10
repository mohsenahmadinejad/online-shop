package com.ahmadi.onlineshop;


import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.entity.Order;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void saveCustomer() {
//        Customer customer=new Customer(null,"Mohsen","ahmadi","mohsen@gmail.com",null);
        Customer customer=Customer.builder().
                firstName("ali").
                lastName("ahmadi").
                address("tehran").
                build();
        customerRepository.save(customer);
    }


    @Test
    void updateCustomer() {
        Customer customer=Customer.builder().
                id(1L).
                firstName("hasan").
                lastName("ahmadi").
                address("tehran").
                build();

        customerRepository.save(customer);
    }

    @Test
    void findCustomerById() {
        Customer customer= customerRepository.findById(2L).get();
        System.out.println(customer);
    }
    @Test
    void findAllCustomerById() {
        List< Customer> customers= customerRepository.findAll();
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void deleteCustomer() {
        customerRepository.deleteById(5L);
    }

//    @Test
//    void findByFirstName() {
//        List<Customer> customers= customerRepository.findByFirstName("Ali");
//        customers.forEach(customer -> System.out.println(customer));
//    }








    @Test
    void saveCustomerWithOrders() {
        Order order1= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(10D)
                .build();
        Order order2= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(11D)
                .build();
//        List<Order> orderList=new ArrayList<>();
//        orderList.add(order1);
//        orderList.add(order2);



        Customer customer= Customer.builder()
                .address("rasht")
                .firstName("mohsen")
                .lastName("ahmadi")
                .orders(new ArrayList<>())
                .build();
        customer.addOrder(order1);
        customer.addOrder(order2);

//        order1.setCustomer(customer);
//        order2.setCustomer(customer);

        customerRepository.save(customer);

    }

    @Test
    @Transactional
    void getCustomerById() {
        Customer customer=customerRepository.findById(65L).get();
        System.out.println(customer.getOrders());

    }

}
