package manual.mutation.run;//package SEATM;
import java.util.*;

/**
 * @author Luke Marsicano
 */

//Protected methods
//Interest
//Fee with withdraw


public class User {
	ArrayList<Account> myAccounts;
	String ID;
	int PIN;
	
	public User(String ID, int PIN, ArrayList<Account> accounts) {
		myAccounts = accounts;
		this.ID = ID;
		this.PIN = PIN;
	}
	
	public User(String ID, int PIN) {
		myAccounts = new ArrayList<Account>(20);
		this.ID = ID;
		this.PIN = PIN;
	}
	
	public void addAccount(Account acc) {
		myAccounts.add(acc);
	}
	
	public void addAccount(double amount, String ID) {
		myAccounts.add(new Account(amount,ID));
	}
	

	public ArrayList<Account> getMyAccounts() {
		return myAccounts;
	}

	public void setMyAccounts(ArrayList<Account> myAccounts) {
		this.myAccounts = myAccounts;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int PIN) {
		this.PIN = PIN;
	}
	
	public double sumAll() {
		double tot = 0.00;
		for (int i = 0 ; i < myAccounts.size() ; i++ ) {
			tot += myAccounts.get(i).getAmount();
		}
		return tot;
	}
	
	/**
	 * 
	 * @param pin the passcode to access the user's accounts
	 * @param ID specific title for each account the user has
	 * @return the manual.mutation.run.Account requested if it exists and the pin is correct, else it returns null
	 */
	public Account requestAccount(int pin, String ID) {
		if (pin != PIN) {
			return null;
		}
		for (int i = 0 ; i < myAccounts.size() ; i++ ) {
			if (myAccounts.get(i).getID().equals(ID)) {
				return myAccounts.get(i);
			}
		}
		return null;
	}
	
	public String toString() {
		String fin = "(";
		fin += ID + "'s accounts: ";
		for (int i = 0 ; i < myAccounts.size() ; i++) {
			if (i == myAccounts.size() - 1) {
				fin += myAccounts.get(i).toString();
			} else {
				fin += myAccounts.get(i).toString() + ", ";
			}
		}
		fin += ")";
		return fin;
	}
}
