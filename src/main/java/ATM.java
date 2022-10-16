//package SEATM;
import java.util.*;

public class ATM {
	
	//FIELDS
    private double ATM_balance;
    private ArrayList<User> myUsers= new ArrayList<User>();
    
    //CONSTRUCTORS
    public ATM(double balance, ArrayList<User> myUsers){
        ATM_balance  = balance;
        this.myUsers = myUsers;
    }
    
    public ATM(double balance) {
    	ATM_balance = balance;
    }
    
    
    //METHODS
    public ArrayList<User> getMyUsers(){
    	return myUsers;
    }

    public void ATM_deposit(double money){
        ATM_balance += money;
    }
    
    public double sumAll() {
    	double tot = 0.00;
    	for (int i = 0 ; i < myUsers.size() ; i++ ) {
    		tot += myUsers.get(i).sumAll();
    	}
    	return tot;
    }

    public void ATM_withdraw(double money){
        ATM_balance -= money;
    }
    
    /**
     * 
     * @param request a String object
     * @return will return the User that matches its ID to the request string WILL RETURN NULL IF NOT FOUND
     */
    public User requestUser(String request) {
    	for (int i = 0 ; i < myUsers.size() ; i++) {
    		if (myUsers.get(i).getID().equals(request)) {
    			return myUsers.get(i);
    		}
    	}
    	return null;
    }

    public void add(User user) {
    	myUsers.add(user);
    }
    
    public String toString() {
    	String fin = "[";
    	for (int i = 0 ; i < myUsers.size() ; i++) {
    		fin += myUsers.get(i).toString();
    	}
    	fin += "]";
    	return fin;
    }
    
    public double getATMBalance(){
        return ATM_balance;
    }
}
