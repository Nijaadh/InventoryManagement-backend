package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.CatageryDTO;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Service.CategeryService;
import com.emaster.InventoryManagement.Service.EmployeeService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/catageryManagement")
public class catageryController {

    private final CategeryService catageryService;


    @Autowired
    public catageryController(CategeryService catageryService){
        this.catageryService=catageryService;
    }

    @GetMapping(path="")
    public String home(){
        return "Category controller";
    }

    @PostMapping(path="/saveCategory")
    public CommonResponse saveCategery(@RequestBody CatageryDTO catagsaeryDTO){

        return catageryService.saveCategory(catagsaeryDTO);

    }

    @PutMapping(path="/updateCategory")
    public CommonResponse updateCategery(@RequestBody CatageryDTO catagsaeryDTO){
        return catageryService.updateCategory(catagsaeryDTO);
    }

    @DeleteMapping(path="/deleteCategory/{catagsaeryId}")
    public CommonResponse deleteCategery(@PathVariable Long catagsaeryId){
        return catageryService.deleteCategory(catagsaeryId);
    }

    @GetMapping(path="/getAllCategory")
    public CommonResponse getAllCategery(){
        return catageryService.getAllCatagory();
    }

    @GetMapping(path="/getCategory/{categoryId}")
    public CommonResponse getEmployee(@PathVariable String categoryId){
        return catageryService.getCategery(categoryId);
    }

}
