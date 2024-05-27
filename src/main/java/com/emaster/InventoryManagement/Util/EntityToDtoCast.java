package com.emaster.InventoryManagement.Util;

import com.emaster.InventoryManagement.DTO.*;
import com.emaster.InventoryManagement.Entity.*;

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

    public static CatageryDTO castCategoryIntoCategoryDto(Catagery catagery) {
        CatageryDTO catageryDTO = new CatageryDTO();

        catageryDTO.setCatId(catagery.getCatId());
        catageryDTO.setCatName(catagery.getCatName());
        catageryDTO.setCatDiscription(catagery.getCatDiscription());
        catageryDTO.setCommonStatus(catagery.getCommonStatus());
        return catageryDTO;

    }

    public static ComapnyDTO castCompanyInToCompanyDto(Company company) {
        ComapnyDTO companyDTO = new ComapnyDTO();
        companyDTO.setComId(company.getComId());
        companyDTO.setComName(company.getComName());
        companyDTO.setHotline(company.getHotline());
        companyDTO.setGmail(company.getGmail());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setCommonStatus(company.getCommonStatus());
        return companyDTO;
    }

    public static CustomerDTO castCustomerInToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCusId(customer.getCusId());
        customerDTO.setCusFName(customer.getCusFName());
        customerDTO.setCusLName(customer.getCusLName());
        customerDTO.setCusNIC(customer.getCusNIC());
        customerDTO.setCusGender(customer.getCusGender());
        customerDTO.setCusGmail(customer.getCusGmail());
        customerDTO.setCusDOB(customer.getCusDOB());
        customerDTO.setCusContactNo(customer.getCusContactNo());
        customerDTO.setCusAddress(customer.getCusAddress());
        customerDTO.setCusUserName(customer.getCusUserName());
        customerDTO.setCusPassword(customer.getCusPassword());
        customerDTO.setCommonStatus(customer.getCommonStatus());

        return customerDTO;
    }

    public static FeadbackDTO castFeedbackInToFeedbackDto(Feadback feadback) {
        if (feadback == null) {
            return null;
        }

        FeadbackDTO feedbackDTO = new FeadbackDTO();
        feedbackDTO.setFeadbackId(feadback.getFeadbackId());
        feedbackDTO.setCusId(feadback.getCusId());
        feedbackDTO.setFeadback(feadback.getFeadback());
        feedbackDTO.setCommonStatus(feadback.getCommonStatus());

        return feedbackDTO;
    }

    public static InvoiceDTO castInvoiceIntoInvoiceDto(Invoice invoice) {
        if (invoice == null) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceId(invoice.getInvoiceId());
        invoiceDTO.setInvoiceDate(invoice.getInvoiceDate());
        invoiceDTO.setInvoiceAmmount(invoice.getInvoiceAmmount());
        invoiceDTO.setInvoicePaidAmmount(invoice.getInvoicePaidAmmount());
        invoiceDTO.setInvoiceBalanceAmmount(invoice.getInvoiceBalanceAmmount());
        invoiceDTO.setInvoice_cusId(invoice.getInvoice_cusId());
        invoiceDTO.setCommonStatus(invoice.getCommonStatus());

        return invoiceDTO;
    }

}
