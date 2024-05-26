package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table
public class Invoice {
    @Id
    @Column(name="invoice_id")
    private Long invoiceId;
    @Column(name="invoice_date")
    private Date invoiceDate;
    @Column(name="invoice_ammount")
    private double invoiceAmmount;
    @Column(name="invoice_paid_ammount")
    private double invoicePaidAmmount;
    @Column(name="invoice_balance_ammount")
    private double invoiceBalanceAmmount;
    @Column(name="invoice_cusid")
    private Long invoice_cusId;
    @Column(name="invoice_cs")
    private CommonStatus commonStatus;

    public Invoice() {
    }

    public Invoice(Long invoiceId, Date invoiceDate, double invoiceAmmount, double invoicePaidAmmount, double invoiceBalanceAmmount, Long invoice_cusId, CommonStatus commonStatus) {
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
        return "Invoice{" +
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
