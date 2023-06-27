package bankaccountapp;

public class Saving extends Account {
	
	//List properties specific to a saving account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//Constructor to initialize settings for the saving properties
	public Saving(String name, String sSN, double initDeposit) {
		super(name,sSN,initDeposit);
		accountNumber="1"+accountNumber;
		setSafetyDepositBox();

	}private void setSafetyDepositBox(){
		safetyDepositBoxID= (int) (Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey= (int) (Math.random()*Math.pow(10, 4));
	}
	@Override
	public void setRate() {
		rate= getBaseRate()-0.25;
	}
	
	//List any methods specific to the saving account
	public void showInfo() {
		super.showInfo();
		System.out.println("Your SavingS Account Features"+
				"\n Safety deposit box ID: "+safetyDepositBoxID+
				"\n Safety deposit box Key: "+safetyDepositBoxKey);
		
	}
	
	

}
