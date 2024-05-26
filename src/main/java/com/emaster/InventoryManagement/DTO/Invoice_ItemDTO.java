package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

import java.sql.Date;

public class Invoice_ItemDTO {
    private Long invoiceId;
    private Long itemId;
    private CommonStatus commonStatus;

    public Invoice_ItemDTO() {
    }

    public Invoice_ItemDTO(Long invoiceId, Long itemId, CommonStatus commonStatus) {
        this.invoiceId = invoiceId;
        this.itemId = itemId;
        this.commonStatus = commonStatus;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "Invoice_ItemDTO{" +
                "invoiceId=" + invoiceId +
                ", itemId=" + itemId +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
