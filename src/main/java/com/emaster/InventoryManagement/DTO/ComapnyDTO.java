package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

public class ComapnyDTO {

    private Long comId ;
    private String comName;
    private String hotline;
    private String gmail;
    private String address;
    private CommonStatus commonStatus;

    public ComapnyDTO() {
    }

    public ComapnyDTO(Long comId, String comName, String hotline, String gmail, String address, CommonStatus commonStatus) {
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
        return "ComapnyDTO{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", hotline='" + hotline + '\'' +
                ", gmail='" + gmail + '\'' +
                ", address='" + address + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
