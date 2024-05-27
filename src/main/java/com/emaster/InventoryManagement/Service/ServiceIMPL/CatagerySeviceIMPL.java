package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
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
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingCategoryValidation(catagsaeryId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Category deletion failed.");
                return commonResponse;
            }

            Optional<Catagery> optionalCategory = catageryRepository.findById(catagsaeryId);
            if (optionalCategory.isPresent()) {
                Catagery catagery = optionalCategory.get();
                catagery.setCommonStatus(CommonStatus.DELETE);
                catageryRepository.save(catagery);
                commonResponse.setPayload(Collections.singletonList(catagery));
                commonResponse.setCommonMessage("Category deleted successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Category not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Category Service -> deleteCategory!", e);
        }
        return commonResponse;
    }
    @Override
    public CommonResponse getAllCatagory() {
        CommonResponse commonResponse = new CommonResponse();
        List<CatageryDTO> catageryDTOList = new ArrayList<>();

        try {
            Predicate<Catagery> filterOnStatus = catagery -> catagery.getCommonStatus() != CommonStatus.DELETE;
            catageryDTOList = catageryRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castCategoryIntoCategoryDto)
                    .collect(Collectors.toList());

            if (catageryDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Category list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(catageryDTOList));
            commonResponse.setCommonMessage("Category list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Category Service -> getAllCategory!", e);
        }
        return commonResponse;
    }
    @Override
    public CommonResponse getCategery(String categoryId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Catagery existingCategory;

        try {
            Long id = Long.valueOf(categoryId);
            validationList = this.existingCategoryValidation(id);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get category failed.");
                return commonResponse;
            }

            existingCategory = catageryRepository.findById(id).orElse(null);
            if (existingCategory != null) {
                commonResponse.setPayload(Collections.singletonList(existingCategory));
                commonResponse.setCommonMessage("Category retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Category not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Category Service -> getCategory!", e);
        }
        return commonResponse;
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


    private List<String> existingCategoryValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList;
        }

        Optional<Catagery> optionalCategory = catageryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList;
        }

        Catagery existingCategory = optionalCategory.get();
        if (existingCategory.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }

}
