/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author Ouzair
 */
public class Payment implements Serializable{
    private int CardNumber;
    private String Expirationdate;
    protected boolean isvalidated;
        ArrayList<Payment>  payment = new ArrayList<Payment>();

    
    public Payment(){
    	
    }
    
    public Payment(int CardNumber, String Expirationdate,boolean isvalidated) {
        this.CardNumber = CardNumber;
        this.Expirationdate = Expirationdate;
        this.isvalidated = isvalidated;
    }
    public void addPayment(Payment p) {
    payment.add(p);
}
    public void removePayment(int index) {
    payment.remove(index);

}
 public static Comparator<Payment> ExpirationDateComparator = new Comparator<Payment>() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        
    public int compare(Payment p1, Payment p2) {
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = sdf.parse(p1.getExpirationdate());
                date2 = sdf.parse(p2.getExpirationdate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.compareTo(date2);
        }
    };

    public boolean proceedpayment(){
        Scanner check = new Scanner(System.in);
        System.out.println("enter your card number:");
        int CardNumber = check.nextInt();
        System.out.println("enter the date of expiration:");
        int Expirationdate = check.nextInt();
         isvalidated = true;
        return isvalidated;
            
        }

    @Override
    public String toString() {
        return "Payment{" + "CardNumber=" + CardNumber + ", Expirationdate=" + Expirationdate + ", isvalidated=" + isvalidated + '}';
    }

    private String getExpirationdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
