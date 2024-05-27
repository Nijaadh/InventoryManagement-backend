package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.ComapnyDTO;
import com.emaster.InventoryManagement.Entity.Company;
import com.emaster.InventoryManagement.Repository.CompanyRepository;
import com.emaster.InventoryManagement.Service.ComapnyService;
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
public class CompanyServiceIMPL implements ComapnyService {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyServiceIMPL(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public CommonResponse saveCompany(ComapnyDTO companyDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList;

        try {
            validationList = this.companyValidation(companyDTO);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Company save failed.");
                return commonResponse;
            }

            Company company = DtoToEntityCast.castCompanyDtoInToCompany(companyDTO);
            company = companyRepository.save(company);
            commonResponse.setPayload(Collections.singletonList(company));
            commonResponse.setCommonMessage("Company saved successfully.");
            commonResponse.setStatus(true);

        } catch (Exception e) {
            LOGGER.error("Exception in Company Service -> saveCompany!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateCompany(ComapnyDTO companyDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.companyValidation(companyDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Company update failed.");
                return commonResponse;
            }

            Optional<Company> optionalCompany = companyRepository.findById(companyDTO.getComId());
            if (optionalCompany.isPresent()) {
                Company updatedCompany = DtoToEntityCast.castCompanyDtoInToCompany(companyDTO);
                companyRepository.save(updatedCompany);
                commonResponse.setPayload(Collections.singletonList(updatedCompany));
                commonResponse.setCommonMessage("Company updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Company not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Company Service -> updateCompany!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteCompany(Long companyId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingCompanyValidation(companyId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Company deletion failed.");
                return commonResponse;
            }

            Optional<Company> optionalCompany = companyRepository.findById(companyId);
            if (optionalCompany.isPresent()) {
                Company company = optionalCompany.get();
                company.setCommonStatus(CommonStatus.DELETE);
                companyRepository.save(company);
                commonResponse.setPayload(Collections.singletonList(company));
                commonResponse.setCommonMessage("Company deleted successfully.");
                commonResponse.setStatus(true);
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Company Service -> deleteCompany!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllCompanies() {
        CommonResponse commonResponse = new CommonResponse();
        List<ComapnyDTO> companyDTOList = new ArrayList<>();

        try {
            Predicate<Company> filterOnStatus = company -> company.getCommonStatus() != CommonStatus.DELETE;
            companyDTOList = companyRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castCompanyInToCompanyDto)
                    .collect(Collectors.toList());

            if (companyDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Company list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(companyDTOList));
            commonResponse.setCommonMessage("Company list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Company Service -> getAllCompanies!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getCompany(Long companyId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Company existingCompany;

        try {
            validationList = this.existingCompanyValidation(companyId);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get company failed.");
                return commonResponse;
            }

            existingCompany = companyRepository.findById(companyId).orElse(null);
            if (existingCompany != null) {
                commonResponse.setPayload(Collections.singletonList(existingCompany));
                commonResponse.setCommonMessage("Company retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Company not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Company Service -> getCompany!", e);
        }
        return commonResponse;
    }

    public List<String> companyValidation(ComapnyDTO companyDTO) {
        ArrayList<String> validationList = new ArrayList<>();

        // Empty checking
        if (CommonValidation.iDNullValidation(companyDTO.getComId())) {
            validationList.add(CommonMsg.EMPTY_ID);
        }
        if (CommonValidation.stringNullValidation(companyDTO.getComName())) {
            validationList.add(CommonMsg.EMPTY_NAME);
        }
        if (CommonValidation.stringNullValidation(companyDTO.getHotline())) {
            validationList.add(CommonMsg.EMPTY_CONTACT_NO);
        }
        if (CommonValidation.stringNullValidation(companyDTO.getGmail())) {
            validationList.add(CommonMsg.EMPTY_GMAIL);
        }
        if (CommonValidation.stringNullValidation(companyDTO.getAddress())) {
            validationList.add(CommonMsg.EMPTY_ADDRESS);
        }
        if (CommonValidation.commenStatusNullValidation(companyDTO.getCommonStatus())) {
            validationList.add(CommonMsg.EMPTY_STATUS);
        }

        // Invalid checking
        if (CommonValidation.isValidId(companyDTO.getComId())) {
            validationList.add(CommonMsg.INVALID_ID);
        }
        if (CommonValidation.isValidName(companyDTO.getComName())) {
            validationList.add(CommonMsg.INVALID_NAME);
        }
        if (CommonValidation.isValidContactNo(companyDTO.getHotline())) {
            validationList.add(CommonMsg.INVALID_CONTACT_NO);
        }
        if (CommonValidation.isValidEmail(companyDTO.getGmail())) {
            validationList.add(CommonMsg.INVALID_EMAIL);
        }
        if (CommonValidation.isValidText(companyDTO.getAddress())) {
            validationList.add(CommonMsg.INVALID_ADDRESS);
        }
        if (CommonValidation.isValidCommenStatus(companyDTO.getCommonStatus())) {
            validationList.add(CommonMsg.INVALID_STATUS);
        }

        return validationList;
    }

    private List<String> existingCompanyValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if company exists
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the company doesn't exist
        }

        // Further check on the status
        Company existingCompany = optionalCompany.get();
        if (existingCompany.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }
}
