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
//accounts that are donors
public class Donors extends UserAccount{
    private int contribution = 0;
    private String prizeEarned = "none";
    protected ArrayList<FoodItem> donations = new ArrayList();
    
    //prizes are earned depending on how many items they donate
    public Donors(String n, int a, ArrayList<FoodItem> donate) {
        super(n, a);
                int counter = 0;
        for (int i = 0; i < donate.size(); i++){
            counter++;
        }
        contribution = counter;
        if (contribution == 1 && contribution < 5)
        prizeEarned = "none";
        else if (contribution >= 5 && contribution < 10)
        prizeEarned = "sticker";
        else if (contribution >= 10 && contribution <15)
        prizeEarned = "sticker" + ", key chain";
        else if (contribution >= 15 && contribution < 20)
        prizeEarned = "sticker, key chain" + ", lunchbox";
        else if (contribution >= 20)
        prizeEarned = "sticker, key chain, lunchbox" + ", $20 Walmart Giftcard";
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public String getPrizeEarned() {
        return prizeEarned;
    }

    public void setPrizeEarned(String prizeEarned) {
        this.prizeEarned = prizeEarned;
    }

    public ArrayList<FoodItem> getDonations() {
        return donations;
    }

    public void setDonations(ArrayList<FoodItem> donat) {
        donations = donat;
    }
    
    @Override
    public void print(){
        System.out.println("Username: " + name + ", " + "Age: " + age + ", " + "# of Donated Items: "
        + contribution);
        System.out.println("Prize(s) Earned: " + prizeEarned);
        System.out.println("Thank you for your donation (if donated)! We give out rewards for up to 20 items.");
    }
    
    @Override
    public void printAccount(){
        System.out.println("Welcome back " + name + ", " + "aged " + age + "!");
        System.out.println("Status: Donor, " + "# of Donated Items: " + contribution +
                ", Prize(s) Earned: " + prizeEarned);
        System.out.println("NOTE: Prizes cannot be re-earned");
    }
    
     @Override
    public void printChange(){
        System.out.println(name + ", in change settings you can only change your account name and age. "
                + "You cannot take back prizes or already-donated items!");
        System.out.println("However, you can choose to add another donation.");
    }
    
    @Override
    public void changeUp(FoodStock e){
        Scanner sc = new Scanner(System.in);
        System.out.println("Change name? (Y/N)");
        String change = sc.next();
        if (change.equalsIgnoreCase("Y")){
            System.out.println("Type new UserName: ");
            String newName = sc.next();
            name = newName;
        }
        System.out.println("Change age? (Y/N)");
        change = sc.next();
        if (change.equalsIgnoreCase("Y")){
            boolean criteria = false;
            int newAge = 0;
            while (!criteria){
            System.out.println("Type new age: ");
            newAge = sc.nextInt();
            if (newAge>=18){
            age = newAge;
            criteria = true;
            }
            else
            System.out.println("Age must be at least 18!");
            }
        }
        System.out.println("Add donation? (Y/N)");
        change = sc.next();
       if (change.equalsIgnoreCase("Y")){
           boolean addItems = true;
           int counter = 0;
                while (addItems){
                
                System.out.println("What type of item do you wish to donate?");
                System.out.println("'1' = Perishable, '2' = NonPerishable");
                int type = sc.nextInt();
                if (type == 1){
                    System.out.println("Please select an item number from our Perishables list:");
                    System.out.println("'1' = Milk, '2' = Fruit Juice, '3' = Meat, '4' = Poultry,"
                            + "'5' = Seafood, '6' = Fruit, '7' = Vegetables");
                    int perish = sc.nextInt();
                    if (perish == 1){
                    System.out.println("How many gallons of milk are you donating?");
                    int gallons = sc.nextInt();
                    //milk expires in around 10 days
                    PerishableDrinks item = new PerishableDrinks("Milk", 10, gallons);
                    item.printItem();
                    donations.add(item);
                    e.getStockPerDrinks(item, perish, gallons);
                    e.setDonations(donations);
                    }
                    else if (perish == 2){
                    System.out.println("How many gallons of fresh juice are you donating?");
                    int gallons = sc.nextInt();
                    //natural fruit juice expires in around 12 days (assumption)
                    PerishableDrinks item = new PerishableDrinks("Juice", 12, gallons);
                    item.printItem();
                    donations.add(item);
                     e.getStockPerDrinks(item, perish, gallons);
                     e.setDonations(donations);
                    }
                    else if (perish == 3){
                    System.out.println("How many pounds of meat are you donating?");
                    int pounds = sc.nextInt();
                    //meat expires around 6 days in cool room
                    Perishables item = new Perishables("Meat", 6, pounds);
                    item.printItem();
                    donations.add(item);
                    e.getStockPer(item, perish, pounds);
                    e.setDonations(donations);
                    }
                    else if (perish == 4){
                    System.out.println("How many pounds of poultry are you donating?");
                    int pounds = sc.nextInt();
                    //poultry expires around 4 days in cool room
                    Perishables item = new Perishables("Poultry", 4, pounds);
                    item.printItem();
                    donations.add(item);
                    e.getStockPer(item, perish, pounds);
                    e.setDonations(donations);
                    }
                    else if (perish == 5){
                    System.out.println("How many pounds of seafood are you donating?");
                    int pounds = sc.nextInt();
                    //seafood expires around 5 days in cool room
                    Perishables item = new Perishables("Seafood", 5, pounds);
                    item.printItem();
                    donations.add(item);
                    e.getStockPer(item, perish, pounds);
                    e.setDonations(donations);
                    }
                    else if (perish == 6){
                    System.out.println("How many pounds of fruit are you donating?");
                    int pounds = sc.nextInt();
                    //fruit expiration varies
                    System.out.println("Estimate the number of days before fruit expires: ");
                    int expiry = sc.nextInt();
                    Perishables item = new Perishables("Fruit", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    e.getStockPer(item, perish, pounds);
                    e.setDonations(donations);
                    }
                    else if (perish == 7){
                    System.out.println("How many pounds of veggies are you donating?");
                    int pounds = sc.nextInt();
                    //vegetable expiration varies
                    System.out.println("Estimate the number of days before veggies expires: ");
                    int expiry = sc.nextInt();
                    Perishables item = new Perishables("Vegetables", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    e.getStockPer(item, perish, pounds);
                    e.setDonations(donations);
                    }
                }
                else if (type == 2){
                    System.out.println("Please select a type number from our Non-Perishables list:");
                    System.out.println("'1' = Canned, '2' = Dried, '3' = Dehydrated, 'any number' = Other");
                    int nonperish = sc.nextInt();
                    System.out.println("Type name of the item you want to donate");
                    String nameItem = sc.next();
                    if (nonperish == 1){
                    NonPerishables item = new NonPerishables(nameItem, "Canned");
                    item.printItem();
                    donations.add(item);
                    e.addNonPerish(item, nonperish);
                    e.setDonations(donations);
                    }
                    else if (nonperish == 2){
                    NonPerishables item = new NonPerishables(nameItem, "Dried");
                    item.printItem();
                    donations.add(item);
                    e.addNonPerish(item, nonperish);
                    e.setDonations(donations);
                    }
                    else if (nonperish == 3){
                    NonPerishables item = new NonPerishables(nameItem, "Dehydrated");
                    item.printItem();
                    donations.add(item);
                    e.addNonPerish(item, nonperish);
                    e.setDonations(donations);
                    }
                    else {
                    NonPerishables item = new NonPerishables(nameItem, "Other");
                    item.printItem();
                    donations.add(item);
                    e.addNonPerish(item, nonperish);
                    e.setDonations(donations);
                    }
                }
                
                System.out.println("Do you wish to donate another item? (Y/N)");
                String another = sc.next();
                if (another.equalsIgnoreCase("Y"))
                    System.out.println("You chose to add another item.");
                else
                    addItems = false;
                counter++;
                }
                contribution = contribution + counter;
       }
       if (contribution == 1 && contribution < 5)
        prizeEarned = "none";
        else if (contribution >= 5 && contribution < 10)
        prizeEarned = "sticker";
        else if (contribution >= 10 && contribution <15)
        prizeEarned = "sticker" + ", key chain";
        else if (contribution >= 15 && contribution < 20)
        prizeEarned = "sticker, key chain" + ", lunchbox";
        else if (contribution >= 20)
        prizeEarned = "sticker, key chain, lunchbox" + ", $20 Walmart Giftcard";

    }

}
