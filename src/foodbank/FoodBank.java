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
public class FoodBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Community Food Bank Inventory System
        Major function 1 (create account): use UserAccount object to make 3 different types of accounts
        Major function 2 (account ArrayList): makes array of total number of accounts
        Major function 3 (stock food items): creates an object that stores all food items
        Major function 4 (donation prizes): gives donors incentives to donating food items by giving away prizes
        Major function 5 (simulate store activity): checks for sold or spoiled items and removes them from stock
        (There are probably other major functions not listed above)
        */
        //NOTE: Program does not catch misinput exceptions. Please do not mess up inputs
        Scanner sc = new Scanner(System.in);
        //When program runs, user has the option to choose if they want to create an account
        System.out.println("This is a Food Bank simulation test program");
        System.out.println("HELP WANTED: Need employees/volunteers/donors!"
                + " Be the first to support us and create an account!");
        
        System.out.println("Create an account? (Y/N)");
        String decide = sc.next();
        int day = 0;
        boolean life = false;
        int id;
        AccountCollection collect = new AccountCollection();
        UserAccount userStarter = new UserAccount("", 0);
        ArrayList<FoodItem> donations = new ArrayList();
        FoodItem item;
        FoodStock stock = new FoodStock("", 0, donations);
        //User decides to create an account
        if (decide.equalsIgnoreCase("Y")){
       
            System.out.println("Please enter username:");
            String userName = sc.next();
            System.out.println("Please enter your age:");
            int age = sc.nextInt();
            boolean ageCriterion = false;
            if (age < 18){
                while (!ageCriterion){
                    System.out.println("You must be at least 18!");
                    System.out.println("Please enter your age:");
                    age = sc.nextInt();
                    if (age >= 18)
                        ageCriterion = true;
                }
            }
            //UserAccount has been made
            userStarter = new UserAccount(userName, age);
            userStarter.print();
            
            System.out.println("You chose to create an account. Select '1' for employee, "
                    + "'2' for volunteer, or '3' for donor: ");
            int member = sc.nextInt();
            //depending on the user's choice, they will either create an Employee/Voloneer/Donor object
            switch (member){
                case 1:
                System.out.println("Select your job choice ('1' for Stocking, '2' for Planning, '3' for Customer Service):");
                int job = sc.nextInt();
                if (job == 1){
                userStarter = new Employees(userName, age, 1);
                userStarter.print();
                }
                else if (job == 2){
                userStarter = new Employees(userName, age, 2);
                userStarter.print();
                }
                else if (job == 3){
                userStarter = new Employees(userName, age, 3);
                userStarter.print();
                }
                else {
                //optional: create an account without working/volunteering
                userStarter = new Employees(userName, age, 0);
                userStarter.print();
                }
                break;
                case 2:
                System.out.println("Select your job choice ('1' for Cleaning, '2' for Thief Watch, '3' for Customer Attraction):");
                int job1 = sc.nextInt();
                System.out.println("How many hours do you plan on volunteering?");
                int hours = sc.nextInt();
                if (job1 == 1){
                userStarter = new Volunteers(userName, age, 1, hours);
                userStarter.print();
                }
                else if (job1 == 2){
                userStarter = new Volunteers(userName, age, 2, hours);
                userStarter.print();
                }
                else if (job1 == 3){
                userStarter = new Volunteers(userName, age, 3, hours);
                userStarter.print();
                }
                else {
                userStarter = new Volunteers(userName, age, 0, hours);
                userStarter.print();
                }
                break;
                case 3:
                boolean addItems = true;
                while (addItems){
                /*depending on user's choice, they will create new PerishableDrink/Perishable
                /NonPerishable object */
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
                    item = new PerishableDrinks("Milk", 10, gallons);
                    item.printItem();
                    //donations ArrayList<FoodItem> gets added
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    //as donations go up, the stock collects objects while storing donations
                    stock.getStockPerDrinks(item, perish, gallons);
                    stock.setDonations(donations);
                    }
                    else if (perish == 2){
                    System.out.println("How many gallons of fresh juice are you donating?");
                    int gallons = sc.nextInt();
                    //natural fruit juice expires in around 12 days (assumption)
                    item = new PerishableDrinks("Juice", 12, gallons);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPerDrinks(item, perish, gallons);
                    stock.setDonations(donations);
                    }
                    else if (perish == 3){
                    System.out.println("How many pounds of meat are you donating?");
                    int pounds = sc.nextInt();
                    //meat expires around 6 days in cool room
                    item = new Perishables("Meat", 6, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 4){
                    System.out.println("How many pounds of poultry are you donating?");
                    int pounds = sc.nextInt();
                    //poultry expires around 4 days in cool room
                    item = new Perishables("Poultry", 4, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 5){
                    System.out.println("How many pounds of seafood are you donating?");
                    int pounds = sc.nextInt();
                    //seafood expires around 5 days in cool room
                    item = new Perishables("Seafood", 5, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 6){
                    System.out.println("How many pounds of fruit are you donating?");
                    int pounds = sc.nextInt();
                    //fruit expiration varies
                    System.out.println("Estimate the number of days before fruit expires: ");
                    int expiry = sc.nextInt();
                    item = new Perishables("Fruit", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 7){
                    System.out.println("How many pounds of veggies are you donating?");
                    int pounds = sc.nextInt();
                    //vegetable expiration varies
                    System.out.println("Estimate the number of days before veggies expires: ");
                    int expiry = sc.nextInt();
                    item = new Perishables("Vegetables", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                }
                else if (type == 2){
                    System.out.println("Please select a type number from our Non-Perishables list:");
                    System.out.println("'1' = Canned, '2' = Dried, '3' = Dehydrated, 'any other number' = Other");
                    int nonperish = sc.nextInt();
                    System.out.println("Type name of the item you want to donate");
                    String nameItem = sc.next();
                    if (nonperish == 1){
                    item = new NonPerishables(nameItem, "Canned");
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else if (nonperish == 2){
                    item = new NonPerishables(nameItem, "Dried");
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else if (nonperish == 3){
                    item = new NonPerishables(nameItem, "Dehydrated");
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else {
                    item = new NonPerishables(nameItem, "Other");
                    item.printItem();
                    donations.add(item);
                    userStarter = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                }
                userStarter.print();
                System.out.println("Do you wish to donate another item? (Y/N)");
                String another = sc.next();
                if (another.equalsIgnoreCase("Y"))
                    System.out.println("You chose to add another item.");
                else
                    addItems = false;
                }
                
        }
        //account gets added to AccountCollection
        collect.addAccount(userStarter);
        
        //generates user id
        id = collect.generateId();
        System.out.println("Your new ID is: " + id + ". Remember it well to sign back in.");
        
        //allows user to press enter before moving on
        System.out.println("press Enter to continue");
        //press Enter to continue
        Scanner s = new Scanner(System.in);
        s.nextLine();
        
        life = true;
        System.out.println("Food Bank is now officially open for business!");
        }
        //while loop continues until user decides to close program
        while (life){
            //a day passes
            day++;
            System.out.println("Day " + day + ":");
            boolean contDay = true;
            //while loop continues until user decides to end day or close program
            while (contDay){
                int select = 0;
                printSelection();
                select = sc.nextInt();
            //allows user to create new account
            if (select == 1){
                ArrayList<FoodItem> donations1 = new ArrayList();
                FoodItem item1 = new FoodItem("");
                createAccount(collect, userStarter, donations1, item1, stock);
                id = collect.generateId();
                System.out.println("Your new ID is: " + id + ". Remember it well to sign back in. (press Enter to continue)");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                
            }
            //outputs unique statements for amount of user accounts
            else if (select == 2){
                int numUsers = collect.getNumUsers();
                if (numUsers < 5)
                System.out.println("There are currently " + numUsers + " users.");
                else if (numUsers >= 5 && numUsers < 20)
                System.out.println("Nice! there are currently " + numUsers + " user accounts.");
                else
                System.out.println("We have reached " + numUsers + " users. Outstanding!");
                System.out.println("press Enter to continue");
                Scanner s = new Scanner(System.in);
                s.nextLine();
            }
            //Allows users to view their account status and store's inventory
            else if (select == 3){
               int choice = 0;
               System.out.println("Would you like to view your account or the store's inventory? ('1' for Account, '2' for Inventory):");
               choice = sc.nextInt();
               if (choice == 1){
               System.out.println("Enter your ID: ");
               int idConfirm = sc.nextInt();
               if (collect.getNumUsers() >= idConfirm){
               userStarter = collect.viewAccount(idConfirm);
               userStarter.printAccount();
               }
               else
               System.out.println("ID not found!");
               System.out.println("press Enter to continue");
               Scanner s = new Scanner(System.in);
               s.nextLine();
               }
               else if (choice == 2){
               stock.printStock();
               }
               else
               System.out.println("Invalid choice");
               
            }
            //allows user to change account name, age, and other things depending on the object type
            else if (select == 4){
               System.out.println("NOTE: You cannot change your Status or delete your account!");
               System.out.println("Enter your ID: ");
               int idConfirm = sc.nextInt();
               if (collect.getNumUsers() >= idConfirm){
               userStarter = collect.viewAccount(idConfirm);
               userStarter.printChange();
               userStarter.changeUp(stock);
               System.out.println("Settings have been saved.");
               userStarter.print();
               }
               else
               System.out.println("ID not found.");

            }
            //ends the day
            else if (select == 5){
                break;
            }
            //ends the program
            //caution: entering number other than 1-5 terminates the program
            else{
                life = false;
                break;
            }
            System.out.println("Select another option? (Y/N)");
            String cont = sc.next();
            if (cont.equalsIgnoreCase("Y"));
            else{
                contDay = false;
            }
            
            }
            /*before day ends, user receives notifications of whether or not items have been removed
            from inventory
            */
            if (life == true){
            System.out.println("Day " + day + " will now end. (press Enter to continue)");
            Scanner s = new Scanner(System.in);
            s.nextLine();
            System.out.println("End of Day Notifications: ");
            stock.simulateStoreActivity();
            }
            
        }
         //if user does not make account or chooses to quit, program terminates
            System.out.println("OUT OF BUSINESS! Program has ended.");
        
        
    }
    //method of the create account process, only slightly modified for multiple users
    public static void createAccount(AccountCollection a, UserAccount userStarterN, ArrayList<FoodItem> donations, FoodItem item, FoodStock stock){
        Scanner sc = new Scanner(System.in);
            System.out.println("Please enter username:");
            String userName = sc.next();
            System.out.println("Please enter your age:");
            int age = sc.nextInt();
            boolean ageCriterion = false;
            if (age < 18){
                while (!ageCriterion){
                    System.out.println("You must be at least 18!");
                    System.out.println("Please enter your age:");
                    age = sc.nextInt();
                    if (age >= 18)
                        ageCriterion = true;
                }
            }
            
            userStarterN = new UserAccount(userName, age);
            userStarterN.print();
            
            System.out.println("You chose to create an account. Select '1' for employee, "
                    + "'2' for volunteer, or '3' for donor: ");
            int member = sc.nextInt();

            switch (member){
                case 1:
                System.out.println("Select your job choice ('1' for Stocking, '2' for Planning, '3' for Customer Service):");
                int job = sc.nextInt();
                if (job == 1){
                userStarterN = new Employees(userName, age, 1);
                userStarterN.print();
                }
                else if (job == 2){
                userStarterN = new Employees(userName, age, 2);
                userStarterN.print();
                }
                else if (job == 3){
                userStarterN = new Employees(userName, age, 3);
                userStarterN.print();
                }
                else {
                //optional: create an account without working/volunteering
                userStarterN = new Employees(userName, age, 0);
                userStarterN.print();
                }
                break;
                case 2:
                System.out.println("Select your job choice ('1' for Cleaning, '2' for Thief Watch, '3' for Customer Attraction):");
                int job1 = sc.nextInt();
                System.out.println("How many hours do you plan on volunteering?");
                int hours = sc.nextInt();
                if (job1 == 1){
                userStarterN = new Volunteers(userName, age, 1, hours);
                userStarterN.print();
                }
                else if (job1 == 2){
                userStarterN = new Volunteers(userName, age, 2, hours);
                userStarterN.print();
                }
                else if (job1 == 3){
                userStarterN = new Volunteers(userName, age, 3, hours);
                userStarterN.print();
                }
                else {
                userStarterN = new Volunteers(userName, age, 0, hours);
                userStarterN.print();
                }
                break;
                case 3:
                boolean addItems = true;
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
                    item = new PerishableDrinks("Milk", 10, gallons);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPerDrinks(item, perish, gallons);
                    stock.setDonations(donations);
                    }
                    else if (perish == 2){
                    System.out.println("How many gallons of fresh juice are you donating?");
                    int gallons = sc.nextInt();
                    //natural fruit juice expires in around 12 days (assumption)
                    item = new PerishableDrinks("Juice", 12, gallons);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPerDrinks(item, perish, gallons);
                    stock.setDonations(donations);
                    }
                    else if (perish == 3){
                    System.out.println("How many pounds of meat are you donating?");
                    int pounds = sc.nextInt();
                    //meat expires around 6 days in cool room
                    item = new Perishables("Meat", 6, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 4){
                    System.out.println("How many pounds of poultry are you donating?");
                    int pounds = sc.nextInt();
                    //poultry expires around 4 days in cool room
                    item = new Perishables("Poultry", 4, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 5){
                    System.out.println("How many pounds of seafood are you donating?");
                    int pounds = sc.nextInt();
                    //seafood expires around 5 days in cool room
                    item = new Perishables("Seafood", 5, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 6){
                    System.out.println("How many pounds of fruit are you donating?");
                    int pounds = sc.nextInt();
                    //fruit expiration varies
                    System.out.println("Estimate the number of days before fruit expires: ");
                    int expiry = sc.nextInt();
                    item = new Perishables("Fruit", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                    else if (perish == 7){
                    System.out.println("How many pounds of veggies are you donating?");
                    int pounds = sc.nextInt();
                    //vegetable expiration varies
                    System.out.println("Estimate the number of days before veggies expires: ");
                    int expiry = sc.nextInt();
                    item = new Perishables("Vegetables", expiry, pounds);
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.getStockPer(item, perish, pounds);
                    stock.setDonations(donations);
                    }
                }
                else if (type == 2){
                    System.out.println("Please select a type number from our Non-Perishables list:");
                    System.out.println("'1' = Canned, '2' = Dried, '3' = Dehydrated, 'any number' = Other");
                    int nonperish = sc.nextInt();
                    System.out.println("Type name of the item you want to donate");
                    String nameItem = sc.next();
                    if (nonperish == 1){
                    item = new NonPerishables(nameItem, "Canned");
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else if (nonperish == 2){
                    item = new NonPerishables(nameItem, "Dried");
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else if (nonperish == 3){
                    item = new NonPerishables(nameItem, "Dehydrated");
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                    else if (nonperish == 4){
                    item = new NonPerishables(nameItem, "Other");
                    item.printItem();
                    donations.add(item);
                    userStarterN = new Donors(userName, age, donations);
                    stock.addNonPerish(item, nonperish);
                    stock.setDonations(donations);
                    }
                }
                userStarterN.print();
                System.out.println("Do you wish to donate another item? (Y/N)");
                String another = sc.next();
                if (another.equalsIgnoreCase("Y"))
                    System.out.println("You chose to add another item.");
                else
                    addItems = false;
                }
        }
        a.addAccount(userStarterN);
    }
    //method that prints a list of objects for user to choose from
    public static void printSelection(){
        System.out.println("Select a number: ");
        System.out.println("1 = Create Account");
        System.out.println("2 = View Total Number of Members");
        System.out.println("3 = View Account/Inventory");
        System.out.println("4 = Change Account Settings");
        System.out.println("5 = End Day");
        System.out.println("6 = Quit");
    }
    
}
