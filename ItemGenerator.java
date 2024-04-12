package com.company;
import java.util.*;

public class ItemGenerator {

    //generate a random item
    public static Item generate(){

        // generate random parameters
        Random rand = new Random();
        int randInt = rand.nextInt(4);

        ItemType randomType = ItemType.MISC;
        String randomName = "";
        int randomWeight = 0;
        int randomValue = 0;
        int randomStrength = 0;

        //rand.nextInt for randomType
        if(randInt == 0){
            randomType = ItemType.WEAPON;
        }

        if(randInt == 1){
            randomType = ItemType.ARMOR;
        }

        //create array of random objects for different types
        String[] weaponItems = new String[5];
        weaponItems[0] = "Steel Longsword";
        weaponItems[1] = "Rusty Dagger";
        weaponItems[2] = "Hatchet";
        weaponItems[3] = "Spiked Bat";
        weaponItems[4] = "Lead Pipe";

        String[] armorItems = new String[5];
        armorItems[0] = "Breastplate";
        armorItems[1] = "Old Helmet";
        armorItems[2] = "Shield";
        armorItems[3] = "Chainmail Suit";
        armorItems[4] = "Plated Vest";

        String[] miscItems = new String[5];
        miscItems[0] = "Piñata";
        miscItems[1] = "CD";
        miscItems[2] = "Baseball Cap";
        miscItems[3] = "Stick of Gum";
        miscItems[4] = "Plastic Cup";


        //assign other values based on item type
        if(randomType==ItemType.WEAPON){
            randomName = weaponItems[rand.nextInt(weaponItems.length)];
            randomWeight = rand.nextInt(11, 22);
            randomStrength = rand.nextInt(5, 16);
            randomValue = randomStrength + rand.nextInt(1,4);
        } else if(randomType==ItemType.ARMOR){
            randomName = armorItems[rand.nextInt(armorItems.length)];
            randomWeight = rand.nextInt(14, 29);
            randomStrength = rand.nextInt(7, 15);
            randomValue = randomStrength + rand.nextInt(1,4);
        } else if(randomType==ItemType.MISC){
            randomName = miscItems[rand.nextInt(miscItems.length)];
            randomWeight = rand.nextInt(1, 4);
            randomValue = rand.nextInt(0,3);
            randomStrength = 0;
        }

        //constructor
        Item newItem = new Item(randomType, randomName, randomWeight, randomValue, randomStrength);

        return newItem;
    }


}
