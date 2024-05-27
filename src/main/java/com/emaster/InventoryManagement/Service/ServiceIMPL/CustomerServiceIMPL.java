package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.CustomerDTO;
import com.emaster.InventoryManagement.Entity.Customer;
import com.emaster.InventoryManagement.Repository.CustomerRepository;
import com.emaster.InventoryManagement.Service.CustomerService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import com.emaster.InventoryManagement.Util.EntityToDtoCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceIMPL(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CommonResponse saveCustomer(CustomerDTO customerDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList;

        try {
            validationList = this.customerValidation(customerDTO);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Customer save failed.");
                return commonResponse;
            }

            Customer customer = DtoToEntityCast.castCustomerDtoInToCustomer(customerDTO);
            customer = customerRepository.save(customer);
            commonResponse.setPayload(Collections.singletonList(customer));
            commonResponse.setCommonMessage("Customer saved successfully.");
            commonResponse.setStatus(true);

        } catch (Exception e) {
            LOGGER.error("Exception in Customer Service -> saveCustomer!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateCustomer(CustomerDTO customerDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.customerValidation(customerDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Customer update failed.");
                return commonResponse;
            }

            Optional<Customer> optionalCustomer = customerRepository.findById(customerDTO.getCusId());
            if (optionalCustomer.isPresent()) {
                Customer updatedCustomer = DtoToEntityCast.castCustomerDtoInToCustomer(customerDTO);
                customerRepository.save(updatedCustomer);
                commonResponse.setPayload(Collections.singletonList(updatedCustomer));
                commonResponse.setCommonMessage("Customer updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Customer not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Customer Service -> updateCustomer!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteCustomer(Long customerId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingCustomerValidation(customerId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Customer deletion failed.");
                return commonResponse;
            }

            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                customer.setCommonStatus(CommonStatus.DELETE);
                customerRepository.save(customer);
                commonResponse.setPayload(Collections.singletonList(customer));
                commonResponse.setCommonMessage("Customer deleted successfully.");
                commonResponse.setStatus(true);
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Customer Service -> deleteCustomer!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllCustomers() {
        CommonResponse commonResponse = new CommonResponse();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        try {
            Predicate<Customer> filterOnStatus = customer -> customer.getCommonStatus() != CommonStatus.DELETE;
            customerDTOList = customerRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castCustomerInToCustomerDto)
                    .collect(Collectors.toList());

            if (customerDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Customer list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(customerDTOList));
            commonResponse.setCommonMessage("Customer list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Customer Service -> getAllCustomers!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getCustomer(Long customerId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Customer existingCustomer;

        try {
            validationList = this.existingCustomerValidation(customerId);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get customer failed.");
                return commonResponse;
            }

            existingCustomer = customerRepository.findById(customerId).orElse(null);
            if (existingCustomer != null) {
                commonResponse.setPayload(Collections.singletonList(existingCustomer));
                commonResponse.setCommonMessage("Customer retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Customer not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Customer Service -> getCustomer!", e);
        }
        return commonResponse;
    }

    public List<String> customerValidation(CustomerDTO customerDTO) {
        ArrayList<String> validationList = new ArrayList<>();

        // Empty checking
        if (CommonValidation.iDNullValidation(customerDTO.getCusId())) {
            validationList.add(CommonMsg.EMPTY_ID);
        }
        if (CommonValidation.stringNullValidation(customerDTO.getCusFName())) {
            validationList.add(CommonMsg.EMPTY_NAME);
        }
        if (CommonValidation.stringNullValidation(customerDTO.getCusLName())) {
            validationList.add(CommonMsg.EMPTY_NAME);
        }
        if (CommonValidation.stringNullValidation(customerDTO.getCusGmail())) {
            validationList.add(CommonMsg.EMPTY_EMAIL);
        }
        if (CommonValidation.stringNullValidation(customerDTO.getCusContactNo())) {
            validationList.add(CommonMsg.EMPTY_CONTACT_NO);
        }
        if (CommonValidation.stringNullValidation(customerDTO.getCusAddress())) {
            validationList.add(CommonMsg.EMPTY_ADDRESS);
        }
        if (CommonValidation.commenStatusNullValidation(customerDTO.getCommonStatus())) {
            validationList.add(CommonMsg.EMPTY_STATUS);
        }

        // Invalid checking
        if (CommonValidation.isValidId(customerDTO.getCusId())) {
            validationList.add(CommonMsg.INVALID_ID);
        }
        if (CommonValidation.isValidName(customerDTO.getCusFName())) {
            validationList.add(CommonMsg.INVALID_NAME);
        }
        if (CommonValidation.isValidName(customerDTO.getCusLName())) {
            validationList.add(CommonMsg.INVALID_NAME);
        }
        if (CommonValidation.isValidEmail(customerDTO.getCusGmail())) {
            validationList.add(CommonMsg.INVALID_EMAIL);
        }
        if (CommonValidation.isValidContactNo(customerDTO.getCusContactNo())) {
            validationList.add(CommonMsg.INVALID_CONTACT_NO);
        }
        if (CommonValidation.isValidText(customerDTO.getCusAddress())) {
            validationList.add(CommonMsg.INVALID_ADDRESS);
        }
        if (CommonValidation.isValidCommenStatus(customerDTO.getCommonStatus())) {
            validationList.add(CommonMsg.INVALID_STATUS);
        }

        return validationList;
    }

    private List<String> existingCustomerValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if customer exists
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the customer doesn't exist
        }

        // Further check on the status
        Customer existingCustomer = optionalCustomer.get();
        if (existingCustomer.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }
}
