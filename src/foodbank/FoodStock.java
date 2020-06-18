/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Antonio
 */
//collects all the items in store's inventory (determined by donations)
public class FoodStock extends Donors{
    private int milk;
    private int fruitJuice;
    private int meat;
    private int poultry;
    private int seafood;
    private int fruit;
    private int vegetables;
    private int nonPerishCan;
    private int nonPerishDry;
    private int nonPerishDehydr;
    private int nonPerishOther;

    public FoodStock(String a, int b, ArrayList<FoodItem> c) {
        super(a,b,c);
    }
    
    public int getMilk(PerishableDrinks m) {
        milk = m.getGallons();
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getFruitJuice(PerishableDrinks m) {
        fruitJuice = m.getGallons();
        return fruitJuice;
    }

    public void setFruitJuice(int fruitJuice) {
        this.fruitJuice = fruitJuice;
    }

    public int getMeat(Perishables m) {
        meat = m.getNumOflbs();
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public int getPoultry(Perishables m) {
        poultry = m.getNumOflbs();
        return poultry;
    }

    public void setPoultry(int poultry) {
        this.poultry = poultry;
    }

    public int getSeafood(Perishables m) {
        seafood = m.getNumOflbs();
        return seafood;
    }

    public void setSeafood(int seafood) {
        this.seafood = seafood;
    }

    public int getFruit(Perishables m) {
        fruit = m.getNumOflbs();
        return fruit;
    }

    public void setFruit(int fruit) {
        this.fruit = fruit;
    }

    public int getVegetables(Perishables m) {
        vegetables = m.getNumOflbs();
        return vegetables;
    }

    public void setVegetables(int vegetables) {
        this.vegetables = vegetables;
    }

    public int getNonPerishCan() {
        return nonPerishCan;
    }

    public void setNonPerishCan(int nonPerishCan) {
        this.nonPerishCan = nonPerishCan;
    }

    public int getNonPerishDry() {
        return nonPerishDry;
    }

    public void setNonPerishDry(int nonPerishDry) {
        this.nonPerishDry = nonPerishDry;
    }

    public int getNonPerishDehydr() {
        return nonPerishDehydr;
    }

    public void setNonPerishDehydr(int nonPerishDehydr) {
        this.nonPerishDehydr = nonPerishDehydr;
    }

    public int getNonPerishOther() {
        return nonPerishOther;
    }

    public void setNonPerishOther(int nonPerishOther) {
        this.nonPerishOther = nonPerishOther;
    }
    
    //adds gallons of perishable drinks to stock
    public void getStockPerDrinks (FoodItem m, int type, int gallons){
        if (type == 1)
        milk = milk + gallons;
        if (type == 2)
        fruitJuice = fruitJuice + gallons;
    }
    
    //adds pounds of perishables to stock
    public void getStockPer (FoodItem m, int type, int pounds){
        if (type == 3)
        meat = meat + pounds;
        if (type == 4)
        poultry = poultry + pounds;
        if (type == 5)
        seafood = seafood + pounds;
        if (type == 6)
        fruit = fruit + pounds;
        if (type == 7)
        vegetables = vegetables + pounds;
    }
        
     //adds a non-perishable item to stock
     public void addNonPerish(FoodItem e, int nonperish){
        if (nonperish == 1){
            nonPerishCan = nonPerishCan + 1;
        }
        else if (nonperish == 2){
            nonPerishDry = nonPerishDry + 1;
        }
        else if (nonperish == 3){
            nonPerishDehydr = nonPerishDehydr + 1;
        }
        else if (nonperish != 1 && nonperish != 2 && nonperish != 3){
            nonPerishOther = nonPerishOther + 1;
        }
    }
     //removes food item from stock
     public void deductStock(String a, int b, String c){
         if (a.equalsIgnoreCase("Milk"))
             milk = milk - b;
         else if (a.equalsIgnoreCase("Fruit Juice"))
             fruitJuice = fruitJuice - b;
         else if (a.equalsIgnoreCase("Meat"))
             meat = meat - b;
         else if (a.equalsIgnoreCase("Poultry"))
             poultry = poultry - b;
         else if (a.equalsIgnoreCase("Seafood"))
             seafood = seafood - b;
         else if (a.equalsIgnoreCase("Fruit"))
             fruit = fruit - b;
         else if (a.equalsIgnoreCase("Vegetables"))
             vegetables = vegetables - b;
         else{
             if (c.equalsIgnoreCase("Canned"))
                 nonPerishCan = nonPerishCan - 1;
             else if (c.equalsIgnoreCase("Dried"))
                 nonPerishDry = nonPerishDry - 1;
             else if (c.equalsIgnoreCase("Dehydrated"))
                 nonPerishDehydr = nonPerishDehydr - 1;
             else if (c.equalsIgnoreCase("Other"))
                 nonPerishOther = nonPerishOther - 1;
         }
     }
    
     //method that determines the removal of items from inventory
     public void simulateStoreActivity(){
        int num = (int)(Math.random()*100);
        int ex;
        boolean news = false;
        String nonperish;
        FoodItem mer;
        //itterates through every donation
        for (int i = 0; i < donations.size(); i++){
        mer = donations.get(i);
        nonperish = mer.getNonperishType();
        // 50% chance of item being sold
        if (num > 49){
          news = true;
          System.out.println("An item just got sold!");
            mer.printItem();
            System.out.println("Some " + mer.getItemName() + " will be deducted from inventory.");
            donations.remove(i);
            deductStock(mer.getItemName(), mer.getAmount(), nonperish);
        }}
        //iterates through every donation
        for (int i = 0; i < donations.size(); i++){
        //as the day ends, amount of days before expiration goes down
        mer = donations.get(i);
        mer.decrementDaysTillExp();
        nonperish = mer.getNonperishType();
        ex = mer.getExpirationDay();
        mer.isitExpired(ex);
        //removes item if not edible
        if (mer.getEdibility() == false){
            news = true;
            System.out.println("A perishable item has gotten spoiled!");
            mer.printItem();
            System.out.println(mer.getAmount() + " gallons/pounds of " + mer.getItemName() + " will be deducted from inventory.");
            donations.remove(i);
            deductStock(mer.getItemName(), mer.getAmount(), nonperish);
        }}
        //if items are not sold/spoiled
        if (!news)
            System.out.println("Currently no changes to our stock.");
        System.out.println("(Press Enter to continue)");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        
}
     //prints all the items in inventory
     public void printStock(){
         System.out.println("FOOD BANK STOCK");
         System.out.println("Milk: " + milk + " gallons");
         System.out.println("Fruit Juice: " + fruitJuice + " gallons");
         System.out.println("Meat: " + meat + " pounds");
         System.out.println("Poultry: " + poultry + " pounds");
         System.out.println("Seafood: " + seafood + " pounds");
         System.out.println("Fruit: " + fruit + " pounds");
         System.out.println("Vegetables: " + vegetables + " pounds");
         System.out.println("Amount of Canned Goods: " + nonPerishCan);
         System.out.println("Amount of Dried Goods: " + nonPerishDry);
         System.out.println("Amount of Dehydrated Goods: " + nonPerishDehydr);
         System.out.println("Amount of Other Goods: " + nonPerishOther);
         
     }
    
  
}
