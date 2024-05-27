package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.InvoiceDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface InvoiceService {
    CommonResponse saveInvoice(InvoiceDTO invoiceDTO);

    CommonResponse updateInvoice(InvoiceDTO invoiceDTO);

    CommonResponse deleteInvoice(Long invoiceId);

    CommonResponse getAllInvoices();

    CommonResponse getInvoice(Long invoiceId);
}
