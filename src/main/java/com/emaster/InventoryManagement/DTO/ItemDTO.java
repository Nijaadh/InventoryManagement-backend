package com.emaster.InventoryManagement.DTO;

import com.emaster.InventoryManagement.Const.CommonStatus;

public class ItemDTO {
    private Long itemId;
    private String itemName;
    private String itemDiscription;
    private int itemQty;
    private int item_reorderLevel;
    private double itemPrice;
    private String itemImage;
    private Long itemCatId;
    private Long itemComId;
    private CommonStatus itemCommonStatus;

    public ItemDTO() {
    }

    public ItemDTO(Long itemId, String itemName, String itemDiscription, int itemQty, int item_reorderLevel, double itemPrice, String itemImage, Long itemCatId, Long itemComId, CommonStatus itemCommonStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDiscription = itemDiscription;
        this.itemQty = itemQty;
        this.item_reorderLevel = item_reorderLevel;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemCatId = itemCatId;
        this.itemComId = itemComId;
        this.itemCommonStatus = itemCommonStatus;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDiscription() {
        return itemDiscription;
    }

    public void setItemDiscription(String itemDiscription) {
        this.itemDiscription = itemDiscription;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public int getItem_reorderLevel() {
        return item_reorderLevel;
    }

    public void setItem_reorderLevel(int item_reorderLevel) {
        this.item_reorderLevel = item_reorderLevel;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public Long getItemComId() {
        return itemComId;
    }

    public void setItemComId(Long itemComId) {
        this.itemComId = itemComId;
    }

    public CommonStatus getItemCommonStatus() {
        return itemCommonStatus;
    }

    public void setItemCommonStatus(CommonStatus itemCommonStatus) {
        this.itemCommonStatus = itemCommonStatus;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDiscription='" + itemDiscription + '\'' +
                ", itemQty=" + itemQty +
                ", item_reorderLevel=" + item_reorderLevel +
                ", itemPrice=" + itemPrice +
                ", itemImage='" + itemImage + '\'' +
                ", itemCatId=" + itemCatId +
                ", itemComId=" + itemComId +
                ", itemCommonStatus=" + itemCommonStatus +
                '}';
    }
}
