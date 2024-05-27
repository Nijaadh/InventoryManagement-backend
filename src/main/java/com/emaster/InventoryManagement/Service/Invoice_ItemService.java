package com.emaster.InventoryManagement.Service;

import com.emaster.InventoryManagement.DTO.InvoiceDTO;
import com.emaster.InventoryManagement.DTO.Invoice_ItemDTO;
import com.emaster.InventoryManagement.Util.CommonResponse;

public interface Invoice_ItemService {
    CommonResponse saveInvoiceItems(Invoice_ItemDTO invoiceItemDTO);

    CommonResponse updateInvoiceItems(Invoice_ItemDTO invoiceItemDTO);

    CommonResponse deleteInvoiceItems(Long invoiceItemId);

    CommonResponse getAllInvoiceItems();

    CommonResponse getInvoiceItems(Long invoiceItemId);
}
