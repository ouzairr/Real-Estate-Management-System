/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;
import java.util.*;

import individuals.Buyers;
/**
 *
 * @author Ouzair
 */
public abstract class Sale {
    protected SaleType saletype;
    protected Buyers buyer;
    protected Date Saledate;
    
    
    
    
    
    public SaleType getSaletype() {
        return saletype;
    }

    public Buyers getBuyer() {
        return buyer;
    }

    public Date getSaledate() {
        return Saledate;
    }

    public void setSaletype(SaleType saletype) {
        this.saletype = saletype;
    }

    public void setBuyer(Buyers buyer) {
        this.buyer = buyer;
    }

    public void setSaledate(Date Saledate) {
        this.Saledate = Saledate;
    }

    public Sale(SaleType saletype, Buyers buyer, Date Saledate) {
        this.saletype = saletype;
        this.buyer = buyer;
        this.Saledate = Saledate;
    }
    public Sale(){
        
    }
    
}
