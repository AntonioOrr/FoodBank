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
//objects of user accounts
public class UserAccount {
    protected String name = "";
    protected int age = 0;

    public UserAccount(String n, int a) {
        name = n;
        age = a;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    //methods below are overidden
    public void print(){
        System.out.println("Username : " + name + ", " + "Age: " + age);
    }
    
    public void printAccount(){
        System.out.println("Username : " + name + ", " + "Age: " + age);
    }
    public void printChange(){
        System.out.println(name + ", you chose to change your settings.");
    }
    //change settings method
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
    }



}
