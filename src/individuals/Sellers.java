package individuals;

/**
 * @author ilyas
 */
import housing.Property;
import housing.typeOfHousing;
import java.util.ArrayList;
import java.util.Scanner;

public class Sellers extends People {
    
    public Sellers(){
        super();
    }
    
    public ArrayList<Property>  sell (ArrayList<Property> properties){
       typeOfHousing t = null;
       boolean m = false ,s= false,a= false,r= false;
        
        
        Scanner scan = new Scanner (System.in);
        System.out.println("\n\t\tenter the your property's details:");
        System.out.println("\n\t\tenter a custom ID for your Property:");
        int id = scan.nextInt();
        System.out.println("\n\t\twhat is the type of your property:\n"); 
	System.out.println("\n\t\t(1)STUDIO            (2)VILLA            (3)APPARTMENT            (4)COMMERCIAL\n");
        int type = scan.nextInt();
        scan.nextLine();
        System.out.println("\n\t\tenter the address where your property is located:");
        String location = scan.nextLine();
        System.out.println("\n\t\tenter the squarefootage of your Property:");
        double sqf = scan.nextDouble();
        scan.nextLine();
        System.out.println("\n\t\tis it maintained ?(1 for yes & 0 for no):");
        int maintained = scan.nextInt();
        scan.nextLine();
        System.out.println("\n\t\tare you going to list it for rent?(1 for yes & 0 for no) :");
        int rent = scan.nextInt();
        scan.nextLine();
        System.out.println("\n\t\tare you going to list it for sale?(1 for yes & 0 for no) :");
        int sale = scan.nextInt();
        scan.nextLine();
        System.out.println("\n\t\tare you going to list it for auction?(1 for yes & 0 for no) :");
        int auction = scan.nextInt();
        scan.nextLine();
        System.out.println("\n\t\tenter its price");
        double price =scan.nextDouble();
        scan.nextLine();
        
        if (type == 1){
             t = typeOfHousing.STUDIO;
        }else if (type == 2){
             t = typeOfHousing.VILLA;
        }else if (type == 3){
             t = typeOfHousing.APPARTMENT;
        }else if (type == 4){
             t = typeOfHousing.COMMERCIAL;
        }else{
            System.out.println("invalid input");
        }
        
         if (maintained == 1){
            m = true;
        }else if (rent == 0){
             m = false;
        }else{
            System.out.println("invalid input");
        }
        
        if (rent == 1){
            r = true;
        }else if (rent == 0){
             r = false;
        }else{
            System.out.println("invalid input");
        }
        
        if (sale == 1){
            s = true;
        }else if (rent == 0){
             s = false;
        }else{
            System.out.println("invalid input");
        }
        
        if (auction == 1){
            a = true;
        }else if (rent == 0){
             a = false;
        }else{
            System.out.println("invalid input");
        }
        
        Property property = new Property(id, t,location, sqf,m,r,s,a,price);
        properties.add(property);
        return properties;
        
    }
    
    
     

}
