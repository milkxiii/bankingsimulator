import java.io.IOException;
import java.util.ArrayList;

public class CustomerService {

	PersistenceManager pm = new PersistenceManager();
	
	public int signUpCustomer(Customer cust, String nameInput, String dobInput, int accTypeValue) {
		cust.setName(nameInput);
		cust.setDateOfBirth(dobInput);		
		System.out.println("Account Type: " + accTypeValue);

		//create account from Customer
		int id = cust.randomizeID();
		String registerTime = cust.getTimestamp();
		try {
			cust.createCustomer(id, nameInput, accTypeValue, 0, dobInput, registerTime);//
			pm.saveCustomer(cust);
			pm.saveAccount(cust.m_account);
			System.out.println(cust.getID());
			System.out.println(cust.m_account.getAccountID());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;

	}

	public boolean logInCustomer(Customer cust, int idInput) {
		boolean userValid = pm.searchCustomer(idInput);
		if (userValid == true) {
			System.out.println("Valid ID " + idInput);
			cust.setID(idInput);
			cust.setName(pm.getCustName());
			cust.setDateOfBirth(pm.getCustDOB());
			cust.setRegTime(pm.getCustRegTime());
			userValid = true;

		}
		else if (userValid == false) {
			System.out.println("Invalid ID " + idInput);
		}
		return userValid;
	}
	
	public ArrayList<Customer> viewCustomers() {
		ArrayList<Customer> customerList = pm.viewCustomerList();
		return customerList;
	}
}
