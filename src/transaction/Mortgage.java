/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.util.Scanner;

/**
 *
 * @author Ouzair
 */
public class Mortgage extends Sale{
    private double principal; // The principal loan amount
    private double annualInterestRate; // Annual interest rate
    private int termYears; // Term in years

    public Mortgage(double principal, double annualInterestRate, int termYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.termYears = termYears;
    }
    public  Mortgage(){
    }

    public double calculateMonthlyPayment() {
        Scanner sos = new Scanner(System.in);
        System.out.println("enter the principal");
        double principal = sos.nextDouble();
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        long termMonths = termYears * 12;

        double monthlyPayment = (principal * monthlyInterestRate) / 
            (1 - Math.pow(1 + monthlyInterestRate, -termMonths));
        return monthlyPayment;
    }

    public void displayDetails() {
        System.out.println("Mortgage Details:");
        System.out.println("Principal Amount: $" + principal);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Term: " + termYears + " years");
        System.out.println("Monthly Payment: $" + String.format("%.2f", calculateMonthlyPayment()));
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }
    

}
