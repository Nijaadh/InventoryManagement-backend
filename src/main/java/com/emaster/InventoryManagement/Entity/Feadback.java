package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Feadback {
    @Id
    @Column(name="feadback_id")
    private Long feadbackId;
    @Column(name="feadback_cusid")
    private Long cusId;
    @Column(name="feadback_discription")
    private String feadback;
    @Column(name="feadback_cs")
    private CommonStatus commonStatus;

    public Feadback() {
    }

    public Feadback(Long feadbackId, Long cusId, String feadback, CommonStatus commonStatus) {
        this.feadbackId = feadbackId;
        this.cusId = cusId;
        this.feadback = feadback;
        this.commonStatus = commonStatus;
    }

    public Long getFeadbackId() {
        return feadbackId;
    }

    public void setFeadbackId(Long feadbackId) {
        this.feadbackId = feadbackId;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getFeadback() {
        return feadback;
    }

    public void setFeadback(String feadback) {
        this.feadback = feadback;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "Feadback{" +
                "feadbackId=" + feadbackId +
                ", cusId=" + cusId +
                ", feadback='" + feadback + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
