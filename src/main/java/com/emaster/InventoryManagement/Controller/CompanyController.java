package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.ComapnyDTO;
import com.emaster.InventoryManagement.Service.ComapnyService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/companyManagement")
public class CompanyController {


    private final ComapnyService companyService;

    @Autowired
    public CompanyController(ComapnyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "")
    public String home() {
        return "Company management controller";
    }

    @PostMapping(path = "/saveCompany")
    public CommonResponse saveCompany(@RequestBody ComapnyDTO companyDTO) {
        return companyService.saveCompany(companyDTO);
    }

    @PutMapping(path = "/updateCompany")
    public CommonResponse updateCompany(@RequestBody ComapnyDTO companyDTO) {
        return companyService.updateCompany(companyDTO);
    }

    @DeleteMapping(path = "/deleteCompany/{companyId}")
    public CommonResponse deleteCompany(@PathVariable Long companyId) {
        return companyService.deleteCompany(companyId);
    }

    @GetMapping(path = "/getAllCompanies")
    public CommonResponse getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/getCompany/{companyId}")
    public CommonResponse getCompany(@PathVariable Long companyId) {
        return companyService.getCompany(companyId);
    }
}
