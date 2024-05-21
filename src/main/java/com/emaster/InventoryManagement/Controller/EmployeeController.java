package com.emaster.InventoryManagement.Controller;


import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Service.EmployeeService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/employeeManagement")
public class EmployeeController {



private final EmployeeService employeeService;

@Autowired
public EmployeeController(EmployeeService employeeService){
    this.employeeService=employeeService;
}

    @PostMapping(path="/saveEmployee")
    public CommonResponse saveEmployee(@RequestBody EmployeeDTO employeeDTO){

        return employeeService.saveEmployee(employeeDTO);

    }
    @PutMapping(path="/updateEmployee")
    public CommonResponse updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping(path="/deleteEmployee")
    public CommonResponse deleteEmployee(@PathVariable Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping(path="/getAllEmployee")
    public CommonResponse getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(path="/getEmployee")
    public CommonResponse getEmployee(@PathVariable String employeeId){
        return employeeService.getEmployee(employeeId);
    }
}
