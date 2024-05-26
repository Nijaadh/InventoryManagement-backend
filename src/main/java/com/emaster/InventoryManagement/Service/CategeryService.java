package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.CatageryDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface CategeryService {
    CommonResponse saveCategory(CatageryDTO catagsaeryDTO);

    CommonResponse updateCategory(CatageryDTO catagsaeryDTO);


    CommonResponse deleteCategory(Long catagsaeryId);

    CommonResponse getAllCatagory();

    CommonResponse getCategery(String employeeId);
}
