package foodbank;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
//accounts that are employees
public class Employees extends UserAccount{
    private String occupation = "";
    private int payRate = 0;
    
    //job and pay rate depends on the user's choice
    public Employees(String n, int a, int occu) {
        super(n, a);
        if (occu == 1){
            occupation = "Stocker";
            payRate = 15;
        }
        else if (occu == 2){
            occupation = "Planner";
            payRate = 34;
        }
        else if (occu == 3){
            occupation = "Customer Service";
            payRate = 24;
        }
        else{
            occupation = "n/a";
            payRate = 0;
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getPayRate() {
        return payRate;
    }

    public void setPayRate(int payRate) {
        this.payRate = payRate;
    }
    
    

          
    
    @Override
    public void print(){
        System.out.println("Username : " + name + ", " + "Age: " + age + ", " + "Occupation: " + occupation +
                ", " + "PayRate: $" + payRate + "/hr.");
        System.out.println("Thanks for working with the Food Bank! We hope to pay you modestly for your work.");
    }
    
    @Override
    public void printAccount(){
        System.out.println("Welcome back " + name + ", " + "aged " + age + "!");
        System.out.println("Status: Employee, " + "Occupation: " + occupation +
                ", " + "PayRate: $" + payRate + "/hr.");
    }
    
    @Override
    public void printChange(){
        System.out.println(name + ", in change settings you can change your account name, age, and occupation.");
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
        System.out.println("Change job? (Y/N)");
        change = sc.next();
         if (change.equalsIgnoreCase("Y")){
            System.out.println("Choose number indicating job ('1' for Stocking, '2' for Planning, '3' for Customer Service):");
            int occ = sc.nextInt();
            if (occ == 1){
            occupation = "Stocker";
            payRate = 15;
            }
            else if (occ == 2){
                occupation = "Planner";
                payRate = 34;
            }
            else if (occ == 3){
                occupation = "Customer Service";
                payRate = 24;
            }
            else{
                occupation = "n/a";
                payRate = 0;
            }
            }
    }
    
}
