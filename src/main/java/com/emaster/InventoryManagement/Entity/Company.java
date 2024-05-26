package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Company {
    @Id
    @Column(name = "com_id")
    private Long comId ;

    @Column(name = "com_name")
    private String comName;

    @Column(name = "com_hotline")
    private String hotline;

    @Column(name = "com_gmail")
    private String gmail;

    @Column(name = "com_address")
    private String address;

    @Column(name = "com_cs")
    private CommonStatus commonStatus;

    public Company() {
    }

    public Company(Long comId, String comName, String hotline, String gmail, String address, CommonStatus commonStatus) {
        this.comId = comId;
        this.comName = comName;
        this.hotline = hotline;
        this.gmail = gmail;
        this.address = address;
        this.commonStatus = commonStatus;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", hotline='" + hotline + '\'' +
                ", gmail='" + gmail + '\'' +
                ", address='" + address + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }


}
