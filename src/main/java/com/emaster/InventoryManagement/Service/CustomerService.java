package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.CustomerDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface CustomerService {
    CommonResponse saveCustomer(CustomerDTO customerDTO);

    CommonResponse updateCustomer(CustomerDTO customerDTO);

    CommonResponse deleteCustomer(Long customerId);

    CommonResponse getAllCustomers();

    CommonResponse getCustomer(Long customerId);
}
