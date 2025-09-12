package com.ahmadi.onlineshop.unit.repository;

import com.ahmadi.onlineshop.entity.Customer;
import com.ahmadi.onlineshop.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setup() {

        customer1 = new Customer();
        customer1.setFirstName("Ali");
        customer1.setLastName("Ahmadi");
        customer1.setPhone("09120000001");

        customer2 = new Customer();
        customer2.setFirstName("Sara");
        customer2.setLastName("Ahmadi");
        customer2.setPhone("09120000002");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @Test
    void testFindByFirstNameAndLastNameContainingIgnoreCase() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Customer> result = customerRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("Ali", "Ahmadi", pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals("Ali", result.getContent().get(0).getFirstName());
        assertEquals("Ahmadi", result.getContent().get(0).getLastName());
    }

    @Test
    void testFindByPhoneContaining() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Customer> result = customerRepository.findByPhoneContaining("0912000000", pageable);

        assertEquals(2, result.getTotalElements());
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Reza");
        customer.setLastName("Mohammadi");
        customer.setPhone("09120000003");

        Customer saved = customerRepository.save(customer);

        assertNotNull(saved.getId());
        assertEquals("Reza", saved.getFirstName());
        assertEquals("Mohammadi", saved.getLastName());
    }

    @Test
    void testFindById() {
        Optional<Customer> found = customerRepository.findById(customer1.getId());
        assertTrue(found.isPresent());
        assertEquals("Ali", found.get().getFirstName());
    }

    @Test
    void testFindAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        assertNotNull(customers);
        assertTrue(((Collection<?>) customers).size() >= 2);
    }

    @Test
    void testDeleteCustomer() {
        customerRepository.deleteById(customer1.getId());
        Optional<Customer> deleted = customerRepository.findById(customer1.getId());
        assertFalse(deleted.isPresent());
    }

    @Test
    void testFindByFirstNameAndLastNameContainingIgnoreCase_Found() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Customer> result = customerRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("ali", "ahmadi", pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals("Ali", result.getContent().get(0).getFirstName());
    }

    @Test
    void testFindByFirstNameAndLastNameContainingIgnoreCase_NotFound() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Customer> result = customerRepository
                .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("nonexistent", "ahmadi", pageable);

        assertEquals(0, result.getTotalElements());
    }

    @Test
    void testFindByPhoneContaining_FoundMultiple() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Customer> result = customerRepository.findByPhoneContaining("0912000000", pageable);

        assertEquals(2, result.getTotalElements());
    }

    @Test
    void testFindByPhoneContaining_NotFound() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Customer> result = customerRepository.findByPhoneContaining("0000000000", pageable);

        assertEquals(0, result.getTotalElements());
    }

    @Test
    void testPagination() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<Customer> page1 = customerRepository.findByPhoneContaining("0912", pageable);
        assertEquals(1, page1.getContent().size());
        assertEquals(2, page1.getTotalElements());

        Pageable pageable2 = PageRequest.of(1, 1);
        Page<Customer> page2 = customerRepository.findByPhoneContaining("0912", pageable2);
        assertEquals(1, page2.getContent().size());
    }
}
