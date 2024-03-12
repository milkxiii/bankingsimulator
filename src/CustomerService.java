import java.io.IOException;
import java.util.ArrayList;

public class CustomerService {

	PersistenceManager pm = new PersistenceManager();
	
	public int signUpCustomer(Customer cust, String nameInput, String dobInput, int accTypeValue) {
		cust.setName(nameInput);
		cust.setDateOfBirth(dobInput);		

		//create account from Customer
		int id = cust.randomizeID();
		String registerTime = cust.getTimestamp();
		try {
			cust.createCustomer(id, nameInput, accTypeValue, 0, dobInput, registerTime);//
			pm.saveCustomer(cust);
			pm.saveAccount(cust.account);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;

	}

	public boolean searchCustomer(Customer cust, int idInput) {
		boolean userValid = pm.searchCustomer(idInput);
		if (userValid == true) {
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
