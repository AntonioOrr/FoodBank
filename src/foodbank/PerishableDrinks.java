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
//PerishableDrink objects
public class PerishableDrinks extends FoodItem{
    private int expirationDay = 1;
    private int gallons = 0;
    private boolean edibility = true;
    
    public PerishableDrinks(String s, int exp, int gall) {
        super(s);
        expirationDay = exp;
        gallons = gall;
        
    }
    @Override
    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }
    
    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }

    public boolean isEdibility() {
        return edibility;
    }

    public void setEdibility(int expDay, int dayPassed) {
        this.edibility = edibility;
    }
    @Override
    public int getAmount() {
        return gallons;
    }

    //expiration day goes down as each day passes
    @Override
    public void decrementDaysTillExp(){
        expirationDay--;
    }
    //simulateStoreActivity can now get boolean of perishable
    @Override
    public boolean getEdibility(){
        return edibility;
    }
    
    @Override
    public void isitExpired(int exp){
        if (exp <= 0)
        edibility = false;
    }
    
    @Override
    public void printItem(){
        System.out.println("Item: " + itemName + ", " + "Days Until Expiration: " + expirationDay +
                ", " + "Gallons: " + gallons);
    }
    
}

