package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

public class FeadbackDTO {
    private Long feadbackId;
    private Long cusId;
    private String feadback;
    private CommonStatus commonStatus;

    public FeadbackDTO() {
    }

    public FeadbackDTO(Long feadbackId, Long cusId, String feadback, CommonStatus commonStatus) {
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
        return "FeadbackDTO{" +
                "feadbackId=" + feadbackId +
                ", cusId=" + cusId +
                ", feadback='" + feadback + '\'' +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
