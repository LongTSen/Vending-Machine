//validation Class
package com.company;
import java.util.Scanner;

public class validation {
    public int integerInput()
    {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number!");
            System.out.println("Enter an integer number again");
            sc.next();
        }
        int number = sc.nextInt();
        return number;
    }

    public double doubleInput()
    {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a number!");
            System.out.println("Enter a double number again");
            sc.next();
        }
        double number = sc.nextDouble();
        return number;
    }


}


