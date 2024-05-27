package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.DTO.CatageryDTO;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Entity.Catagery;
import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Repository.CatageryRepository;
import com.emaster.InventoryManagement.Repository.EmployeeRepository;
import com.emaster.InventoryManagement.Service.CategeryService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class CatagerySeviceIMPL implements CategeryService {


    @Autowired
    private final CatageryRepository catageryRepository;


    public CatagerySeviceIMPL(CatageryRepository catageryRepository){
        this.catageryRepository=catageryRepository;
    }


    @Override
    public CommonResponse saveCategory(CatageryDTO catagsaeryDTO) {

        CommonResponse commonResponse = new CommonResponse();
        Catagery catagery =new Catagery();
        List<String> validationList;



        try{
            validationList=this.CategeryValidation(catagsaeryDTO);

            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("category save Faild..");
                return commonResponse;
            }



            catagery= DtoToEntityCast.castCategoryDtoInToCategory(catagsaeryDTO);
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
    public CommonResponse updateCategory(CatageryDTO catagsaeryDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.CategeryValidation(catagsaeryDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Category update failed.");
                return commonResponse;
            }

            Optional<Catagery> optionalCategory = catageryRepository.findById(catagsaeryDTO.getCatId());
            if (optionalCategory.isPresent()) {
                Catagery updatedCategory = DtoToEntityCast.castCategoryDtoInToCategory(catagsaeryDTO);
                catageryRepository.save(updatedCategory);
                commonResponse.setPayload(Collections.singletonList(updatedCategory));
                commonResponse.setCommonMessage("Category updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Category not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Category Service -> updateCategory!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteCategory(Long catagsaeryId) {
        return null;
    }

    @Override
    public CommonResponse getAllCatagory() {
        return null;
    }

    @Override
    public CommonResponse getCategery(String employeeId) {
        return null;
    }


    private List<String> CategeryValidation(CatageryDTO catageryDTO) {
        List<String>validationList = new ArrayList<>();


//  *******************************************EMPTY-CHECKING****************************************************
        if(CommonValidation.iDNullValidation(catageryDTO.getCatId())){
            validationList.add(CommonMsg.EMPTY_ID);
        }if(CommonValidation.stringNullValidation(catageryDTO.getCatName())){
            validationList.add(CommonMsg.EMPTY_CAT_NAME);
        }if(CommonValidation.stringNullValidation(catageryDTO.getCatDiscription())){
            validationList.add(CommonMsg.EMPTY_CAT_DISCRIPTION);


//  *******************************************EMPTY-CHECKING****************************************************

//  *******************************************INVALID-CHECKING****************************************************
        }if(CommonValidation.isValidId(catageryDTO.getCatId())){
            validationList.add(CommonMsg.INVALID_ID);
        }if(CommonValidation.isValidName(catageryDTO.getCatName())){
            validationList.add(CommonMsg.INVALID_NAME);
        }if(CommonValidation.isValidText(catageryDTO.getCatDiscription())) {
            validationList.add(CommonMsg.INVALID_DISCRIPTION);
        }
//  *******************************************INVALID-CHECKING****************************************************
        return validationList;
    }


}
