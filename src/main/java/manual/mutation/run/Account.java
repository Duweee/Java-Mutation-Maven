package manual.mutation.run;//package SEATM;
import java.util.*;

public class Account {
	private double amount;
	private String ID;
	
	Account(double amount, String ID){
		this.amount = amount;
		this.ID     = ID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amt){
		amount=amt;
	}

	public String getID() {
		return ID;
	}
	
	public void deposit(double dep) {
		amount += dep;
	}
	
	public boolean withdraw(double wit) {
		if(amount <= 0.00) {
			return false;
		} else if (amount - wit < 0) {
			amount = 0;
			return false;
		}
		amount -= wit;
		return true;
	}
	
	/**
	 * Simulates a withdraw with a percent fee
	 * 
	 * @param wit amount to be withdrawn, must be greater than 0
	 * @param per percentage of amount withdrawn to be taken from the main account must be greater than 0
	 * @return the fee taken from the account WILL RETURN -1 if params not met
	 */
	public double withdrawFee(double wit, double per) {
		double percent = per/100;
		double fee = -1;
		if (amount > 0 && wit > 0 && per > 0) {
			amount -= wit;
			fee = wit*percent;
			amount -= fee;
		}
		return Double.valueOf(Math.round(fee*100))/100;
	}
	
	/**
	 * Applies simple interest over a certain amount of years
	 * 
	 * @param year a positive non-zero integer number
	 * @param per  a positive percentage
	 * @return a double
	 */
	public double simpleInterest(int year, double per) {
		double gain = ((per/100)*amount)*year;
		amount += gain;
		return gain;
	}
	
	public String toString() {
		return "{ID: " + ID + ", AMOUNT: $" + Double.valueOf(Math.round(amount*100))/100 + "}";
	}

}
