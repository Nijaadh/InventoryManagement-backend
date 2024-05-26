package com.emaster.InventoryManagement.Entity;

import com.emaster.InventoryManagement.Const.CommonStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
    @Column(name="item_id")
    private Long itemId;
    @Column(name="item_name")
    private String itemName;
    @Column(name="item_discription")
    private String itemDiscription;
    @Column(name="item_qty")
    private int itemQty;
    @Column(name="item_reorder_level")
    private int item_reorderLevel;
    @Column(name="item_price")
    private double itemPrice;
    @Column(name="item_image")
    private String itemImage;
    @Column(name="item_catid")
    private Long itemCatId;
    @Column(name="item_comid")
    private Long itemComId;
    @Column(name="item_cs")
    private CommonStatus commonStatus;

    public Item() {
    }

    public Item(Long itemId, String itemName, String itemDiscription, int itemQty, int item_reorderLevel, double itemPrice, String itemImage, Long itemCatId, Long itemComId, CommonStatus commonStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDiscription = itemDiscription;
        this.itemQty = itemQty;
        this.item_reorderLevel = item_reorderLevel;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemCatId = itemCatId;
        this.itemComId = itemComId;
        this.commonStatus = commonStatus;
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

    public CommonStatus getCommonStatus() {
        return commonStatus;
    }

    public void setCommonStatus(CommonStatus commonStatus) {
        this.commonStatus = commonStatus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDiscription='" + itemDiscription + '\'' +
                ", itemQty=" + itemQty +
                ", item_reorderLevel=" + item_reorderLevel +
                ", itemPrice=" + itemPrice +
                ", itemImage='" + itemImage + '\'' +
                ", itemCatId=" + itemCatId +
                ", itemComId=" + itemComId +
                ", commonStatus=" + commonStatus +
                '}';
    }
}
