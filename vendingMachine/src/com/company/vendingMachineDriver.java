//vendingMachineDriver Class
package com.company;
import java.util.Scanner;

public class vendingMachineDriver {

    public static void main(String[] args) {
    int choice;
    int selectionItem;
    double amount;
    int admin;
    int itemNumber;
    int trackNumOfItem;
    int removeBy;
    String password;
    String itemName;
    Double itemPrice;
    int numOfItem;
	vendingMachineStore store = new vendingMachineStore();
	validation validationInput = new validation();
	store.listItem();
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome to vending machine, Press:(-1 to quit) \n1 Enter to vending machine menu" +
            "\n2 Enter to administration");
	choice = validationInput.integerInput();
	do {
        switch (choice) {
                case 1:
                    store.displayMenu();
                    selectionItem = store.getItemChoice();
                    trackNumOfItem = store.trackNumberOfItem(selectionItem);
                        if (trackNumOfItem == 0) {
                            System.out.println("Sold Out, Please pick another one");
                        } else if (trackNumOfItem> 0) {
                            System.out.println("Insert Cash");
                            amount = validationInput.doubleInput();
                            System.out.printf("Thank you, your change is: $%4.2f\n", store.getBackChange(selectionItem, amount));
                        }
                    break;
                case 2: System.out.println("Enter Password to login:(admin) ");
                        password = sc.next();
                    if(password.equalsIgnoreCase("admin")) {
                        do {
                            System.out.println("\nPress:(-1 to quit back to menu)\n 1 to display menu\n 2 transactions report\n " +
                                    "3 to add new item\n 4 to modify item\n 5 to remove item");
                            admin = validationInput.integerInput();
                            switch (admin) {
                                case 1: store.displayMenu();
                                        break;

                                case 2: store.report();
                                        break;

                                case 3: sc.nextLine();
                                        System.out.println("What is the name of new item: ");
                                        itemName = sc.nextLine();
                                        System.out.println("What is the price of the new item: ");
                                        itemPrice = validationInput.doubleInput();
                                        System.out.println("How many the new item you want to add: ");
                                        numOfItem = validationInput.integerInput();
                                        store.addItem(itemName,itemPrice,numOfItem);
                                        break;

                                case 4: System.out.println("Which item number you want to modify: ");
                                        itemNumber = validationInput.integerInput();
                                        sc.nextLine();
                                        System.out.println("What is the name you want for that item: ");
                                        itemName = sc.nextLine();
                                        System.out.println("What is the price: ");
                                        itemPrice = validationInput.doubleInput();
                                        store.modifyItem(itemNumber, itemName, itemPrice);
                                        break;
                                case 5:
                                        store.displayMenu();
                                        System.out.println("\nPress 1 remove by number, 2 remove by name:");
                                        removeBy = validationInput.integerInput();
                                        if(removeBy==1){
                                            System.out.println("Which item's number you want to remove: ");
                                            itemNumber = validationInput.integerInput();
                                            store.removeByNumber(itemNumber);
                                        }
                                        else if(removeBy==2) {
                                            System.out.println("Which item's name you want to remove");
                                            itemName = sc.nextLine();
                                            store.removeByName(itemName);
                                        }
                                        else {
                                            System.out.println("Invalid choice");
                                        }
                                case -1: break;
                                default: System.out.println("Invalid selection ");
                            }
                        } while (admin != -1);
                    }
                    else
                    {
                        System.out.println("Password does not match!");
                    }
                    break;
                case -1:
                    break;

                default:
                    System.out.println("Invalid choice! ");
                    break;

        }
        System.out.println("Welcome to vending machine, Press:(-1 to quit) \n1 Enter to vending machine menu" +
                "\n2 Enter to administration");
        choice = validationInput.integerInput();
	}while (choice !=-1);
	System.out.println("GoodBye");
    }
}
