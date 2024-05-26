package com.emaster.InventoryManagement.Util;

import com.emaster.InventoryManagement.DTO.CatageryDTO;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Entity.Catagery;
import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Entity.Item;


public class DtoToEntityCast {
    public static Employee castEmployeeDtoInToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();


        employee.setEmpId(Long.valueOf(employeeDTO.getEmpId()));
        employee.setEmpFName(employeeDTO.getEmpFName());
        employee.setEmpLstName(String.valueOf(employeeDTO.getEmpLstName()));

        employee.setEmpNIC(employeeDTO.getEmpNIC());
        employee.setEmpGender(employeeDTO.getEmpGender());
        employee.setEmpDOB(String.valueOf(employeeDTO.getEmpDOB()));

        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpContactNo(String.valueOf(employeeDTO.getEmpContactNo()));

        employee.setEmpEmgContactNo(employeeDTO.getEmpEmgContactNo());
        employee.setEmpUserName(employeeDTO.getEmpUserName());
        employee.setEmpPassword(String.valueOf(employeeDTO.getEmpPassword()));

        employee.setEmpImage(employeeDTO.getEmpImage());

        employee.setCommonStatus(employeeDTO.getCommonStatus());

        employee.setEmpRoleId(Long.valueOf(employeeDTO.getEmpRoleId()));

        return employee;


    }


    public static Catagery castCategoryDtoInToCategory(CatageryDTO catageryDTO){
        Catagery catagery = new Catagery();

        catagery.setCatId(Long.valueOf(catageryDTO.getCatId()));
        catagery.setCatName(catageryDTO.getCatName());
        catagery.setCatDiscription(String.valueOf(catageryDTO.getCatDiscription()));
        catagery.setCommonStatus(catageryDTO.getCommonStatus());

        return catagery;
    }

    public static Item  castItemDtoInToItem(ItemDTO itemDTO){
        Item item = new Item();

        item.setItemId(itemDTO.getItemId());
        item.setItemName(itemDTO.getItemName());
        item.setItemDiscription(itemDTO.getItemDiscription());
        item.setItemQty(itemDTO.getItemQty());
        item.setItem_reorderLevel(itemDTO.getItem_reorderLevel());
        item.setItemPrice(itemDTO.getItemPrice());
        item.setItemImage(itemDTO.getItemImage());
        item.setItemCatId(itemDTO.getItemCatId());
        item.setItemComId(itemDTO.getItemComId());
        item.setCommonStatus(itemDTO.getItemCommonStatus());

        return item;
    }
}
