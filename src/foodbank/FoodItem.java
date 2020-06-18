package foodbank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
//objects that are food items
public class FoodItem {
    protected String itemName = "";

    public FoodItem(String s) {
        itemName = s;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    //the methods below will be overridden
    
    //returns the name of the non-perishable item
    public String getNonperishType(){
        return "";
    }
    
    //returns the amount of gallons/pounds of perishable items a user donates
    public int getAmount() {
        return 0;
    }
    
    //returns expiration day for perishable items
    public int getExpirationDay(){
        return 0;
    }
    
    //returns true or false of whether or not item hasnt passed its expiation date
    public boolean getEdibility(){
        return true;
    }
    
    //prints information of the item
    public void printItem(){
       
    }
    
    //decreases days before expiration by 1 (Non-perishables dont have an expiration date)
    public void decrementDaysTillExp(){
        
    }
    
    //determines if perishable item is still safe to eat
    public void isitExpired(int exp){
        
    }
    
}
