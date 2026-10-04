package housing;

public class Appartment extends Property {

	private int numberofrooms;

    public Appartment(int numberofrooms, int propertyID, typeOfHousing propertyType, String address, double squareFootage, boolean isMaintained, boolean isRented, boolean isforsale, boolean isForauction, double price) {
        super(propertyID, propertyType, address, squareFootage, isMaintained, isRented, isforsale, isForauction, price);
        this.numberofrooms = numberofrooms;
    }

    public Appartment(int numberofrooms) {
        this.numberofrooms = numberofrooms;
    }
	
	
	public void setNumberofrooms(int numberofrooms) {
		this.numberofrooms = numberofrooms;
	}
	
	public int getNumberofrooms() {
		return numberofrooms;
	}
	
	
}
