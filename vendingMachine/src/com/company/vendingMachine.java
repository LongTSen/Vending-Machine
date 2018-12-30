//vendingMachine Class
package com.company;

public class vendingMachine {
    private int itemNumber;
    private String itemName ;
    private int numOfItem;
    private double price;
    private int numOfSold=0;

    //Construction for adding primitive items
    public vendingMachine(String itemName,double price)
    {
        this.itemName = itemName;
        this.price = price;
        numOfItem = 10;
    }

    //Overload construction for adding new item and number of new item
    public vendingMachine(String itemName,double price, int numOfItem)
    {
        this.itemName = itemName;
        this.price = price;
        this.numOfItem = numOfItem;
    }

    //Overload construction for modify item
    public vendingMachine(int itemNumber,String itemName,double price)
    {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.price = price;
        numOfItem = 10;

    }

    public void setItemNumber(int itemNumber)
    {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber()
    {
        return itemNumber;
    }

    public String getItemName()
    {
        return itemName;
    }

    public double getPrice()
    {
        return price;
    }

    public int getNumOfItem()
    {
        return numOfItem;
    }

    public int getNumOfSold()
    {
        return numOfSold;
    }

    public void itemsLeft()
    {
        if (numOfItem>=0)
        {
            numOfItem--;
            numOfSold++;
        }
    }

    public void display()
    {
        System.out.printf("%3s%20s%15.2f%15s    |    ",itemNumber,itemName,price,numOfItem);

    }

}
