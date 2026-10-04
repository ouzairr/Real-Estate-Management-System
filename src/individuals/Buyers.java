package individuals;


/**
 * @author ilyas
 */
import housing.Property;
import main.Occupation;


public class Buyers extends People {
    
    
    public Buyers(String FN, String LN , int age, Occupation occupation, char sex){
        super(FN,LN ,  age,  occupation,  sex);
    }
    public Buyers(){
        super();
    }
    private Property propertyPurchased = new Property();


    
	public Property getPropertyPurchased() {
		return propertyPurchased;
	}

	public void setPropertyPurchased(Property propertyPurchased) {
		this.propertyPurchased = propertyPurchased;
	}
    
  
    
    

   
   
    
    
}
