package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Catagery {
    @Id
    @Column(name="cat_id")
    private Long catId;
    @Column(name="cat_name")
    private String catName;
    @Column(name="cat_discription")
    private String catDiscription;
    @Column(name="cat_cs")
    private CommonStatus commonStatus;

    public Catagery() {
    }

    public Catagery(Long catId, String catName, String catDiscription, CommonStatus commonStatus) {
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
        return "Catagery{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catDiscription='" + catDiscription + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }

}
