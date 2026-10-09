package main;



import housing.Property;
import java.io.*;
import java.util.ArrayList;

import transaction.Rent;

public class Serialization {
	//Account Serialization
    public static void serializeAccounts(ArrayList<Account> accounts, String filepath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath))) {
            out.writeObject(accounts);
            System.out.println("Accounts have been serialized.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            throw e;
        }
    }

    public static ArrayList<Account> deserializeAccounts(String filepath) throws IOException, ClassNotFoundException {
        File file = new File(filepath);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath))) {
                return (ArrayList<Account>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error during deserialization: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("No data to load.");
            return new ArrayList<>();
        }
    }
    
    // properties serialization
    public static void serializeProperty(ArrayList<Property> Properties, String filepath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath))) {
            out.writeObject(Properties);
            System.out.println("Properties have been serialized.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            throw e;
        }
    }
    public static ArrayList<Property> deserializeProperty(String filepath) throws IOException, ClassNotFoundException {
        File file = new File(filepath);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath))) {
                return (ArrayList<Property>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error during deserialization: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("No data to load.");
            return new ArrayList<>();
        }
    }
    
    
    
 // Rentals serialization


    	    public static void serializeRentals(ArrayList<Rent> arrRentalShort, String filepath) throws IOException {
    	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath))) {
    	            out.writeObject(arrRentalShort);
    	            System.out.println("Rentals have been serialized.");
    	        } catch (IOException e) {
    	            System.out.println("Error during serialization: " + e.getMessage());
    	            throw e;
    	        }
    	    }

    	    public static ArrayList<Rent> deserializeRentals(String filepath) throws IOException, ClassNotFoundException {
    	    	File file = new File(filepath);
    	        if (file.exists() && file.length() > 0) {
    	            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath))) {
    	                return (ArrayList<Rent>) in.readObject();
    	            } catch (IOException | ClassNotFoundException e) {
    	                System.out.println("Error during deserialization: " + e.getMessage());
    	                throw e;
    	            }
    	        } else {
    	            System.out.println("No data to load.");
    	            return new ArrayList<>();

    	   }
    	}
    	
}
