

public class Account{

	PersistenceManager pm = new PersistenceManager();
	private int accountID;
	private int category;
	private float balance;
	
	Account() {

	}


	public float getBalance() {
		return pm.fetchAccBal(this.getAccountID());
	}

	public float getBalance(int inputID) {
		return pm.fetchAccBal(inputID);
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}


	public void makeTransaction(Customer cust, float amount) {
		pm.updateAccBalance(amount, cust.getID());

	}

	public float getPreviousTransaction(Customer cust) {
		return (pm.fetchPrevTransaction(cust.getID()));
	}

	public float calculateInterest(Customer cust, float rate, int years) {
		rate /= 100;
		float balance = cust.getBalance();
		return (balance + balance * rate * years);
	}

}
