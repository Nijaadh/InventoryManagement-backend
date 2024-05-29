package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

import java.sql.Date;
import java.util.Arrays;

public class Invoice_ItemDTO {
    private Long invoiceId;
    private Long invoiceItems[];
    private CommonStatus commonStatus;

    public Invoice_ItemDTO() {
    }

    public Invoice_ItemDTO(Long invoiceId, Long[] invoiceItems, CommonStatus commonStatus) {
        this.invoiceId = invoiceId;
        this.invoiceItems = invoiceItems;
        this.commonStatus = commonStatus;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long[] getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Long[] invoiceItems) {
        this.invoiceItems = invoiceItems;
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
                ", invoiceItems=" + Arrays.toString(invoiceItems) +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
