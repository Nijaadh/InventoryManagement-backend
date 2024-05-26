package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table
public class Customer {
    @Id
    @Column(name="cus_id")
    private Long cusId;
    @Column(name="cus_fname")
    private String cusFName;
    @Column(name="cus_lname")
    private String cusLName;
    @Column(name="cus_nic")
    private String cusNIC;
    @Column(name="cus_gender")
    private String cusGender;
    @Column(name="cus_gmail")
    private String cusGmail;
    @Column(name="cus_dob")
    private Date cusDOB;
    @Column(name="cus_contact_no")
    private String cusContactNo;
    @Column(name="cus_address")
    private String cusAddress;

    @Column(name="cus_username")
    private String cusUserName;
    @Column(name="cus_password")
    private String cusPassword;
    @Column(name="cus_cs")
    private CommonStatus commonStatus;

    public Customer() {
    }

    public Customer(Long cusId, String cusFName, String cusLName, String cusNIC, String cusGender, String cusGmail, Date cusDOB, String cusContactNo, String cusAddress, String cusUserName, String cusPassword, CommonStatus commonStatus) {
        this.cusId = cusId;
        this.cusFName = cusFName;
        this.cusLName = cusLName;
        this.cusNIC = cusNIC;
        this.cusGender = cusGender;
        this.cusGmail = cusGmail;
        this.cusDOB = cusDOB;
        this.cusContactNo = cusContactNo;
        this.cusAddress = cusAddress;
        this.cusUserName = cusUserName;
        this.cusPassword = cusPassword;
        this.commonStatus = commonStatus;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getCusFName() {
        return cusFName;
    }

    public void setCusFName(String cusFName) {
        this.cusFName = cusFName;
    }

    public String getCusLName() {
        return cusLName;
    }

    public void setCusLName(String cusLName) {
        this.cusLName = cusLName;
    }

    public String getCusNIC() {
        return cusNIC;
    }

    public void setCusNIC(String cusNIC) {
        this.cusNIC = cusNIC;
    }

    public String getCusGender() {
        return cusGender;
    }

    public void setCusGender(String cusGender) {
        this.cusGender = cusGender;
    }

    public String getCusGmail() {
        return cusGmail;
    }

    public void setCusGmail(String cusGmail) {
        this.cusGmail = cusGmail;
    }

    public Date getCusDOB() {
        return cusDOB;
    }

    public void setCusDOB(Date cusDOB) {
        this.cusDOB = cusDOB;
    }

    public String getCusContactNo() {
        return cusContactNo;
    }

    public void setCusContactNo(String cusContactNo) {
        this.cusContactNo = cusContactNo;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusUserName() {
        return cusUserName;
    }

    public void setCusUserName(String cusUserName) {
        this.cusUserName = cusUserName;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusFName='" + cusFName + '\'' +
                ", cusLName='" + cusLName + '\'' +
                ", cusNIC='" + cusNIC + '\'' +
                ", cusGender='" + cusGender + '\'' +
                ", cusGmail='" + cusGmail + '\'' +
                ", cusDOB=" + cusDOB +
                ", cusContactNo='" + cusContactNo + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusUserName='" + cusUserName + '\'' +
                ", cusPassword='" + cusPassword + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
