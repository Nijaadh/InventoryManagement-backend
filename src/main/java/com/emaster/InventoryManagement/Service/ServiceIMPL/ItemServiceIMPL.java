package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Entity.Catagery;
import com.emaster.InventoryManagement.Entity.Item;
import com.emaster.InventoryManagement.Repository.CatageryRepository;
import com.emaster.InventoryManagement.Repository.ItemRepository;
import com.emaster.InventoryManagement.Service.ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import com.emaster.InventoryManagement.Util.EntityToDtoCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class ItemServiceIMPL implements ItemService {



    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceIMPL(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }


    @Override
    public CommonResponse saveItem(ItemDTO itemDTO) {

        CommonResponse commonResponse = new CommonResponse();
        Item item =new Item();
        List<String> validationList;



        try{
            validationList=this.itemValidation(itemDTO);

            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("item save Faild..");
                return commonResponse;
            }



            item= DtoToEntityCast.castItemDtoInToItem(itemDTO);
            item=itemRepository.save(item);
            commonResponse.setPayload(Collections.singletonList(item));
            commonResponse.setCommonMessage("Item Saved successfully");
            commonResponse.setStatus(true);


        }
        catch (Exception e){
            e.getStackTrace();

            LOGGER.error("/************************************Exception in Item Service -> saveItem(^)!");
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateItem(ItemDTO itemDTO) {

        CommonResponse commonResponse = new CommonResponse();
        List<String>validationList = this.itemValidation(itemDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Item update failed.");
                return commonResponse;
            }

            Optional<Item> optionalItem = itemRepository.findById(itemDTO.getItemId());
            if (optionalItem.isPresent()) {
                Item updatedItem = DtoToEntityCast.castItemDtoInToItem(itemDTO);
                itemRepository.save(updatedItem);
                commonResponse.setPayload(Collections.singletonList(updatedItem));
                commonResponse.setCommonMessage("Item updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Item not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Item Service -> updateItem!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteItem(Long itemId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingItemValidation(itemId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Item deletion failed.");
                return commonResponse;
            }

            Optional<Item> optionalItem = itemRepository.findById(itemId);
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                item.setCommonStatus(CommonStatus.DELETE);
                itemRepository.save(item);
                commonResponse.setPayload(Collections.singletonList(item));
                commonResponse.setCommonMessage("Item deleted successfully.");
                commonResponse.setStatus(true);
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Item Service -> deleteItem!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllItem() {
        CommonResponse commonResponse = new CommonResponse();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        try {
            Predicate<Item> filterOnStatus = item -> item.getCommonStatus() != CommonStatus.DELETE;
            itemDTOList = itemRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castItemIntoItemDto)
                    .collect(Collectors.toList());

            if (itemDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Item list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(itemDTOList));
            commonResponse.setCommonMessage("Item list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Item Service -> getAllItem!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getItem(String itemId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Item existingItem;

        try {
            Long id = Long.valueOf(itemId);
            validationList = this.existingItemValidation(id);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get item failed.");
                return commonResponse;
            }

            existingItem = itemRepository.findById(id).orElse(null);
            if (existingItem != null) {
                commonResponse.setPayload(Collections.singletonList(existingItem));
                commonResponse.setCommonMessage("Item retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Item not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Item Service -> getItem!", e);
        }
        return commonResponse;
    }

    public List<String>itemValidation(ItemDTO itemDTO){
        ArrayList<String>validationList=new ArrayList<>();

//  *******************************************EMPTY-CHECKING****************************************************
        if(CommonValidation.iDNullValidation(itemDTO.getItemId())){
            validationList.add(CommonMsg.EMPTY_ID);
        }if(CommonValidation.stringNullValidation(itemDTO.getItemName())){
            validationList.add(CommonMsg.EMPTY_NAME);
        }if(CommonValidation.stringNullValidation(itemDTO.getItemDiscription())) {
            validationList.add(CommonMsg.EMPTY_DISCRIPTION);
        }if(CommonValidation.integerNumberNullValidation(itemDTO.getItemQty())){
            validationList.add(CommonMsg.EMPTY_QTY);
        }if(CommonValidation.integerNumberNullValidation(itemDTO.getItem_reorderLevel())){
            validationList.add(CommonMsg.EMPTY_QTY);

            //price validation missing..

        }if(CommonValidation.stringNullValidation(itemDTO.getItemImage())) {
            validationList.add(CommonMsg.EMPTY_IMAGE_PATH);
        }if(CommonValidation.LongNumberNullValidation(itemDTO.getItemCatId())){
            validationList.add(CommonMsg.EMPTY_FORIEGN_KEY_VALUE);
        }if(CommonValidation.LongNumberNullValidation(itemDTO.getItemComId())){
            validationList.add(CommonMsg.EMPTY_FORIEGN_KEY_VALUE);
        }if(CommonValidation.commenStatusNullValidation(itemDTO.getItemCommonStatus())) {
            validationList.add(CommonMsg.EMPTY_STATUS);

//  *******************************************EMPTY-CHECKING****************************************************

//  *******************************************INVALID-CHECKING****************************************************
        }if(CommonValidation.isValidId(itemDTO.getItemId())){
            validationList.add(CommonMsg.INVALID_ID);
        }if(CommonValidation.isValidName(itemDTO.getItemName())){
            validationList.add(CommonMsg.INVALID_NAME);
        }if(CommonValidation.isValidText(itemDTO.getItemDiscription())) {
            validationList.add(CommonMsg.INVALID_DISCRIPTION);
        }if(CommonValidation.isValidIntegerNumber(itemDTO.getItemQty())){
            validationList.add(CommonMsg.INVALID_QTY);
        }if(CommonValidation.isValidIntegerNumber(itemDTO.getItem_reorderLevel())){
            validationList.add(CommonMsg.INVALID_QTY);

            //price validation missing..
            //image path validation missing..

        }if(CommonValidation.isValidLongNumber(itemDTO.getItemCatId())) {
            validationList.add(CommonMsg.INVALID_FORIEGN_KEY_VALUE);
        }if(CommonValidation.isValidLongNumber(itemDTO.getItemComId())){
            validationList.add(CommonMsg.INVALID_FORIEGN_KEY_VALUE);
        }if(CommonValidation.isValidCommenStatus(itemDTO.getItemCommonStatus())){
            validationList.add(CommonMsg.INVALID_STATUS);
        }
//  *******************************************INVALID-CHECKING****************************************************
        return validationList;
    }

    private List<String> existingItemValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if item exists
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (!optionalItem.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the item doesn't exist
        }

        // Further check on the status
        Item existingItem = optionalItem.get();
        if (existingItem.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }

}
