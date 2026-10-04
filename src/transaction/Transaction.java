/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;
import individuals.People;
import individuals.Renters;

import java.util.ArrayList;
import java.util.Date;

import individuals.Buyers;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Ouzair
 */
public class Transaction implements Serializable{ 
    private int TransactionId;
    private int HousingId;
    private TransactionType transactiontype;
    private Status status;
    private double FinalPrice;
    private People person;
    private String starttime = StartTime();
    private boolean iscompleted;
    private boolean iscancelled;
    ArrayList<Payment>  payment = new ArrayList<Payment>();
    
  
   
    public void typeClient(){
        if (this.transactiontype == TransactionType.Rent){
            Renters client = new Renters();//main arguments
        }
        else {
            Buyers client = new Buyers();// main arguments
        }
    }
    
    
    
    public static String StartTime() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Format the date and time for readability
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        
        // Return the formatted date and time
        return formattedDateTime;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public int getTransactionId() {
        return TransactionId;
    }

    public int getHousingId() {
        return HousingId;
    }

    public TransactionType getTransactiontype() {
        return transactiontype;
    }

    public Status getStatus() {
        return status;
    }

    public double getFinalPrice() {
        return FinalPrice;
    }

    public People getRental() {
        return person;
    }

    public String getStarttime() {
        return starttime;
    }

    public boolean isIscancelled() {
        return iscancelled;
    }
    
    

    public Transaction(int TransactionId, int HousingId, TransactionType transactiontype, Status status, double FinalPrice,People p,  String starttime, boolean iscompleted, boolean iscancelled) {
        this.TransactionId = TransactionId;
        this.HousingId = HousingId;
        this.transactiontype = transactiontype;
        this.status = status;
        this.FinalPrice = FinalPrice;
        this.person = person;
        this.starttime = starttime;
        this.iscompleted = iscompleted;
        this.iscancelled = iscancelled;
    }
    //Default Construction;
    public Transaction(){
        
    }
   
    public boolean getiscompleted(){
        return iscompleted;
    }
    
   
    
    
    public void StartTransaction(){
        this.starttime = new String();
        System.out.println("Transaction started at:"+ starttime);
    }
    public void completeTransaction(){
        if(!iscancelled){
        this.iscompleted = true;
         System.out.println("Do you want to finish your payment:");
          boolean proceedsuccess ;
          Payment pay = new Payment();
          proceedsuccess = pay.proceedpayment();
        if(proceedsuccess){
        status = Status.Completed; 

        }
     else{
      status = Status.Cancelled; 
      }
        
}
} 
    public void UpdateStatus(){
        if(status == Status.Cancelled){
            status = Status.Completed;
        }
        else
            status = Status.Cancelled;
    }
    }

