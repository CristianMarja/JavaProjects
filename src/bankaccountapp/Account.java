package bankaccountapp;

public abstract class Account implements IRate {

	//List common properties for savings and checking accounts
	private String name;
	private String sSN;
	private double balance;
	
	private static int index=10000;
	protected String accountNumber;
	protected double rate;
	
	//Constructor to set properties and initialize  the account
	
	public Account(String name, String sSN, double initDeposit) {
		this.name=name;
		this.sSN=sSN;
		this.balance=initDeposit;

		//Set account number
		index++;
		accountNumber=setAccountNumber();
		System.out.println(getBaseRate());
		setRate();
	}
	public abstract void setRate(); 
	
	private String setAccountNumber() {
		String lastTwooFSSN=sSN.substring(sSN.length()-2);
		int uniqueID=index;
		int randomNumber= (int) (Math.random()*Math.pow(10, 3));
		return lastTwooFSSN+uniqueID+randomNumber;
	}
	
	public void compound() {
		double accruedInterest=balance*rate/100;
		balance=balance+accruedInterest;
		System.out.println("Accrued Interest: $ "+accruedInterest);
	}
	//List common methods
	
	public void showInfo() {
		System.out.println(
				"NAME: "+name+
		"\nACCOUNT NUMBER: "+accountNumber+
		"\nBALANCE: "+balance+
		"\nRATE: "+rate+"%"
				);
	}
	
	public void deposit(double amount) {
		balance=balance+amount;
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance=balance-amount;
		printBalance();
	}
	
	public void transfer(String toWhere,double amount) {
		balance=balance-amount;
		System.out.println("Transfering USD $ "+amount+" to: "+toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance now is: USD $ "+balance);
	}
}
