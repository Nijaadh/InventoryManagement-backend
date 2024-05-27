package com.emaster.InventoryManagement.Util;

import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Entity.Item;

public class EntityToDtoCast {

    public static EmployeeDTO castEmployeeIntoEmployeeDto(Employee employeeEntity) {
        EmployeeDTO employeeDTO=new EmployeeDTO();

        employeeDTO.setEmpId(Long.valueOf(employeeEntity.getEmpId()));
        employeeDTO.setEmpFName(employeeEntity.getEmpFName());
        employeeDTO.setEmpLstName(String.valueOf(employeeEntity.getEmpLstName()));

        employeeDTO.setEmpNIC(employeeEntity.getEmpNIC());
        employeeDTO.setEmpGender(employeeEntity.getEmpGender());
        employeeDTO.setEmpDOB(String.valueOf(employeeEntity.getEmpDOB()));

        employeeDTO.setEmpEmail(employeeEntity.getEmpEmail());
        employeeDTO.setEmpAddress(employeeEntity.getEmpAddress());
        employeeDTO.setEmpContactNo(String.valueOf(employeeEntity.getEmpContactNo()));

        employeeDTO.setEmpEmgContactNo(employeeEntity.getEmpEmgContactNo());
        employeeDTO.setEmpUserName(employeeEntity.getEmpUserName());
        employeeDTO.setEmpPassword(String.valueOf(employeeEntity.getEmpPassword()));

        employeeDTO.setCommonStatus(employeeEntity.getCommonStatus());

        employeeDTO.setEmpRoleId(Long.valueOf(employeeEntity.getEmpRoleId()));

        return employeeDTO;
    }



    public static ItemDTO castItemIntoItemDto(Item item) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemId(item.getItemId());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setItemDiscription(item.getItemDiscription());
        itemDTO.setItemQty(item.getItemQty());
        itemDTO.setItem_reorderLevel(item.getItemQty());
        itemDTO.setItemPrice(item.getItemPrice());
        itemDTO.setItemImage(item.getItemImage());
        itemDTO.setItemCatId(item.getItemCatId());
        itemDTO.setItemComId(item.getItemComId());
        itemDTO.setItemCommonStatus(item.getCommonStatus());
        return itemDTO;
    }

}
