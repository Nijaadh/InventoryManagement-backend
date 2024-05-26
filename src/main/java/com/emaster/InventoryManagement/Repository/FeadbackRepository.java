package com.emaster.InventoryManagement.Repository;

import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Entity.Feadback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeadbackRepository extends JpaRepository<Feadback,Long> {
}
