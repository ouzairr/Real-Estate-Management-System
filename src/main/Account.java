package main;


import individuals.Buyers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import individuals.People;
import individuals.Managers;

public class  Account implements Serializable  {
	
	static private int NumberOfAccount;
	private int occupScan = 0;
	private String password;
	private int id;
	private String passScan;
	private int idScan;
	private boolean flagId = false, flagPass = false ;
	private Occupation occupation;
	private People person = new People();
	
	
	  
	 
	
	public  Account LogIn(ArrayList<Account> accounts){
		Account account = new Account();
		Scanner scan = new Scanner(System.in);  
			do {
				System.out.println("\n\t\t--------------------Log In--------------------\n");
				System.out.println("\t\tEnter The Following Information:\n\n");
				System.out.print("\t\tId:");
				idScan = scan.nextInt();
				scan.nextLine();
				System.out.print("\t\tPassword:");
				passScan = scan.nextLine();

	            for (Account a : accounts) {
	            	flagId = false; // Reset flags
		            flagPass = false;
	                if (a.getId() == idScan) {
	                    flagId = true;
	                    if (a.getPassword().equals(passScan)) {
	                        flagPass = true;
	                        account = a;
	                        break;
	                    } else {
	                        System.out.println("\t\tInvalid Password, Try Again!");
	                        break;
	                    }
	                }
		            
	            }

	            if (!flagId) {
	                System.out.println("\t\tInvalid Id Number, Try Again!");
	            }
	        } while (!flagId || !flagPass);

	        System.out.println("\t\tWelcome " + account.getPerson().getFN() + "\n");

		return account;
	}
	
	
	public  Account SignUp(){
            Account account = new Account();
		Scanner scan = new Scanner(System.in);  
		Account newAccount = new Account();
			System.out.println("\n\t\t--------------------Sign Up--------------------\n");
			System.out.println("\t\tEnter The Following Information:\n");
			System.out.print("\t\tFirst Name:");
		    newAccount.getPerson().setFN(scan.nextLine());
		    System.out.print("\t\tLast Name:");
		    newAccount.getPerson().setLN(scan.nextLine());
		    System.out.print("\t\tAge:");
		    newAccount.getPerson().setAge(scan.nextInt());
		    scan.nextLine();//to get the buffer
		    System.out.print("\t\tAre You a Male(M) or a Female(F):");
		    newAccount.getPerson().setSex(scan.next().charAt(0));
		    scan.nextLine();
		    do {

				    if(newAccount.getPerson().getAge() >= 18) {
					   	System.out.print("\t\tPlease choose what do you want to be?\n\t\t(1)Seller     (2)Renter     (3)Buyer ");
				    	System.out.print("Answer:");
				    	occupScan = scan.nextInt();
				    	scan.nextLine();
				    }
				    else {
				    	System.out.print("\t\tPlease choose what do you want to be?\n\t\t(1)Seller     (2)Renter");
					    System.out.print("Answer:");
					   	occupScan = scan.nextInt();
					   	scan.nextLine();
					   }
			    if(occupScan != 1 && occupScan != 2 && occupScan != 3) {
				    	System.out.println("\t\tInvalid Answer! Try Again!!");
				    	occupScan = 0;
		    	    }
		    	
		    }while(occupScan == 0 );
		    
		    if(occupScan == 1){
                        newAccount.setOccupation(Occupation.SELLER);
                    }
		    	
		    else if(occupScan == 2){
                        newAccount.setOccupation(Occupation.RENTER);
                    }
		    	
		    else {
		    	newAccount.setOccupation(Occupation.BUYER);
                           
                        
		    }
		    System.out.print("\t\tPassword:");
		    newAccount.setPassword(scan.nextLine());
		    Account.NumberOfAccount++;
		    newAccount.setId(Account.NumberOfAccount);
		    System.out.println("\t\tYour Id Number is: "+ newAccount.getId() + "\n");
		    writeWelcomeLetter(newAccount);
		    System.out.print("\t\t-Congrats! Your Account Has Been Created Succefully!-\n");
		    return newAccount;
		    }
		
	
	public void displayAccounts(ArrayList<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("/t/tThe list is empty.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

	public void sortAccounts(ArrayList<Account> accounts) {
        int n = accounts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareNames(accounts.get(j).getPerson().getFN(), accounts.get(j + 1).getPerson().getFN()) > 0) {
                    // Swap accounts[j+1] and accounts[j]
                    Account temp = accounts.get(j);
                    accounts.set(j, accounts.get(j + 1));
                    accounts.set(j + 1, temp);
                }
            }
        }
    }

    private int compareNames(String name1, String name2) {
        int length = Math.min(name1.length(), name2.length());
        for (int i = 0; i < length; i++) {
            char char1 = name1.charAt(i);
            char char2 = name2.charAt(i);
            if (char1 != char2) {
                return char1 - char2;
            }
        }
        return name1.length() - name2.length();
    }
    
    
    public void removeAccount(ArrayList<Account> accounts, int id) {
    	int index = id -1;
        if (index >= 0 && index < accounts.size()) {
            accounts.remove(index);
            System.out.println("\t\tAccount removed at index: " + index);
        } else {
            System.out.println("\t\tIndex out of bounds. No account removed.");
        }
    }


    public Account searchForAccount(ArrayList<Account> accounts, int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
            	account.toString();
                return account;
            }
        }
        System.out.println("\t\tUnfound Account!");
        return null; // Return null if no person with the given ID is found
    }

    
    
    public void writeWelcomeLetter(Account newAccount) {
        String fileName = "WelcomeLetter_" + newAccount.getId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String signUpDate = dateFormat.format(new Date()); // Assuming the sign-up date is the current date
            String occupation = newAccount.getOccupation().toString();
            
            writer.write("Date: " + signUpDate + "\n\n");
            writer.write("Dear " + newAccount.getPerson().getFN() + " " + newAccount.getPerson().getLN() + ",\n\n");
            writer.write("Welcome to our community!\n\n");
            writer.write("We are excited to have you on board as a " + occupation + ".\n");
            writer.write("We believe that you will be a valuable addition to our team and look forward to your contributions.\n\n");
            writer.write("Best regards,\n");
            writer.write("The Team  وكالة السعادة\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the welcome letter.");
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return "Account Details: \n" +
                "First Name: " + getPerson().getFN() + "\n" +
                "Last Name: " + getPerson().getLN() + "\n" +
                "Occupation: " + getOccupation() + "\n" +
                "Age: " + getPerson().getAge() + "\n" +
                "Gender: " + (getPerson().getSex() == 'M' ? "Male" : "Female");
    }


	public static int getNumberOfAccount() {
    	return NumberOfAccount;
    }
	

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
    public Occupation getOccupation() {
    	return occupation;
    }

    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public People getPerson() {
		return person;
	}


	public void setPerson(People person) {
		this.person = person;
	}





	

}
