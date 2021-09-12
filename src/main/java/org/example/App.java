package org.example;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Andre Jara
 */

public class App 
{
    public static void main(String[] args)
    {
        String orderAmountInput = "";
        String state = "010";
        String county = "010";
        double orderAmount;
        double tax;
        double total;
        Scanner sc = new Scanner(System.in);

        while(!orderAmountInput.matches("[0123456789.]+"))
        {
            if(!orderAmountInput.matches("[0123456789.]+") && !orderAmountInput.equals(""))
            {
                System.out.println("You must enter a number.");
            }
            System.out.print("What is the order amount? ");
            orderAmountInput = sc.nextLine();
        }

        orderAmount = Double.parseDouble(orderAmountInput);

        while(!state.matches("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ]+"))
        {
            if(!state.matches("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ]+") && !state.equals("010"))
            {
                System.out.println("You must enter a state name.");
            }
            System.out.print("What state do you live in? ");
            state = sc.nextLine();
        }

        if(state.equals("Wisconsin"))
        {
            tax = 0.05;
            while(!county.matches("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ]+"))
            {
                if(!county.matches("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ]+") && !county.equals("010"))
                {
                    System.out.println("You must enter a county name.");
                }
                System.out.print("What county do you live in? ");
                county = sc.nextLine();
            }

            if(county.equals("Eau Claire"))
            {
                tax = tax + 0.005;
            }
            else if(county.equals("Dunn"))
            {
                tax = tax + 0.004;
            }

            total = orderAmount + (orderAmount * tax);
            System.out.printf("The tax is $%.2f.\n", (orderAmount * tax));
        }
        else if(state.equals("Illinois"))
        {
            tax = 0.08;
            total = orderAmount + (orderAmount * tax);
            System.out.printf("The tax is $%.2f.\n", (orderAmount * tax));
        }
        else
        {
            total = orderAmount;
        }
        System.out.printf("The total is $%.2f.\n", total);
    }
}
