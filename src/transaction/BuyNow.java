/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.util.*;

import housing.Property;
import housing.typeOfHousing;
import individuals.Buyers;

import java.io.*;



/**
 *
 * @author Ouzair
 */

@SuppressWarnings("unused")
public class BuyNow extends Sale {
   
    
	private double agreedPrice;
	
        public BuyNow(){
        super();
    }

    public void checkbuyer(Buyers b, ArrayList<Property> LP){
       Scanner sc = new Scanner (System.in);
       Property p = new Property (3,typeOfHousing.VILLA,"IFRAN",33.34,false, false, true,false , 20000.4);
       Property p1 = new Property (4,typeOfHousing.APPARTMENT,"CASA",50.4,true, false, true,false , 20000.4);
       LP.add(p);
       LP.add(p1);
            System.out.println("the properties available for sale are:");
            for(Property val : LP){
                if (val.getIsforsale()){
                    p.display(LP);
                System.out.println("---------------");
                }
                
            }
            try {
                System.out.println("choose the property that you are intressed in : (enter the property's ID)");
            int x = sc.nextInt();
            sc.close();
            for (int i = 0; i < LP.size(); i++){
                Property pr = LP.get(i);
                if (pr.getPropertyID() == x){
                	
                    System.out.println("congrats, you own your property successfully");
                }
                else{
                    System.out.println("wrong ID");
                }
            }
            }catch (InputMismatchException e){
                System.out.println(e.getMessage()); 
            }finally{
                sc.close();
            }
            
        
            
    }
            
    }

   
