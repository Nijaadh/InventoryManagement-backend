package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.DTO.ItemDTO;
import com.emaster.InventoryManagement.Entity.Catagery;
import com.emaster.InventoryManagement.Entity.Item;
import com.emaster.InventoryManagement.Service.ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class ItemServiceIMPL implements ItemService {
    @Override
    public CommonResponse saveItem(ItemDTO itemDTO) {

        CommonResponse commonResponse = new CommonResponse();
        Item item =new Item();
        List<String> validationList;



        try{
            validationList=this.ItemValidation(itemDTO);

            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("item save Faild..");
                return commonResponse;
            }



            item= DtoToEntityCast.castCategoryDtoInToCategory(catagsaeryDTO);
            catagery=catageryRepository.save(catagery);
            commonResponse.setPayload(Collections.singletonList(catagery));
            commonResponse.setCommonMessage("Category Saved successfully");
            commonResponse.setStatus(true);


        }
        catch (Exception e){
            e.getStackTrace();

            LOGGER.error("/************************************Exception in Category Service -> saveCategory(^)!");
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateItem(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public CommonResponse deleteItem(Long itemId) {
        return null;
    }

    @Override
    public CommonResponse getAllItem() {
        return null;
    }

    @Override
    public CommonResponse getEmployee(String itemId) {
        return null;
    }

    public List<String>ItemValidation(ItemDTO itemDTO){
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
}
