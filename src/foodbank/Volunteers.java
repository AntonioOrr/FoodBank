/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbank;

import java.util.Scanner;

/**
 *
 * @author Antonio
 */
//accounts that are volunteers
public class Volunteers extends UserAccount{
    private String volunteerWork = "";
    private int hoursWorked = 0;
    private int totalHours = hoursWorked;

    public Volunteers(String n, int a, int voluntNum, int hours) {
        super(n,a);
        totalHours = hoursWorked + hours;
        hoursWorked = hours;
        //gives volunteer task according to number
        if (voluntNum == 1)
        volunteerWork = "Cleaning";
        else if (voluntNum == 2)
        volunteerWork = "Thief Watch";
        else if (voluntNum == 3)
        volunteerWork = "Customer Attraction";
        else {
            volunteerWork = "n/a";
            hoursWorked = 0;
        }
    }

    public String getVolunteerWork() {
        return volunteerWork;
    }

    public void setVolunteerWork(String volunteerWork) {
        this.volunteerWork = volunteerWork;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int hours) {
        totalHours = totalHours + hours;
    }
    
    @Override
    public void print(){
        System.out.println("Username : " + name + ", " + "Age: " + age + ", " + "Current Task: " + volunteerWork +
                 ", " + "Total Volunteering Hours: " + totalHours);
        System.out.println("We appreciate your volunteering efforts for the Food Bank!");
    }
    
    @Override
    public void printAccount(){
        System.out.println("Welcome back " + name + ", " + "aged " + age + "!");
        System.out.println("Status: Volunteer, " + "Current Task: " + volunteerWork +
                 ", " + "Total Volunteering Hours: " + totalHours);
    }
    
     @Override
    public void printChange(){
        System.out.println(name + ", in change settings you can change your account name, age, "
                + "volunteer work, and work hours.");
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
        System.out.println("Change volunteer work? (Y/N)");
        change = sc.next();
         if (change.equalsIgnoreCase("Y")){
            System.out.println("Choose number indicating job ('1' for Cleaning, '2' for Thief Watch,"
                    + " '3' for Customer Service):");
            int newVolunt = sc.nextInt();
            System.out.println("How many planned hours of volunteering?");
            int newHours = sc.nextInt();
            if (newVolunt == 1){
            volunteerWork = "Cleaning";
            totalHours = hoursWorked + newHours;
            hoursWorked = newHours;}
            else if (newVolunt == 2){
            volunteerWork = "Thief Watch";
            totalHours = hoursWorked + newHours;
            hoursWorked = newHours;}
            else if (newVolunt == 3){
            volunteerWork = "Customer Attraction";
            totalHours = hoursWorked + newHours;
            hoursWorked = newHours;}
            else {
                volunteerWork = "n/a";
                hoursWorked = 0;
        }
 
        }
    }
}
