package transaction;

import java.io.Serializable;
import java.util.*;
import transaction.RentalType;
import individuals.Renters;
import housing.Property;


public class Rent implements Serializable {
	
	   protected boolean isRented = false;
       private RentalType rentaltype;
       private Date startdate;
       private Date enddate;
       private Renters renter;
       private double pricerent;
       private static int numberofshorttermrentals;
       private static int numberoflongtermrentals;
       
       public Rent (RentalType rentaltype, Date startdate, Date enddate, Renters renter, double pricerent) {
    	   this.rentaltype = rentaltype;
    	   this.startdate = startdate;
    	   this.enddate = enddate;
    	   this.renter = renter;
    	   this.pricerent = pricerent;
       }
       
       public Rent() {
    	   
       }
       public void setRetaltype(RentalType rentaltype) {
    	   this.rentaltype = rentaltype;
       }
       
       public RentalType getRentaltype() {
    	   return rentaltype;
       }
      
       public void setStartdate(Date startdate) {
    	   this.startdate = startdate;
       }
       
       public Date getStartdate() {
    	   return startdate;
       }
       
       public void setEnddate(Date enddate) {
    	   this.enddate = enddate;
       }
       
       public Date getEnddate() {
    	   return enddate;
       }
       
       public void setRenter(Renters renter) {
    	   this.renter = renter;
       }
       
       public Renters getRenter() {
        	return renter;
       }
       
       public void setPricerent(double pricerent) {
    	   this.pricerent = pricerent;
       }
       
       public double getPricerent() {
    	   return pricerent;
       }
        
       
       
    	      ArrayList<Rent> arrRentalShort = new ArrayList<Rent>();
              public void display1 (ArrayList<Rent> arrRentalShort ) {
        	   for (Rent value : arrRentalShort ) {
        		   System.out.println("startdate is: "+ value.startdate);
        		   System.out.println("enddate is: "+ value.enddate);
        		   System.out.println("renter is: "+ value.renter);
        		   System.out.println("priceday is: "+ value.pricerent);
        		   
        	   }
           }
       
      
       
              ArrayList<Rent> arrRentalLong = new ArrayList<Rent>();
              public void display2 (ArrayList<Rent> arrRentalLong ) {
    	      for (Rent value : arrRentalLong ) {
    		       System.out.println("startdate is: "+ value.startdate);
    		       System.out.println("enddate is: "+ value.enddate);
    		       System.out.println("renter is: "+ value.renter);
    		       System.out.println("pricemonth is: "+ value.pricerent);
    		   
    	       }
           }


		public boolean rent(int Id, ArrayList<Property> properties){
			boolean flag = false;
			for(Property p : properties) {
				if(p.getPropertyID() == Id) {
					flag = true;
					
				}
		        if(flag == true) {
		        	p.setIsRented(true);
		            return flag;
				}
		                        
		    }
		    
			return flag;
	

		}
		

	    public void sortShortTermRentsByPriceDescending() {
	        Collections.sort(arrRentalShort, new RentComparatorDescending());
	    }

	    public void sortShortTermRentsByPriceAscending() {
	        Collections.sort(arrRentalShort, new RentComparatorAscending());
	    }

	    public Rent searchShortTermRent(Date startDate, Date endDate, Renters renter) {
	        for (Rent rent : arrRentalShort) {
	            if (rent.getStartdate().equals(startDate) &&
	                    rent.getEnddate().equals(endDate) &&
	                    rent.getRenter().equals(renter)) {
	                return rent;
	            }
	        }
	        return null;
	    }


	    public void sortLongTermRentsByPriceDescending() {
	        Collections.sort(arrRentalLong, new RentComparatorDescending());
	    }

	    public void sortLongTermRentsByPriceAscending() {
	        Collections.sort(arrRentalLong, new RentComparatorAscending());
	    }

	    public Rent searchLongTermRent(Date startDate, Date endDate, Renters renter) {
	        for (Rent rent : arrRentalLong) {
	            if (rent.getStartdate().equals(startDate) &&
	                    rent.getEnddate().equals(endDate) &&
	                    rent.getRenter().equals(renter)) {
	                return rent;
	            }
	        }
	        return null;
	    }

	    private static class RentComparatorDescending implements Comparator<Rent> {
	        @Override
	        public int compare(Rent rent1, Rent rent2) {
	            return Double.compare(rent2.getPricerent(), rent1.getPricerent());
	        }
	    }

	    private static class RentComparatorAscending implements Comparator<Rent> {
	        
			public int compare(Rent o1, Rent o2) {
				
				return 0;
			}}
	}