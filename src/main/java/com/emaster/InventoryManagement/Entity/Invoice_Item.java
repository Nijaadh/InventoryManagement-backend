package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Invoice_Item {
    @Id
    @Column(name="init_invoice_id")
    private Long invoiceId;
    @Column(name="init_item_id")
    private Long itemId;
    @Column(name="init_cs")
    private CommonStatus commonStatus;

    public Invoice_Item() {
    }

    public Invoice_Item(Long invoiceId, Long itemId, CommonStatus commonStatus) {
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
        return "Invoice_Item{" +
                "invoiceId=" + invoiceId +
                ", itemId=" + itemId +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
