package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {
    CommonResponse saveEmployee(EmployeeDTO employeeDTO);

    CommonResponse updateEmployee(EmployeeDTO employeeDTO);

    CommonResponse deleteEmployee(Long employeeId);

    CommonResponse getAllEmployee();

    CommonResponse getEmployee(Long employeeId);
}
