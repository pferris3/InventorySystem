package com.company;

public class Item {

    private ItemType itemType;
    private String itemName;
    private int itemWeight;
    private int itemValue;
    private int itemStrength;

    public Item(ItemType itemType, String itemName, int itemWeight, int itemValue, int itemStrength) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemValue = itemValue;
        this.itemStrength = itemStrength;
    }

    //getters
    public ItemType getItemType(){
        return itemType;
    }

    public String getItemName(){
        return itemName;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public int getItemValue(){
        return itemValue;
    }

    public int getItemStrength() {
        return itemStrength;
    }
}
