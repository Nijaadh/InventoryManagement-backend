package com.emaster.InventoryManagement.Repository;

import com.emaster.InventoryManagement.Entity.Customer;
import com.emaster.InventoryManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
