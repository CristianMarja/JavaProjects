package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		/*
		Checking chkacc1=new Checking("Tom Wilson","32450752",1500);
		
		Saving savacc1=new Saving("Rich Lowe","45236738",2500);
		
		System.out.println("***********************************");
		
		chkacc1.showInfo();
		
		System.out.println("***********************************");
		savacc1.showInfo();
		savacc1.compound();
		savacc1.showInfo();*/
		

		/*
		savacc1.deposit(5000);
		savacc1.withdraw(200);
		savacc1.transfer("McHill", 2500);
		*/
		List<Account> accounts=new LinkedList<Account>();
		//Read a CSV File them create new accounts based on that data
		
		String file="C:\\Users\\CM\\eclipse-workspace\\JavaProjects\\NewBankAccounts.csv";
		
		List<String[]> newAccountHolder=utilities.CSV.read(file);
		for (String[] accountHolder: newAccountHolder) {
			System.out.println("NEW ACCOUNT");
			String name=accountHolder[0];
			String sSN=accountHolder[1];
			String accountType=accountHolder[2];
			double initDeposit=Double.parseDouble(accountHolder[3]);
			System.out.println(name+" "+sSN+" "+accountType+" "+initDeposit);
			if(accountType.equals("Savings")) {
				System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Saving(name, sSN, initDeposit));
			}else if (accountType.equals("Checking")) {
				System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name, sSN, initDeposit));
			}else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account acc: accounts) {
			System.out.println("********************************");
			acc.showInfo();
		}
	}

}
