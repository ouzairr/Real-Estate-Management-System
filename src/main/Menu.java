package main;


/**
 * @author saad
 */
import housing.Property;
import housing.typeOfHousing;
import individuals.Buyers;
import individuals.Comment;
import individuals.Managers;

import java.util.ArrayList;
import java.util.Scanner;
import individuals.People;
import individuals.Sellers;
import main.Account;
import transaction.Auction;
import transaction.BuyNow;
import transaction.Mortgage;
import transaction.Rent;

public class Menu {
	
	public int ManagerCheckMenu(ArrayList<Property> property,ArrayList<Account> accounts) {
            /**
 * @author ilyas
 */
                Account account = new Account();
                Account account1 = new Account();
                Managers manager = new Managers();
		int choice = 0;
                int a;
                boolean value = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\t\tAre You a Manager or a Client:\n");
		do {
			System.out.println("\n\t\t(1)Client          (2)Manager           (3)Quit\n");
			choice = scan.nextInt();
			if(choice == 1 )  {
				return choice;
			}else if (choice == 2){
                            
                            
do {
                             System.out.println("\n\t\t(1)Display Accounts          (2)Remove Accounts        (3)Hire a housekeeper           (4)maintain a Property          \n");
                            int sc = scan.nextInt();
                            char sort;

				if(sc == 1) {
					//DisplayST();
                                        account.displayAccounts(accounts);
					
						System.out.println("\n\t\t(1)search by Id           (2)sort by alphabetic order \n");
						  a = scan.nextInt();
					
					if(a == 1) {
                                            System.out.println("enter the account's ID");
                                            int id = scan.nextInt();
						account.searchForAccount(accounts,id);
					}else if(a == 2){
                                            account.sortAccounts(accounts);
                                        }
					

				}
				else if(choice == 2) {
                                    System.out.println("enter the Id of the Property that you want to remove: ");
                                    int remove = scan.nextInt();
                                    
                                    //remove 
                                    account.removeAccount(accounts,remove);
				}
                                else if(choice == 3) {
                                    value= true;
                                    manager.HireHouseKeepers(value);
				}
                                else if(choice == 4) {
                                    if (manager.HireHouseKeepers(value)== false){
                                        System.out.println("you need to hire a housekeeper first.");
                                    }else{
                                        System.out.println("enter the property ID ");
                                        int id = scan.nextInt();
                                        for (Property val : property){
                                            if (val.getPropertyID()== id){
                                                manager.Maintain(val);
                                            }
                                        }
                                        
                                    }
				}
					
				else {
					System.out.println("\n\t\tInvalid Input! Try Again!!\n");
				}
				}while(choice != 1 && choice != 2 && choice != 3 && choice != 4 );
                        }
			
			else if(choice != 3) {
				System.out.println("\n\t\tINVALID CHOICE!\n");
				System.out.println("\n\t\tTRY AGAIN!!\n");
				}
		}
		while(choice != 1 && choice != 2 && choice != 3);
		return -1;
	}
	
	
	
	
	
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
	
	public Account GeneralMenu(ArrayList<Account> accounts) {
            
		Account account = new Account();
		System.out.println("\n\t\tPlease Enter Your Choice:\n");
      
		int choice = 0, occupation;
		Scanner scan = new Scanner(System.in);
			do {
			
				System.out.println("\n\t\t--------------------مرحبا بكم في وكالة السعادة--------------------\n");
				System.out.println("\n\t\tPlease Enter Your Choice:\n");
				System.out.println("\n\t\t1-Log In:            2-Sign Up:            3-Quit:\n");
				choice = scan.nextInt();
				
				switch(choice){
				case 1:
						account = account.LogIn(accounts);
						choice = 3;
						break;
					case 2:
						Account newAccount = account.SignUp();
					    accounts.add(newAccount);
						break;
					case 3: 
						return null;
					default:
						System.out.println("\n\t\tINVALID CHOICE!\n");
						System.out.println("\n\t\tTRY AGAIN!!\n");
		
				}
			}while(choice != 3);
			
		return account;
	}
	
	
	
	public int OccupationMenu(Account account,ArrayList<Property> properties) {
        BuyNow buynow = new BuyNow();
        Auction auction = new Auction(properties);
        Mortgage mortgage = new Mortgage();
		Scanner scan = new Scanner(System.in); 
		int choice = 0;
		char sort = ' ';
		int sortOption = 0;
		int id = 0;
		boolean isRented = false;
		switch(account.getOccupation()) { 
		case SELLER:
			do {
				System.out.println("\n\t\tHow do you wanna Sell:\n"); 
				System.out.println("\n\t\t(1)Sell Now            (2)Buy Auction            (3)Mortgage            (4)Quit\n"); 
				choice =scan.nextInt(); 
				scan.nextLine();
	                        Sellers seller = new Sellers();
	                        if(choice == 1) {
	                            properties = seller.sell(properties);
	                        } 
				else if(choice == 2) {
	                            auction.startAuction();
	                        }
                                else if(choice == 3){
                                    
                                    mortgage.calculateMonthlyPayment();
                                    mortgage.displayDetails();
                                      //mortage
                                }
				else if (choice == 4){
					return -1;
				}
            }while(choice != 1 && choice != 2 && choice != 3);
			break; 
		case RENTER:
			
			Rent newRent = new Rent();

			do {
				System.out.println("\n\t\tWhat Do You Wanna Rent:\n"); 
				System.out.println("\n\t\t(1)Short Term Rental            (2)Long Term Rental  \n");
				choice = scan.nextInt(); 
				scan.nextLine();
				if(choice == 1) {
					Object arrRentalShort = null;
					//DisplayST();
					display1 (arrRentalShort);
					do {
						System.out.println("\n\t\tDo You Want To Sort Them by Price?(Y/N)\n");
						sort = scan.next().charAt(0);
					}while(sort != 'Y');
					if(sort == 'Y') {
						do {
                                                    /**
 * @author maroua
 */
							System.out.println("\n\t\t(1)Low To High            (2)High To Low \n");
							sortOption = scan.nextInt();
							if(sortOption == 1) {
								//sort Low To High
								sortShortTermRentsByPriceAscending();
							}
							else if(sortOption == 2) {
								//sort High To Low
								sortShortTermRentsByPriceDescending();
							}
							else {
								System.out.println("\n\t\tInvalid Input! Try Again!!\n");
							}
						}while(choice != 1 && choice != 2);
					}
					
					do {
						System.out.println("\n\t\t(1)Continue          (2)Quit\n"); 
						choice = scan.nextInt();
						if(choice == 1) {
							System.out.println("\n\t\tEnter The Property Id:\n"); 
							id = scan.nextInt();
							isRented = newRent.rent(id, properties);
						}
						else if(choice == 2) {
							return -1;
						}
						else {
							System.out.println("\n\t\tInvalid Input! Try Again!!\n");
						}
						
					}while(choice != 1 && choice != 2 );
				}
				else if(choice == 2) {
					Object arrRentalLong = null;
					//DisplayLT();
					display2 (arrRentalLong);
					do {
						System.out.println("Do You Want To Sort Them by Price?(Y/N)");
						sort = scan.next().charAt(0);
					}while(sort != 'Y');
					if(sort == 'Y') {
						do {
							System.out.println("\n\t\t(1)Low To High            (2)High To Low \n");
							sortOption = scan.nextInt();
							if(sortOption == 1) {
								//sort Low To High
								sortLongTermRentsByPriceAscending();
							}
							else if(sortOption == 2) {
								//sort High To Low
								sortLongTermRentsByPriceDescending();
							}
							else {
								System.out.println("\n\t\tInvalid Input! Try Again!!\n");
							}
						}while(choice != 1 && choice != 2);
                                        }
				else{
					System.out.println("\n\t\tInvalid Input! Try Again!!\n");
				}
}
				}while(choice != 1 && choice != 2 );
                                
			
			break; 

		case BUYER:
			do {
				System.out.println("\n\t\tHow do you wanna buy:\n"); 
				System.out.println("\n\t\t(1)Buy Now            (2)Buy Auction            (3)Quit\n"); 
				choice = scan.nextInt(); 
				scan.nextLine(); 
	                        Buyers buyer = new Buyers();
				if(choice == 1) {
	                            /**
	                         * author @ilyas
	                         */
	                            
	                         account.setPerson(buyer);
	                            if (account.getPerson() instanceof Buyers) {
	                           buynow.checkbuyer((Buyers) account.getPerson(), properties);
	                               } else {
	    
	                           System.out.println("The person is not a buyer.");
	                            }
	                        }
	                        //BuyNowFunction 
				else if(choice == 2) {
	                            auction.startAuction();
	                            
	                            
	                        }
				//BuyAuction Function
				else if(choice == 3) {
					return -1;
				}
				else {
					System.out.println("\n\t\tInvalid Input! Try Again!!\n");
				}
			}while(choice != 1 && choice != 2 && choice != 3);
			break;
	
		}

		return choice;
}

        private void sortShortTermRentsByPriceDescending() {
		
	}
	private void sortShortTermRentsByPriceAscending() {
		
	}
	private void sortLongTermRentsByPriceAscending() {
				
	}
	private void sortLongTermRentsByPriceDescending() {
				
	}
	private void display2(Object arrRentalLong) {
				
	}
	private void display1(Object arrRentalShort) {
				
	}
	
	public void CommentMenu(){
            /**
 * @author ilyas
 */
		Scanner scan = new Scanner(System.in);
		ArrayList<Comment> replies = new ArrayList<Comment>();
		char sort;
		System.out.println("\n\t\tDo You Want To Rate Experience?(Y/N)\n");
		sort = scan.next().charAt(0);
		if(sort == 'Y') {
			System.out.println("\n\t\twrite a comment: ");
			String text = scan.nextLine();
			scan.nextLine();
			Comment comment = new Comment(text);
			System.out.println("\n\t\t(1)Like      (2)dislike ");
			int liking = scan.nextInt();
			scan.nextLine();
			if (liking == 1) {
				comment.like();
			}
			else if (liking == 2) {
				comment.dislike();
			}
			else {
				System.out.println("\n\t\tinvalid input");
			}
			comment.addComment(comment, replies);
			System.out.println("\n\t\tdo you want to add a reply:(Y/N)\n");
			char sort2 = scan.next().charAt(0);
			if(sort2 == 'Y') {
				System.out.println("\n\t\twrite a reply: ");
				String text1 = scan.nextLine();
				scan.nextLine();
				Comment comment1 = new Comment(text1);
				System.out.println("\n\t\t(1)Like      (2)dislike ");
				int liking1 = scan.nextInt();
				scan.nextLine();
				if (liking1 == 1) {
					comment1.like();
				}
				else if (liking1 == 2) {
					comment1.dislike();
				}
				else {
					System.out.println("\n\t\t invalid input");
				}
				comment1.addComment(comment1, replies);
			}else if (sort2 == 'N'){
				System.out.println("\n\t\tThank you for your feedback");
			}
			else {
				System.out.println("\n\t\tinvalid input");
			}
			
			}
		else if (sort == 2) {
			System.out.println("\n\t\t Give our agency a rating form 1-5");
			int rating = scan.nextInt();
			scan.nextLine();
			Comment c = new Comment();
			c.addRating(rating);
			
		}
			
	}
}
	  
	
