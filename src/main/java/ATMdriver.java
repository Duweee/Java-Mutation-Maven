//package SEATM;
import java.util.*;

public class ATMdriver {
	static ATM ourATM = new ATM(1000.00);
	static User bill   = new User("Bill Murray",9128);
	static User keanu  = new User("Keanu Reeves",2407);
	
	public static void main (String args[]) {
		boolean running = true;
		Scanner in = new Scanner(System.in);
		
		populate();
		
		System.out.println("Enter an int to choose a test\n 0: print all \n 1: apply Interest \n 2: withdraw 20 from all account \n 3: wiithdraw 20 with fee\n");
		
		while (running) {
			int valIn = in.nextInt();
			switch (valIn) {
				case 0  : printAll();
						  break;
				case 1  : applyInterest();
						  break;
				case 2  : withdrawAll(20.00);
						  break;
				case 3  : withdrawFeeAll(20.00,5);
						  break;
				default : System.out.println("Enter a valid int");
						  break;
			}
		}
		
		
	}
	
	public static void populate() {
	
		Account ac1 = new Account(90.87,"0001");
		Account ac2 = new Account(34.22,"0002");
		Account ac3 = new Account(1050.41,"0003");
		
		Account ac4 = new Account(0.54,"0001");
		Account ac5 = new Account(15.66,"0002");
		Account ac6 = new Account(66.70,"0003");
		Account ac7 = new Account(234.43,"0004");
		
		bill.addAccount(ac1);
		bill.addAccount(ac2);
		bill.addAccount(ac3);
		
		keanu.addAccount(ac4);
		keanu.addAccount(ac5);
		keanu.addAccount(ac6);
		keanu.addAccount(ac7);
		
		ourATM.add(keanu);
		ourATM.add(bill);
	}
	
	public static void printAll() {
		System.out.println("ATM balance: " + ourATM.getATMBalance());
		System.out.println("CURRENT USERS");
		System.out.println("----------------------------------------");
		for (int i = 0 ; i < ourATM.getMyUsers().size(); i++) {
			System.out.println(ourATM.getMyUsers().get(i));
		}
		System.out.println("----------------------------------------");
	}
	
	public static void applyInterest() {
		System.out.println("Applying ten years of 5% interest to all accounts of all users");
		for (int i = 0 ; i < ourATM.getMyUsers().size() ; i++) {
			for (int u = 0 ; u < ourATM.getMyUsers().get(i).getMyAccounts().size() ; u++) {
				ourATM.getMyUsers().get(i).getMyAccounts().get(u).simpleInterest(10, 5);
			}
		}
	}
	
	public static void withdrawAll(double wit) {
		System.out.println("Withdrawing $" + wit + " dollars from each account");
		for (int i = 0 ; i < ourATM.getMyUsers().size() ; i++) {
			for (int u = 0 ; u < ourATM.getMyUsers().get(i).getMyAccounts().size() ; u++) {
				ourATM.getMyUsers().get(i).getMyAccounts().get(u).withdraw(wit);
			}
		}
	}
	
	public static void withdrawFeeAll(double wit, double per) {
		System.out.println("Withdrawing $" + wit + " dollars from each account, with a fee of " + per + "%");
		for (int i = 0 ; i < ourATM.getMyUsers().size() ; i++) {
			for (int u = 0 ; u < ourATM.getMyUsers().get(i).getMyAccounts().size() ; u++) {
				ourATM.getMyUsers().get(i).getMyAccounts().get(u).withdrawFee(wit,per);
			}
		}
	}
}
