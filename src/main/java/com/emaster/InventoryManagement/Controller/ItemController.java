package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Service.ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/itemManagement")
public class ItemController {

    private final ItemService itemService;
    private static final String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/UPLOAD_IMAGES/";

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/saveItem")
    public CommonResponse saveItem(@RequestBody ItemDTO itemDTO) {
        try {
            System.out.println("working item save controller starting");
//
//            // Ensure the upload directory exists
//            Path uploadPath = Paths.get(uploadDirectory);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            String originalFileName = file.getOriginalFilename();
//            Path filePathWithName = Paths.get(uploadDirectory, originalFileName);
//            Files.write(filePathWithName, file.getBytes());
//
//            itemDTO.setItemImage(originalFileName);

            System.out.println("working item save controller before service call");
            return itemService.saveItem(itemDTO);

        } catch (Exception e) {
            CommonResponse response = new CommonResponse();
            response.setCommonMessage("Failed to save item");
            response.setErrorMessages(Collections.singletonList(e.getMessage()));
            response.setStatus(false);
            return response;
        }
    }


    @PutMapping(path = "/updateItem")
    public CommonResponse updateItem(@RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(itemDTO);
    }

    @DeleteMapping(path = "/deleteItem/{itemId}")
    public CommonResponse deleteItem(@PathVariable Long itemId) {
        try {
            return itemService.deleteItem(itemId);
        } catch (Exception e) {
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setCommonMessage("Failed to delete item");
            commonResponse.setErrorMessages(Collections.singletonList(e.getMessage()));
            commonResponse.setStatus(false);
            return commonResponse;
        }
    }

    @GetMapping(path = "/getAllItem")
    public CommonResponse getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping(path = "/getItem/{itemId}")
    public CommonResponse getItem(@PathVariable String itemId) {
        return itemService.getItem(itemId);
    }
}
