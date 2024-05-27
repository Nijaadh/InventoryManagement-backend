package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.CustomerDTO;
import com.emaster.InventoryManagement.Service.CustomerService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/customerManagement")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "")
    public String home() {
        return "Customer management controller";
    }

    @PostMapping(path = "/saveCustomer")
    public CommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(path = "/updateCustomer")
    public CommonResponse updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping(path = "/deleteCustomer/{customerId}")
    public CommonResponse deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping(path = "/getAllCustomers")
    public CommonResponse getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/getCustomer/{customerId}")
    public CommonResponse getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }
}
