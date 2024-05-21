package com.emaster.InventoryManagement.Util;

import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Entity.Employee;



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
}
