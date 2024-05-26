package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

import java.sql.Date;

public class InvoiceDTO {
    private Long invoiceId;
    private Date invoiceDate;
    private double invoiceAmmount;
    private double invoicePaidAmmount;
    private double invoiceBalanceAmmount;
    private Long invoice_cusId;
    private CommonStatus commonStatus;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long invoiceId, Date invoiceDate, double invoiceAmmount, double invoicePaidAmmount, double invoiceBalanceAmmount, Long invoice_cusId, CommonStatus commonStatus) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceAmmount = invoiceAmmount;
        this.invoicePaidAmmount = invoicePaidAmmount;
        this.invoiceBalanceAmmount = invoiceBalanceAmmount;
        this.invoice_cusId = invoice_cusId;
        this.commonStatus = commonStatus;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoiceAmmount() {
        return invoiceAmmount;
    }

    public void setInvoiceAmmount(double invoiceAmmount) {
        this.invoiceAmmount = invoiceAmmount;
    }

    public double getInvoicePaidAmmount() {
        return invoicePaidAmmount;
    }

    public void setInvoicePaidAmmount(double invoicePaidAmmount) {
        this.invoicePaidAmmount = invoicePaidAmmount;
    }

    public double getInvoiceBalanceAmmount() {
        return invoiceBalanceAmmount;
    }

    public void setInvoiceBalanceAmmount(double invoiceBalanceAmmount) {
        this.invoiceBalanceAmmount = invoiceBalanceAmmount;
    }

    public Long getInvoice_cusId() {
        return invoice_cusId;
    }

    public void setInvoice_cusId(Long invoice_cusId) {
        this.invoice_cusId = invoice_cusId;
    }

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "invoiceId=" + invoiceId +
                ", invoiceDate=" + invoiceDate +
                ", invoiceAmmount=" + invoiceAmmount +
                ", invoicePaidAmmount=" + invoicePaidAmmount +
                ", invoiceBalanceAmmount=" + invoiceBalanceAmmount +
                ", invoice_cusId=" + invoice_cusId +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
