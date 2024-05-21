package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.EmployeeDTO;
import com.emaster.InventoryManagement.Entity.Employee;
import com.emaster.InventoryManagement.Repository.EmployeeRepository;
import com.emaster.InventoryManagement.Service.EmployeeService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import com.emaster.InventoryManagement.Util.EntityToDtoCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceIMPL (EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @Override
    public CommonResponse saveEmployee(EmployeeDTO employeeDTO) {
        CommonResponse commonResponse = new CommonResponse();
        Employee employee =new Employee();
        List<String> validationList;



        try{
            validationList=this.employeeValidation(employeeDTO);

            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("employee save Faild..");
                return commonResponse;
            }



            employee= DtoToEntityCast.castEmployeeDtoInToEmployee(employeeDTO);
            employee=employeeRepository.save(employee);
            commonResponse.setPayload(Collections.singletonList(employee));
            commonResponse.setCommonMessage("Employee Saved successfully");
            commonResponse.setStatus(true);


        }
        catch (Exception e){
            e.getStackTrace();

            LOGGER.error("/************************************Exception in Employee Service -> saveEmployee(^)!");
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateEmployee(EmployeeDTO employeeDTO) {
        CommonResponse commonResponse = new CommonResponse();
//        Employee employee = new Employee();
        List<String>validationList;

        validationList=this.employeeValidation(employeeDTO);

        try{

            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Update eployee faild");
                return commonResponse;
            }

            Employee existingEmployee = new Employee();
            Employee updatedEmployee = new Employee();


            existingEmployee=employeeRepository.getById(employeeDTO.getEmpId());

            if(existingEmployee!=null){
                updatedEmployee=DtoToEntityCast.castEmployeeDtoInToEmployee(employeeDTO);
                employeeRepository.save(updatedEmployee);
                commonResponse.setPayload(Collections.singletonList(updatedEmployee));
                commonResponse.setCommonMessage("Employee updated successfully");
                commonResponse.setStatus(true);

            }
        }catch (Exception e){
            LOGGER.error("/************************************Exception in Employee Service -> updateEmployee(^)!");
        }

        return commonResponse;
    }

    @Override
    public CommonResponse deleteEmployee(Long employeeId) {

        CommonResponse commonResponse = new CommonResponse();
        Employee employee = new Employee();
        List<String>validationList;

        validationList=this.existingEmployeeValidation(employeeId);

        try{
            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Employee Deletion Faild");
                return commonResponse;
            }
            employee.setCommonStatus(CommonStatus.DELETE);
            commonResponse.setPayload(Collections.singletonList(employee));
            commonResponse.setCommonMessage("Employee Delition Successfull");
            commonResponse.setStatus(true);

        }catch (Exception e){
            LOGGER.error("/**************** Exception in Employee Service -> deleteEmployee(^)!"+e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllEmployee() {
        CommonResponse commonResponse = new CommonResponse();
        List<EmployeeDTO>employeeDTOList= new ArrayList<>();

        try{
            Predicate<Employee> filterOnStatus= userEntity -> userEntity.getCommonStatus()!=CommonStatus.DELETE;
            employeeDTOList = employeeRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castEmployeeIntoEmployeeDto)
                    .collect(Collectors.toList());

            if(employeeDTOList.isEmpty()){
                commonResponse.setCommonMessage("employee list is empty");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(employeeDTOList));
            commonResponse.setCommonMessage("employee list get successfull");
            commonResponse.setStatus(true);

        }catch (Exception e){
            LOGGER.error("/**************** Exception in UserService -> deleteEmployee(^)!"+e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getEmployee(String employeeId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String>validationList=new ArrayList<>();
        Employee existingEmployee = new Employee();

        validationList=this.existingEmployeeValidation(Long.valueOf(employeeId));

        try{
            if(!validationList.isEmpty()){
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("get employee is faild");
                return commonResponse;
            }

            existingEmployee=employeeRepository.getById(Long.valueOf(employeeId));
            commonResponse.setPayload(Collections.singletonList(existingEmployee));
            commonResponse.setCommonMessage("Getting existing Employee Successfully");
            commonResponse.setStatus(true);

        }catch(Exception e){
            LOGGER.error("/**************** Exception in UserService -> getEmployee(^)!"+e);
        }

        return commonResponse;
    }


    private List<String> employeeValidation(EmployeeDTO employeeDTO) {
        List<String>validationList = new ArrayList<>();


//  *******************************************EMPTY-CHECKING****************************************************
        if(CommonValidation.iDNullValidation(employeeDTO.getEmpId())){
            validationList.add(CommonMsg.EMPTY_ID);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpFName())){
            validationList.add(CommonMsg.EMPTY_FIRST_NAME);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpLstName())){
            validationList.add(CommonMsg.EMPTY_LAST_NAME);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpNIC())){
            validationList.add(CommonMsg.EMPTY_NIC);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpDOB())){
            validationList.add(CommonMsg.EMPTY_DOB);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpEmail())){
            validationList.add(CommonMsg.EMPTY_EMAIL);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpAddress())){
            validationList.add(CommonMsg.EMPTY_ADDRESS);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpContactNo())){
            validationList.add(CommonMsg.EMPTY_CONTACT_NO);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpEmgContactNo())){
            validationList.add(CommonMsg.EMPTY_EMG_CONTACT_NO);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpUserName())){
            validationList.add(CommonMsg.EMPTY_USER_NAME);
        }if(CommonValidation.stringNullValidation(employeeDTO.getEmpPassword())){
            validationList.add(CommonMsg.EMPTY_PASSWORD);
//  *******************************************EMPTY-CHECKING****************************************************

//  *******************************************INVALID-CHECKING****************************************************
        }if(CommonValidation.isValidId(employeeDTO.getEmpId())){
            validationList.add(CommonMsg.INVALID_ID);
        }if(CommonValidation.isValidName(employeeDTO.getEmpFName())){
            validationList.add(CommonMsg.INVALID_FISRST_NAME);
        }if(CommonValidation.isValidName(employeeDTO.getEmpLstName())){
            validationList.add(CommonMsg.INVALID_LAST_NAME);
        }if(CommonValidation.isvalidNic(employeeDTO.getEmpNIC())){
            validationList.add(CommonMsg.INVALID_NIC);
        }if(CommonValidation.isValidDate(employeeDTO.getEmpDOB())){
            validationList.add(CommonMsg.INVALID_DOB);
        }if(CommonValidation.isValidEmail(employeeDTO.getEmpEmail())){
            validationList.add(CommonMsg.INVALID_EMAIL);
        }if(CommonValidation.isValidContactNo(employeeDTO.getEmpContactNo())){
            validationList.add(CommonMsg.INVALID_CONTACT_NO);
        }if(CommonValidation.isValidContactNo(employeeDTO.getEmpEmgContactNo())){
            validationList.add(CommonMsg.INVALID_EMG_CONTACT_NO);
        }if(CommonValidation.isValidUserName(employeeDTO.getEmpUserName())){
            validationList.add(CommonMsg.INVALID_USER_NAME);
        }if(CommonValidation.isValidPassword(employeeDTO.getEmpPassword())){
            validationList.add(CommonMsg.INVALID_PASSWORD);
        }
//  *******************************************INVALID-CHECKING****************************************************
        return validationList;
    }

    private List<String> existingEmployeeValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if employee exists
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the employee doesn't exist
        }

        // Further check on the status
        Employee existingEmployee = optionalEmployee.get();
        if (existingEmployee.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }



}
