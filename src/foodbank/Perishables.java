/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbank;

/**
 *
 * @author Antonio
 */
//Perishable objects
public class Perishables extends FoodItem{
    private int expirationDay = 1;
    private int numOflbs = 1;
    private boolean edibility = true;
    
//parameters for Perishables object

public Perishables (String s, int expiration, int lbs){
super(s);
expirationDay = expiration;
numOflbs = lbs;
}

    @Override
    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }

    public int getNumOflbs() {
        return numOflbs;
    }

    public void setNumOflbs(int numOflbs) {
        this.numOflbs = numOflbs;
    }

    public boolean isEdibility() {
        return edibility;
    }

    public void setEdibility() {
        
        this.edibility = edibility;
    }
    @Override
    public int getAmount() {
        return numOflbs;
    }

    
    @Override
    public boolean getEdibility(){
        return edibility;
    }
    
    @Override
    public void decrementDaysTillExp(){
        expirationDay--;
    }
    @Override
    public void isitExpired(int exp){
        if (exp <= 0)
        edibility = false;
    }

    @Override
    public void printItem(){
        System.out.println("Item: " + itemName + ", " + "Days Until Expiration: " + expirationDay +
                ", " + "Pounds: " + numOflbs);
    }
    
}