package transaction;


/**
 * @author ouzair
 */
import housing.Property;
import housing.typeOfHousing;
import java.util.ArrayList;
import java.util.Scanner;

public class Auction extends Sale{

    private Scanner scanner;
    private ArrayList<Property> properties;
    
    private Property property;
   

    public Auction(ArrayList<Property> properties) {
        this.property = new Property();
        this.scanner = new Scanner(System.in);
        this.properties = properties;
         
    }
    
    public Auction(){
    super();
}
    

    public void startAuction() {
        // Display available properties
        displayAvailableProperties();

        // Get user input for property ID
        int propertyId = getPropertyIdFromUser();

        // Check if property exists and is up for auction
        Property property = findPropertyById(propertyId);
        if (property == null || !property.getisForauction()) {
            System.out.println("Invalid property ID or property not up for auction.");
            return;
        }

        // Conduct simple auction (single bid)
        double currentBid = property.getPrice();
        double userBid = getUserBid();
        if (userBid > currentBid) {
            System.out.println("Congratulations! You are the winning bidder.");
            // Update property state (optional)
        } else {
            System.out.println("Your bid was not high enough.");
        }
    }

    private void displayAvailableProperties() {
        System.out.println("Available properties for auction:");
        for (Property property : properties) {
            if (property.getisForauction()) {
                property.display(properties);
            }
        }
    }

    private int getPropertyIdFromUser() {
        System.out.println("Enter the ID of the property you want to bid on:");
        int propertyId = scanner.nextInt();
        return propertyId;
    }

    private Property findPropertyById(int propertyId) {
        for (Property property : properties) {
            if (property.getPropertyID() == propertyId) {
                return property;
            }
        }
        return null;
    }

    private double getUserBid() {
        System.out.println("Enter your bid amount:");
        double userBid = scanner.nextDouble();
        return userBid;
    }
}