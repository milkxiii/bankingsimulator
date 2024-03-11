import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Account{

	PersistenceManager pm = new PersistenceManager();
	float balance;
	int accountID;
	int category;
	ArrayList<Float> transactions = new ArrayList<Float>();

	Account() {

	}

	Account(int accountID, int category, int balance) {
		this.accountID = accountID;
		this.category = category;
		this.balance = balance;
		this.transactions = null;
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

	public ArrayList<Float> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Float> transactions) {
		this.transactions = transactions;
	}

	public void checkBalance(Customer cust) {
		System.out.println("Balance: $" + cust.getBalance());
	}

	public void deposit(Customer cust) throws IOException {
		System.out.print("Enter an amount of deposit: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String depositAmount = br.readLine();
		Float finalDeposit = Float.parseFloat(depositAmount);
		this.makeTransaction(cust, finalDeposit);

	}	

	public void makeTransaction(Customer cust, float amount) {
		// add amount to the total balance of this account
		float transactionAmount = amount;
		this.balance += transactionAmount;
		cust.setBalance(this.balance);
		transactions.add(transactionAmount);
		pm.updateAccBalance(transactionAmount, cust.getID());

	}

	public void getPreviousTransaction() {
		if(transactions.size() > 0) {
			Float previousTransaction = transactions.get(transactions.size()-1);
			if (previousTransaction < 0) {
				System.out.println("Withdrawn: $" + (-1) * previousTransaction);
			}

			else if (previousTransaction > 0) {
				System.out.println("Deposited: $" + previousTransaction);
			}
		}
		else {
			System.out.println("No transactions made.");
		}
	}

	public void calculateInterest() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Interest Rate: ");
		String interestRate = br.readLine();
		Float finalRate = Float.parseFloat(interestRate);
		System.out.print("Years of interest: ");
		String interestYears = br.readLine();
		Float finalYears = Float.parseFloat(interestYears);

		Float interestCost = balance + balance * finalRate * finalYears;
		System.out.println("After " + interestYears + " years, your balance will be: " + interestCost);

	}

	public void exit() {
		System.out.println("Exiting.......");
		System.exit(0);
	}
}
