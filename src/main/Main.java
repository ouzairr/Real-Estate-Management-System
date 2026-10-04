package main;
/**
 * @author saad
 */

import java.io.IOException;
import java.util.ArrayList;
import housing.Property;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Property> property = new ArrayList<>();
        Menu menu = new Menu();

        // Accounts Serialization
        try {
            accounts = Serialization.deserializeAccounts("accounts.ser");
            property = Serialization.deserializeProperty("properties.ser");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            // Handle the error or exit if necessary
        }

        if (menu.ManagerCheckMenu(property,accounts) == 1) {
            Account account = menu.GeneralMenu(accounts);

            if (account != null) {
                int choice = menu.OccupationMenu(account, property);
                menu.CommentMenu();
                
            } else {
                System.out.println("\n\t\tExiting the program..");
                // Serialization
                try {
                    Serialization.serializeAccounts(accounts, "accounts.ser");
                } catch (IOException e) {
                    System.out.println("Error during serialization: " + e.getMessage());
                    // Handle the error or exit if necessary
                }
                try {
                    Serialization.serializeProperty(property, "properties.ser");
                } catch (IOException e) {
                    System.out.println("Error during serialization: " + e.getMessage());
                    
                }
                
                return;
            }
        }

        // Additional code if needed
        // ...

        // Serialization before exiting the program
        try {
            Serialization.serializeAccounts(accounts, "accounts.ser");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            // Handle the error or exit if necessary
        }
        try {
                    Serialization.serializeProperty(property, "properties.ser");
                } catch (IOException e) {
                    System.out.println("Error during serialization: " + e.getMessage());
                    
                }
    }
}