package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.Invoice_ItemDTO;
import com.emaster.InventoryManagement.Service.Invoice_ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/Inventory_Item")
public class Invoice_ItemController {

    private Invoice_ItemService invoiceItemService;

    @Autowired
    public Invoice_ItemController(Invoice_ItemService invoiceItemService) {
        this.invoiceItemService=invoiceItemService;
    }

    @GetMapping("")
    public String InvoiceItemHome(){
        return "Welcome to Invoice Item Controller";
    }

    @PostMapping(path = "/saveInvoiceItems")
    public CommonResponse saveInvoiceItems(@RequestBody Invoice_ItemDTO invoiceItemDTO) {
        return invoiceItemService.saveInvoiceItems(invoiceItemDTO);
    }

    @PutMapping(path = "/updateInvoiceItems")
    public CommonResponse updateInvoiceItems(@RequestBody Invoice_ItemDTO invoiceItemDTO) {
        return invoiceItemService.updateInvoiceItems(invoiceItemDTO);
    }

    @DeleteMapping(path = "/deleteInvoiceItems/{itemId}")
    public CommonResponse deleteInvoiceItems(@PathVariable Long itemId) {
        return invoiceItemService.deleteInvoiceItems(itemId);
    }

//    @GetMapping(path="/getAllInvoiceItems")
//    public CommonResponse getAllInvoiceItems(){
//        return invoiceItemService.getAllInvoiceItems();
//    }

    @GetMapping(path="/getAllInvoiceItems/{invoiceId}")
    public CommonResponse getAllInvoiceItems(@PathVariable Long invoiceId){
        return invoiceItemService.getAllInvoiceItems(invoiceId);
    }

}
