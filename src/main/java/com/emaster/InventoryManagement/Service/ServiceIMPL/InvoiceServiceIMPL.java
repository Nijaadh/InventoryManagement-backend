package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.Const.CommonStatus;
import com.emaster.InventoryManagement.DTO.InvoiceDTO;
import com.emaster.InventoryManagement.Entity.Invoice;
import com.emaster.InventoryManagement.Repository.InvoiceRepository;
import com.emaster.InventoryManagement.Service.InvoiceService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import com.emaster.InventoryManagement.Util.EntityToDtoCast;
import com.emaster.InventoryManagement.Util.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class InvoiceServiceIMPL implements InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceIMPL(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public CommonResponse saveInvoice(InvoiceDTO invoiceDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList;

        try {
            validationList = this.invoiceValidation(invoiceDTO);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Invoice save failed.");
                return commonResponse;
            }

            Invoice invoice = DtoToEntityCast.castInvoiceDtoIntoInvoice(invoiceDTO);
            invoice = invoiceRepository.save(invoice);
            commonResponse.setPayload(Collections.singletonList(invoice));
            commonResponse.setCommonMessage("Invoice saved successfully.");
            commonResponse.setStatus(true);

        } catch (Exception e) {
            LOGGER.error("Exception in Invoice Service -> saveInvoice!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse updateInvoice(InvoiceDTO invoiceDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.invoiceValidation(invoiceDTO);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Invoice update failed.");
                return commonResponse;
            }

            Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceDTO.getInvoiceId());
            if (optionalInvoice.isPresent()) {
                Invoice updatedInvoice = DtoToEntityCast.castInvoiceDtoIntoInvoice(invoiceDTO);
                invoiceRepository.save(updatedInvoice);
                commonResponse.setPayload(Collections.singletonList(updatedInvoice));
                commonResponse.setCommonMessage("Invoice updated successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Invoice not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Invoice Service -> updateInvoice!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse deleteInvoice(Long invoiceId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = this.existingInvoiceValidation(invoiceId);

        try {
            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Invoice deletion failed.");
                return commonResponse;
            }

            Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
            if (optionalInvoice.isPresent()) {
                Invoice invoice = optionalInvoice.get();
                invoice.setCommonStatus(CommonStatus.DELETE);
                invoiceRepository.save(invoice);
                commonResponse.setPayload(Collections.singletonList(invoice));
                commonResponse.setCommonMessage("Invoice deleted successfully.");
                commonResponse.setStatus(true);
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Invoice Service -> deleteInvoice!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getAllInvoices() {
        CommonResponse commonResponse = new CommonResponse();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();

        try {
            Predicate<Invoice> filterOnStatus = invoice -> invoice.getCommonStatus() != CommonStatus.DELETE;
            invoiceDTOList = invoiceRepository.findAll()
                    .stream()
                    .filter(filterOnStatus)
                    .map(EntityToDtoCast::castInvoiceIntoInvoiceDto)
                    .collect(Collectors.toList());

            if (invoiceDTOList.isEmpty()) {
                commonResponse.setCommonMessage("Invoice list is empty.");
                return commonResponse;
            }

            commonResponse.setPayload(Collections.singletonList(invoiceDTOList));
            commonResponse.setCommonMessage("Invoice list retrieved successfully.");
            commonResponse.setStatus(true);
        } catch (Exception e) {
            LOGGER.error("Exception in Invoice Service -> getAllInvoices!", e);
        }
        return commonResponse;
    }

    @Override
    public CommonResponse getInvoice(Long invoiceId) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> validationList = new ArrayList<>();
        Invoice existingInvoice;

        try {
            validationList = this.existingInvoiceValidation(invoiceId);

            if (!validationList.isEmpty()) {
                commonResponse.setErrorMessages(validationList);
                commonResponse.setCommonMessage("Get invoice failed.");
                return commonResponse;
            }

            existingInvoice = invoiceRepository.findById(invoiceId).orElse(null);
            if (existingInvoice != null) {
                commonResponse.setPayload(Collections.singletonList(existingInvoice));
                commonResponse.setCommonMessage("Invoice retrieved successfully.");
                commonResponse.setStatus(true);
            } else {
                commonResponse.setCommonMessage("Invoice not found.");
            }
        } catch (Exception e) {
            LOGGER.error("Exception in Invoice Service -> getInvoice!", e);
        }
        return commonResponse;
    }

    public List<String> invoiceValidation(InvoiceDTO invoiceDTO) {
        ArrayList<String> validationList = new ArrayList<>();

        // Add your validation logic here

        return validationList;
    }

    private List<String> existingInvoiceValidation(Long id) {
        List<String> validationList = new ArrayList<>();

        // Validate ID
        if (id == null || id <= 0) {
            validationList.add(CommonMsg.INVALID_ID);
            return validationList; // Return early since the ID is invalid
        }

        // Check if invoice exists
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        if (!optionalInvoice.isPresent()) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
            return validationList; // Return early since the invoice doesn't exist
        }

        // Further check on the status
        Invoice existingInvoice = optionalInvoice.get();
        if (existingInvoice.getCommonStatus() == CommonStatus.DELETE) {
            validationList.add(CommonMsg.NOT_EXISTING_ID);
        }

        return validationList;
    }
}
