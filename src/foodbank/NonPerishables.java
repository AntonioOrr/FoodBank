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
//NonPerishable objects
public class NonPerishables extends FoodItem{
    private String nonperishType = "";

    public NonPerishables(String s, String n) {
        super(s);
        nonperishType = n;
    }

    @Override
    public String getNonperishType() {
        return nonperishType;
    }

    public void setNonperishType(String nonperishType) {
        this.nonperishType = nonperishType;
    }
    
    @Override
    public void printItem(){
        System.out.println("Item: " + itemName + ", " + "Non-Perishable Type: " + nonperishType);
        System.out.println("Thank you for donating to the Food Bank!");
    }
    
   
}
