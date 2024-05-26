package com.emaster.InventoryManagement.Repository;

import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Entity.Invoice_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_Item_Repository extends JpaRepository<Invoice_Item,Long> {

}
