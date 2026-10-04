package housing;

import java.util.ArrayList;

public class Property {
      protected int propertyID;
      protected typeOfHousing propertyType;
      protected String address;
      protected double squareFootage;
      protected boolean isMaintained;
      protected boolean isRented;
      protected boolean isforsale;
      protected boolean isForauction;
   	  protected double price;
      
      public Property(int propertyID, typeOfHousing propertyType, String address, double squareFootage, boolean isMaintained, boolean isRented, boolean isforsale,boolean isForauction, double price) {
    	 this.propertyID = propertyID;
         this.propertyType = propertyType;
         this.address = address;
         this.squareFootage = squareFootage;
         this.isMaintained = isMaintained;
         this.isRented = isRented;
         this.isforsale = isforsale;
         this.price = price;
         this.isForauction = isForauction;
         
      }
      
      public Property(){
          
      }
      
      public void setPropertyID(int propertyID) {
    	  this.propertyID = propertyID;
      }
      
      public int getPropertyID() {
    	  return propertyID;
      }
      
      public void setPropertyType(typeOfHousing propertyType) {
    	  this.propertyType = propertyType;
      }
      
      
      public typeOfHousing getPropertyType() {
    	  return propertyType;
      }
      
      public void setAdress(String address) {
    	  this.address= address;
      }
      
      public String getAdress() {
    	  return address;
      }
      
      public void setSquareFootage(double squareFootage) {
    	  this.squareFootage= squareFootage;
      }
      
      
      public double getSquareFootage() {
    	  return squareFootage;
      }
      
      public void setIsMaintained(boolean isMaintained) {
    	  this.isMaintained= isMaintained;
      }
      
      public boolean getIsMaintained() {
    	  return isMaintained;
      }
      
      public void setIsRented(boolean isRented) {
    	  this.isRented= isRented;
      }
      
      public boolean getIsRented() {
    	  return isRented;
      }
      
      public void setIsforsale(boolean isforsale) {
    	  this.isforsale= isforsale;
      }
      
      public boolean getIsforsale() {
    	  return isforsale;
      }

  	  public void setForauction(boolean isForauction) {
  		this.isForauction = isForauction;
  	  }
      
  	  public boolean getisForauction() {
   		return isForauction;
   	  }
  	  
  	  public void setPrice(double price) {
   	  this.price= price;
      }
     
     
      public double getPrice() {
   	  return price;
      }
  	 
      
//   ArrayList<Property> arrproperty = new ArrayList<Property>();
   public void display (ArrayList<Property> arrproperty ) {
	   for (Property val : arrproperty ) {
		   System.out.println("PropertyID is: "+ val.propertyID);
		   System.out.println("propertyType is: "+ val.propertyType);
		   System.out.println("address is: "+ val.address);
		   System.out.println("squareFootage is: "+ val.squareFootage);
		   System.out.println("isMaintained is: "+ val.isMaintained);
		   System.out.println("isRented is: "+ val.isRented);
		   System.out.println("isforsale is: "+ val.isforsale);
		   System.out.println("isForauction is: "+ val.isForauction);
		   System.out.println("price is: "+ val.price);
                   System.out.println("-----------------");
	   }
   }
     
   
}