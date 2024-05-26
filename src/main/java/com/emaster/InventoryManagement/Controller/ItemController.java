package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Service.ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/itemManagement")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @PostMapping(path="/saveItem")
    public CommonResponse saveItem(@RequestBody ItemDTO itemDTO){

        return itemService.saveItem(itemDTO);

    }
    @PutMapping(path="/updateItem")
    public CommonResponse updateItem(@RequestBody ItemDTO itemDTO){
        return itemService.updateItem(itemDTO);
    }

    @DeleteMapping(path="/deleteItem")
    public CommonResponse deleteItem(@PathVariable Long itemId){
        return itemService.deleteItem(itemId);
    }

    @GetMapping(path="/getAllItem")
    public CommonResponse getAllItem(){
        return itemService.getAllItem();
    }

    @GetMapping(path="/getItem")
    public CommonResponse getItem(@PathVariable String itemId){
        return itemService.getEmployee(itemId);
    }
}
