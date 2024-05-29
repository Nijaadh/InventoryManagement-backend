package com.emaster.InventoryManagement.Service.ServiceIMPL;

import com.emaster.InventoryManagement.Const.CommonMsg;
import com.emaster.InventoryManagement.DTO.Invoice_ItemDTO;
import com.emaster.InventoryManagement.Entity.Invoice_Item;
import com.emaster.InventoryManagement.Repository.InvoiceRepository;
import com.emaster.InventoryManagement.Repository.Invoice_Item_Repository;
import com.emaster.InventoryManagement.Repository.ItemRepository;
import com.emaster.InventoryManagement.Service.Invoice_ItemService;
import com.emaster.InventoryManagement.Util.CommonResponse;
import com.emaster.InventoryManagement.Util.CommonValidation;
import com.emaster.InventoryManagement.Util.DtoToEntityCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
public class Invoice_ItemServiceIMPL implements Invoice_ItemService {

    private final Invoice_Item_Repository invoiceItemRepository;
    private final ItemRepository itemRepository;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public Invoice_ItemServiceIMPL(ItemRepository itemRepository, InvoiceRepository invoiceRepository, Invoice_Item_Repository invoiceItemRepository){
        this.invoiceItemRepository = invoiceItemRepository;
        this.itemRepository = itemRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public CommonResponse saveInvoiceItems(Invoice_ItemDTO invoiceItemDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<String> isValidItemsList;
        List<String> isValidInvoice;

        try {
            isValidItemsList = this.invoice_Item_Validation(invoiceItemDTO.getInvoiceItems());
            isValidInvoice = this.invoice_Validation(invoiceItemDTO.getInvoiceId());

            if (!isValidItemsList.isEmpty() || !isValidInvoice.isEmpty()) {
                commonResponse.setErrorMessages(isValidItemsList);
                commonResponse.setErrorMessages(isValidInvoice);
                commonResponse.setCommonMessage("Invoice items save failed.");
                return commonResponse;
            }

            // Save each item independently
            for (Long itemId : invoiceItemDTO.getInvoiceItems()) {
                Invoice_Item invoiceItem = DtoToEntityCast.cast_InvoiceItemsDto_Into_InvoiceItems(invoiceItemDTO);
                invoiceItem.setItemId(itemId);
                invoiceItemRepository.save(invoiceItem);
            }

            // Fetch all items for the given invoice ID and set them in the response DTO
           // Long[] itemIdsArray = getAllItems(invoiceItemDTO.getInvoiceId());

            List<Invoice_Item> invoice_items = invoiceItemRepository.findAllByInvoiceId(invoiceItemDTO.getInvoiceId());
            System.out.println(invoice_items);

            Invoice_ItemDTO invoiceItemResponseDTO = new Invoice_ItemDTO();
            invoiceItemResponseDTO.setInvoiceId(invoiceItemDTO.getInvoiceId());
            invoiceItemResponseDTO.setCommonStatus(invoiceItemDTO.getCommonStatus());
          //  invoiceItemResponseDTO.setInvoiceItems(itemIdsArray);

            commonResponse.setPayload(Collections.singletonList(invoiceItemResponseDTO));
            commonResponse.setCommonMessage("Invoice items saved successfully.");
            commonResponse.setStatus(true);

        } catch (Exception e) {
            LOGGER.error("Exception in Invoice_ItemService -> saveInvoiceItems!", e);
            commonResponse.setCommonMessage("An error occurred while saving invoice items.");
        }
        return commonResponse;
    }


    @Override
    public CommonResponse updateInvoiceItems(Invoice_ItemDTO invoiceItemDTO) {
        return null;
    }

    @Override
    public CommonResponse deleteInvoiceItems(Long invoiceItemId) {
        return null;
    }

    @Override
    public CommonResponse getAllInvoiceItems(Long invoiceId) {
        return null;
    }

    private List<String> invoice_Item_Validation(Long[] invoiceItems) {
        List<String> itemsValidationList = new ArrayList<>();

        for (Long invoiceItem : invoiceItems) {
            if (CommonValidation.iDNullValidation(invoiceItem)) {
                itemsValidationList.add(CommonMsg.EMPTY_ID);
            }
            if (CommonValidation.isValidId(invoiceItem)) { // Assuming isValidId should be negated to add error message
                itemsValidationList.add(CommonMsg.INVALID_ID); // Using INVALID_ID as the message for invalid ID
            }
        }

        return itemsValidationList;
    }

    private List<String> invoice_Validation(Long invoiceId) {
        List<String> invoiceValidationList = new ArrayList<>();

        if (CommonValidation.iDNullValidation(invoiceId)) {
            invoiceValidationList.add(CommonMsg.EMPTY_ID);
        }
        if (CommonValidation.isValidId(invoiceId)) { // Assuming isValidId should be negated to add error message
            invoiceValidationList.add(CommonMsg.INVALID_ID);
        }

        return invoiceValidationList;
    }

    public Long[] getAllItems(Long invoiceId) {
        List<Long> itemIds = new ArrayList<>();

//        try {
//            // Validate the invoice ID
//            List<String> validationList = this.invoice_Validation(invoiceId);
//            if (!validationList.isEmpty()) {
//                return new Long[0]; // Return an empty array if there are validation errors
//            }
//
//            // Fetch all Invoice_Item records for the given invoice ID
//            List<Invoice_Item> invoiceItems = invoiceItemRepository.findByInvoiceId(invoiceId);
//
//            // Extract item IDs and add them to the list
//            itemIds = invoiceItems.stream()
//                    .map(Invoice_Item::getItemId)
//                    .collect(Collectors.toList());
//
//        } catch (Exception e) {
//            LOGGER.error("Exception in Invoice_ItemService -> getAllItems!", e);
//        }

        return itemIds.toArray(new Long[0]);
    }


}
