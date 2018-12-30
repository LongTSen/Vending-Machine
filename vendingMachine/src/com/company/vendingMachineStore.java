//vendingMachineStore Class
package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class vendingMachineStore {
    ArrayList<vendingMachine> machine = new ArrayList<>();

    //add items to vending machine
    public void listItem() {
        machine.add(new vendingMachine("Coke", 1.99));
        machine.add(new vendingMachine("Sprite", 1.99));
        machine.add(new vendingMachine("Fanta", 1.99));
        machine.add(new vendingMachine("Water", 0.99));
        machine.add(new vendingMachine("Coffe Latte", 2.99));
        machine.add(new vendingMachine("Coffe Mocha", 2.99));
        machine.add(new vendingMachine("While Mocha", 2.99));
        machine.add(new vendingMachine("Coffe Mocha", 2.99));
        machine.add(new vendingMachine("Frappuccino", 2.99));
        machine.add(new vendingMachine("Caramel", 2.99));
        machine.add(new vendingMachine("Lay's Chip", 2.49));
        machine.add(new vendingMachine("Tostitos", 2.69));
        machine.add(new vendingMachine("Ruffles", 3.59));
        machine.add(new vendingMachine("Barbeque Potato", 3.99));
        machine.add(new vendingMachine("Sun Chip", 1.99));
        machine.add(new vendingMachine("Simply Ruffles", 3.29));
        machine.add(new vendingMachine("Blue Chip", 3.59));
        machine.add(new vendingMachine("Doritos", 2.99));
    }

    //**********************************************************************************************
    public void displayMenu()
    {
        System.out.printf("%-3s%20s%13s%17s%14s%18s%15s%17s\n", "Number", "Item Name", "Price","Item Left",
                "Number", "Item Name", "Price","Item Left");
        for (int i = 0; i < machine.size(); i++)
        {
            machine.get(i).setItemNumber(i+1);
            machine.get(i).display();
            if(i%2!=0)
            {
                System.out.printf("\n");
            }
        }
    }

    //*********************************************************************************************
    //Prompt user pick an item number
    public int getItemChoice()
    {
        validation validationInput = new validation();
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\nSelect a item you want to buy");
        choice = validationInput.integerInput();
        while(choice>machine.size()) {
            System.out.println("Invalid choice");
            System.out.println("Select a item you want to buy");
            choice = validationInput.integerInput();
        }
        return choice;
    }

    //**********************************************************************************************
    public double getBackChange(int itemNumber, double amount)
    {
        validation validationInput = new validation();
        double extraAmount,change;
        Scanner sc = new Scanner(System.in);
        while (amount < machine.get(itemNumber - 1).getPrice())
        {
            System.out.println("Not enough to buy, Please insert extra money");
            extraAmount = validationInput.doubleInput();
            amount += extraAmount;
        }
        change = amount - machine.get(itemNumber-1).getPrice();
        return change;
    }

    //**********************************************************************************************
    //Tracking item inventory
    public int trackNumberOfItem(int itemNumber)
    {
        if(machine.get(itemNumber-1).getNumOfItem()>0)
        {
            machine.get(itemNumber -1).itemsLeft();
        }
        return machine.get(itemNumber -1).getNumOfItem();
    }

    //**********************************************************************************************
    //Add new item
    public void addItem(String itemName, double itemPrice, int numOfItem)
    {
        machine.add(new vendingMachine(itemName,itemPrice,numOfItem));
        System.out.println("Added successful");
    }

    //**********************************************************************************************
    //Remove item by number
    public void removeByNumber(int itemNumber)
    {
        machine.remove(itemNumber-1);
        System.out.println("Removed successful");
    }

    //**********************************************************************************************
    //Remove item by name
    public void removeByName(String itemName) {
        int itemNumber = searchByName(itemName);
        if (itemNumber==-1)
        {
            System.out.println(itemName + " is not in vending machine");
        }
        else {
            removeByNumber(itemNumber);
        }
    }

    //**********************************************************************************************
    //Modify item name and price
    public void modifyItem(int itemNumber, String itemName, double itemPrice)
    {
        if (itemNumber>machine.size()||itemNumber<1){
            System.out.println("That item's number is out of index, can not modify");
        }
        else {
            machine.set(itemNumber - 1,new vendingMachine(itemNumber,itemName,itemPrice));
        }
    }

    //*********************************************************************************************
    //Search item by name
    public int searchByName(String itemName)
    {
        int result=-1;
        for(int i=0;i<machine.size();i++)
        {
            if(itemName.equalsIgnoreCase(machine.get(i).getItemName()))
            {
                result = machine.get(i).getItemNumber();
            }
        }
        return result;

    }

    //***********************************************************************************************
    //Day transaction report
    public void report()
    {
        double revenue, totalRevenue = 0;
        for (int i = 0; i < machine.size(); i++) {
            if (machine.get(i).getNumOfSold() > 0) {
                System.out.println("Sold " + (machine.get(i).getNumOfSold()) + " " + machine.get(i).getItemName());
                revenue = machine.get(i).getPrice() * (machine.get(i).getNumOfSold());
                totalRevenue += revenue;
            }
        }
        System.out.printf("Total Revenue of today by now is: $%4.2f\n" , totalRevenue);
    }
}
