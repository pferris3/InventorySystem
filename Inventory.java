package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Inventory {

    Scanner scan = new Scanner(System.in);

    ArrayList<Item> inventory = null;
    ArrayList<Item> weapons;
    ArrayList<Item> armor;

    Item equippedWeapon;
    Item equippedArmor;
    final int maxWeight;

    public Inventory () {
        inventory = new ArrayList<Item>();
        equippedWeapon = null;
        equippedArmor = null;
        maxWeight = 127;
    }

    public int totalWeight(){
        int invWeight = 0;

        for(int i = 0; i < inventory.size(); i++){
            invWeight += inventory.get(i).getItemWeight();
        }

        return invWeight;
    }

    public int mainMenu(){
        int commandNum;
        System.out.println("---------------------");
        System.out.println("1. Print inventory");
        System.out.println("2. Add random item");
        System.out.println("3. Drop item");
        System.out.println("4. Equip Weapon");
        System.out.println("5. Equip Armor");
        System.out.println("6. Exit");
        System.out.print("(Enter a command number): ");
        try {
            commandNum = scan.nextInt();
            return commandNum;
        } catch (InputMismatchException e) {
            System.out.println("Invalid entry!");
            return mainMenu();
        }
    }

    //print entire inventory
    public void print(){
        if (!inventory.isEmpty()){
            System.out.println("   Item");
            for(int i = 0; i < inventory.size(); i++){
                System.out.println((i+1) + ". " + inventory.get(i).getItemName());
            }
            System.out.println("Total weight: " + totalWeight());
            System.out.println();
        } else {
            System.out.println("Inventory is empty! Perhaps add an item!");
        }
    }

    //add an item if item not too heavy
    public void addItem(Item item) {
        Item temp = item;
        if ((item.getItemWeight() + totalWeight()) <= maxWeight) {
            inventory.add(item);
            System.out.println("You added " + item.getItemName() + " to your inventory.");
        } else {
            System.out.println("Item weight exceeds inventory limit!");
        }
    }

    //select and drop an item from inventory
    public void drop(){
        int itemDropIndex;
        Item tempItem;
        print();
        if (!inventory.isEmpty()) {
            System.out.print("Enter number to drop an item: ");
            itemDropIndex = scan.nextInt();
            tempItem = inventory.get(itemDropIndex-1);

            //check if item was equipped
            if (tempItem == equippedArmor) {
                equippedArmor = null;
            }
            if (tempItem == equippedWeapon){
                equippedWeapon = null;
            }

            System.out.println("You dropped " + tempItem.getItemName());
            inventory.remove(itemDropIndex-1);
            System.out.println();
        }
    }

    //select a weapon item to equip
    public void equipWeapon() {
        int weaponCount = 0;
        int weaponIndex;
        weapons = new ArrayList<>();
        int count = 1;

        //break if empty inventory
        if (inventory.isEmpty()){
            print();
            return;
        }

        //select weapons from inventory
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemType() == ItemType.WEAPON) {
                weapons.add(inventory.get(i));
                weaponCount++;
            }
        }

        //break if no available weapons
        if (weapons.isEmpty()) {
            System.out.println("No weapons available!");
            return;
        }

        System.out.println("Equip a Weapon");
        System.out.println(String.format("%3s %-15s %10s %10s %10s", "", "Item", "Weight", "Value", "Strength"));
        for (Item item : weapons) {
            System.out.println(String.format("%3d. %-15s %10d %10d %10d", count, item.getItemName(), item.getItemWeight(), item.getItemValue(), item.getItemStrength()));
            count++;
        }
        System.out.print("Enter the number of the item you wish to equip: ");
        weaponIndex = scan.nextInt() - 1;
        if(weaponIndex < weaponCount){
            equippedWeapon = weapons.get(weaponIndex);
            System.out.println("You equipped " + equippedWeapon.getItemName());
        } else{
            System.out.println("Invalid entry");
        }
    }


    //select an armor item to equip
    public void equipArmor(){
        int armorCount = 0;
        int armorIndex;
        armor = new ArrayList<>();
        int count = 1;

        //break if empty inventory
        if (inventory.isEmpty()){
            print();
            return;
        }

        //select armor from inventory
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getItemType() == ItemType.ARMOR){
                armor.add(inventory.get(i));
                armorCount++;
            }
        }

        //break if no available armor
        if (armor.isEmpty()) {
            System.out.println("No armor available!");
            return;
        }

        System.out.println("Equip Armor");
        System.out.println(String.format("%3s %-15s %10s %10s %10s", "", "Item", "Weight", "Value", "Strength"));
        for(Item item : armor){
            System.out.println(String.format("%3d. %-15s %10d %10d %10d", count, item.getItemName(), item.getItemWeight(), item.getItemValue(), item.getItemStrength()));
            count++;
        }
        System.out.print("Enter the number of the item you wish to equip: ");
        armorIndex = scan.nextInt() - 1;
        if(armorIndex<armorCount){
            equippedArmor = armor.get(armorIndex);
            System.out.println("You equipped " + equippedArmor.getItemName());
        } else{
            System.out.println("Invalid entry");
        }
    }
}
