package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix="company.com";

	
	//Constructor to receive the first name and last name
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call a method asking for the department - return department
		this.department=setdepartment();

		
		//Call a method that return a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password);
		
		//Combine elements to generate email
		email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	}
	
	//Ask for the department
	private String setdepartment() {
	System.out.println("New worker: "+firstName+ ". DEPARTMENT CODES\n1 for sales\n2 for Development\n3 for Accounting\n0 for None\nPlease enter your department code: ");
	Scanner in =new Scanner(System.in);
	int depChoice=in.nextInt();
	if(depChoice==1) {return "sales";}
	else if(depChoice==2) {return "Dev";}
	else if(depChoice==3) {return "acct";}
	else {return "";}
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		for (int i = 0; i < length; i++) {
		 int rand=(int) (Math.random()*passwordSet.length());
		 password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	//Set mailbox capacity
	public void setmailBoxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;
	}
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
	
	//Change password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailboxCapacity(){return mailBoxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailBoxCapacity+"mb";
	}
	
}
