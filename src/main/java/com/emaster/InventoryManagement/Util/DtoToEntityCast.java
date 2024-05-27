package com.emaster.InventoryManagement.Util;

import com.emaster.InventoryManagement.DTO.*;
import com.emaster.InventoryManagement.Entity.*;


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

    public static Company castCompanyDtoInToCompany(ComapnyDTO companyDTO){
        Company company = new Company();
        company.setComId(companyDTO.getComId());
        company.setComName(companyDTO.getComName());
        company.setHotline(companyDTO.getHotline());
        company.setGmail(companyDTO.getGmail());
        company.setAddress(companyDTO.getAddress());
        company.setCommonStatus(companyDTO.getCommonStatus());
        return company;

    }

    public static Customer castCustomerDtoInToCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setCusId(customerDTO.getCusId());
        customer.setCusFName(customerDTO.getCusFName());
        customer.setCusLName(customerDTO.getCusLName());
        customer.setCusNIC(customerDTO.getCusNIC());
        customer.setCusGender(customerDTO.getCusGender());
        customer.setCusGmail(customerDTO.getCusGmail());
        customer.setCusDOB(customerDTO.getCusDOB());
        customer.setCusContactNo(customerDTO.getCusContactNo());
        customer.setCusAddress(customerDTO.getCusAddress());
        customer.setCusUserName(customerDTO.getCusUserName());
        customer.setCusPassword(customerDTO.getCusPassword());
        customer.setCommonStatus(customerDTO.getCommonStatus());

        return customer;
    }

    public static Feadback castFeedbackDtoInToFeedback(FeadbackDTO feedbackDTO) {
        if (feedbackDTO == null) {
            return null;
        }

        Feadback feadback = new Feadback();
        feadback.setFeadbackId(feedbackDTO.getFeadbackId());
        feadback.setCusId(feedbackDTO.getCusId());
        feadback.setFeadback(feedbackDTO.getFeadback());
        feadback.setCommonStatus(feedbackDTO.getCommonStatus());

        return feadback;
    }

    public static Invoice castInvoiceDtoIntoInvoice(InvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return null;
        }

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceDTO.getInvoiceId());
        invoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        invoice.setInvoiceAmmount(invoiceDTO.getInvoiceAmmount());
        invoice.setInvoicePaidAmmount(invoiceDTO.getInvoicePaidAmmount());
        invoice.setInvoiceBalanceAmmount(invoiceDTO.getInvoiceBalanceAmmount());
        invoice.setInvoice_cusId(invoiceDTO.getInvoice_cusId());
        invoice.setCommonStatus(invoiceDTO.getCommonStatus());

        return invoice;
    }
}
