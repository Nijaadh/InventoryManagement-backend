package com.emaster.InventoryManagement.Repository;

import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
