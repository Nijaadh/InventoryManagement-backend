package com.emaster.InventoryManagement.Repository;

import com.emaster.InventoryManagement.Entity.Company;
import com.emaster.InventoryManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
