/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodbank;

import java.util.ArrayList;

/**
 *
 * @author Antonio
 */
//collects all user accounts
public class AccountCollection {
    private final ArrayList<UserAccount> accountList = new ArrayList();
    

    public AccountCollection() {
        
    }
    
    public void addAccount(UserAccount user){
        accountList.add(user);
        
    }
    public UserAccount viewAccount(int idNum){
        return accountList.get(idNum - 1);
    }
    
    //generates new ID
    public int generateId(){
         int counter = 0;
        for (int i = 0; i < accountList.size(); i++)
            counter++;
        return counter;
    }
    

    public int getNumUsers(){
        int counter = 0;
        for (int i = 0; i < accountList.size(); i++)
            counter++;
        return counter;
    }
    
    
    
    
    
}
