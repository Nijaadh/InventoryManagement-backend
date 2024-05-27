package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.ComapnyDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface ComapnyService {
    CommonResponse saveCompany(ComapnyDTO companyDTO);

    CommonResponse updateCompany(ComapnyDTO companyDTO);

    CommonResponse deleteCompany(Long companyId);

    CommonResponse getAllCompanies();

    CommonResponse getCompany(Long companyId);
}
