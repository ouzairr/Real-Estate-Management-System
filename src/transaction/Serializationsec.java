/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author Ouzair
 */
public class Serializationsec {
     public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
         //Serialization
        ArrayList<Payment> p = new ArrayList<Payment>();
         FileOutputStream f = new FileOutputStream("payment.ser");
        ObjectOutputStream out = new ObjectOutputStream(f);
      out.writeObject(p);
      out.close();
      f.close();
         //deserializatrion
        FileInputStream fIn = new FileInputStream("payment.ser");
        ObjectInputStream oIn = new ObjectInputStream(fIn);
        ArrayList<Payment> var = (ArrayList<Payment>) oIn.readObject();
        oIn.close();
        fIn.close();
        
        for (Payment val : var){
            System.out.println(val);
        }
        
     }
    
}


