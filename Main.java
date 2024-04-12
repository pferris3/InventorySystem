package com.company;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        boolean cancel = false;
        int commandNum;


        while(!cancel){
        commandNum = inventory.mainMenu();

            switch (commandNum){
                case 1: inventory.print();
                    break;
                case 2: inventory.addItem(ItemGenerator.generate());
                    break;
                case 3: inventory.drop();
                    break;
                case 4: inventory.equipWeapon();
                    break;
                case 5: inventory.equipArmor();
                    break;
                case 6: cancel = true;
                    break;
            }
        }
    }
}
