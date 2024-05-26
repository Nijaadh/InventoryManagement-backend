package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface ItemService {
    CommonResponse saveItem(ItemDTO itemDTO);

    CommonResponse updateItem(ItemDTO itemDTO);

    CommonResponse deleteItem(Long itemId);

    CommonResponse getAllItem();

    CommonResponse getItem(String itemId);
}
