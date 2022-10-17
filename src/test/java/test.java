//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.*;

import org.junit.Test;


public class test {
    @Test
    public void testATMDriver(){
        ATM ourATM = new ATM(1000.00);
        User bill   = new User("Bill Murray",9128);
        User keanu  = new User("Keanu Reeves",2407);

        assertEquals(9128, bill.getPIN());
        assertEquals(2407,keanu.getPIN());  //tests functionality
        assertEquals("Bill Murray", bill.getID());
        assertEquals("Keanu Reeves", keanu.getID());

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
        assertEquals(1175.50, bill.sumAll(), 1175.50); //double check to make sure delta is correct (3rd value)
        assertEquals(317.33, keanu.sumAll(), 317.33);
    }
}
