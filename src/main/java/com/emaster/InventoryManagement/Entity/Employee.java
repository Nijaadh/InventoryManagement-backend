package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.*;


@Entity
@Table
public class Employee {
    @Id
    @Column(name="empId")

    private Long empId;
    @Column(name="empFName")
    private String empFName;
    @Column(name="empLName")
    private String empLstName;
    @Column(name="empNIC")
    private String empNIC;
    @Column(name="empGender")
    private String empGender;
    @Column(name="empDOB")
    private String empDOB;
    @Column(name="empEmail")
    private String empEmail;
    @Column(name="empAddress")
    private String empAddress;
    @Column(name="empContactNo")
    private String empContactNo;
    @Column(name="empEmgContactNo")
    private String empEmgContactNo;
    @Column(name="empUserName")
    private String empUserName;
    @Column(name="empPassword")
    private String empPassword;

    @Column(name="empImage")
    private String empImage;
    @Column(name="empCommonStatus")
    private CommonStatus commonStatus;
    @Column(name="empRoleId")
    private Long empRoleId;

    public Employee() {
    }

    public Employee(Long empId, String empFName, String empLstName, String empNIC, String empGender, String empDOB, String empEmail, String empAddress, String empContactNo, String empEmgContactNo, String empUserName, String empPassword, String empImage, CommonStatus commonStatus, Long empRoleId) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLstName = empLstName;
        this.empNIC = empNIC;
        this.empGender = empGender;
        this.empDOB = empDOB;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empContactNo = empContactNo;
        this.empEmgContactNo = empEmgContactNo;
        this.empUserName = empUserName;
        this.empPassword = empPassword;
        this.empImage = empImage;
        this.commonStatus = commonStatus;
        this.empRoleId = empRoleId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpLstName() {
        return empLstName;
    }

    public void setEmpLstName(String empLstName) {
        this.empLstName = empLstName;
    }

    public String getEmpNIC() {
        return empNIC;
    }

    public void setEmpNIC(String empNIC) {
        this.empNIC = empNIC;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(String empDOB) {
        this.empDOB = empDOB;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpContactNo() {
        return empContactNo;
    }

    public void setEmpContactNo(String empContactNo) {
        this.empContactNo = empContactNo;
    }

    public String getEmpEmgContactNo() {
        return empEmgContactNo;
    }

    public void setEmpEmgContactNo(String empEmgContactNo) {
        this.empEmgContactNo = empEmgContactNo;
    }

    public String getEmpUserName() {
        return empUserName;
    }

    public void setEmpUserName(String empUserName) {
        this.empUserName = empUserName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    public Long getEmpRoleId() {
        return empRoleId;
    }

    public void setEmpRoleId(Long empRoleId) {
        this.empRoleId = empRoleId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empFName='" + empFName + '\'' +
                ", empLstName='" + empLstName + '\'' +
                ", empNIC='" + empNIC + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empDOB='" + empDOB + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empContactNo='" + empContactNo + '\'' +
                ", empEmgContactNo='" + empEmgContactNo + '\'' +
                ", empUserName='" + empUserName + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", empImage='" + empImage + '\'' +
                ", commonStatus=" + commonStatus +
                ", empRoleId=" + empRoleId +
                '}';
    }
}
