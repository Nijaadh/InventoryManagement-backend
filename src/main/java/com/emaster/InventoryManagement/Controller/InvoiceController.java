package com.emaster.InventoryManagement.Controller;

import com.emaster.InventoryManagement.DTO.InvoiceDTO;
import com.emaster.InventoryManagement.Service.InvoiceService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/invoiceManagement")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "")
    public String home() {
        return "Invoice management controller";
    }

    @PostMapping(path = "/saveInvoice")
    public CommonResponse saveInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.saveInvoice(invoiceDTO);
    }

    @PutMapping(path = "/updateInvoice")
    public CommonResponse updateInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.updateInvoice(invoiceDTO);
    }

    @DeleteMapping(path = "/deleteInvoice/{invoiceId}")
    public CommonResponse deleteInvoice(@PathVariable Long invoiceId) {
        return invoiceService.deleteInvoice(invoiceId);
    }

    @GetMapping(path = "/getAllInvoices")
    public CommonResponse getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping(path = "/getInvoice/{invoiceId}")
    public CommonResponse getInvoice(@PathVariable Long invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }
}
