package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

public class CatageryDTO {
    private Long catId;
    private String catName;
    private String catDiscription;
    private CommonStatus commonStatus;

    public CatageryDTO() {
    }

    public CatageryDTO(Long catId, String catName, String catDiscription, CommonStatus commonStatus) {
        this.catId = catId;
        this.catName = catName;
        this.catDiscription = catDiscription;
        this.commonStatus = commonStatus;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDiscription() {
        return catDiscription;
    }

    public void setCatDiscription(String catDiscription) {
        this.catDiscription = catDiscription;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "CatageryDTO{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catDiscription='" + catDiscription + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
