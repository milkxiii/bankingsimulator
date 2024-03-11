import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Customer {

	Account m_account = new Account();// add getter and setting PROBABALLY
	int id = 0;
	String dateOfBirth;
	String name = null;
	float balance = 0;
	String registerTime = null;
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public Customer() {
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getBalance() {
		System.out.println("ID: " + this.getID());
		return this.m_account.getBalance(this.getID());
	}

	public void setRegTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegTime() {
		return this.registerTime;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public void createCustomer(int id, String name, int category, int balance, String dateOfBirth, String registerTime) throws IOException {
		this.setID(id);
		this.setName(name);
		this.setRegTime(registerTime);
		this.setDateOfBirth(dateOfBirth);

		this.m_account.setAccountID(id);
		this.m_account.setCategory(category);
		this.m_account.setBalance(0);

//		cust.m_account.deposit(cust);
		// 1. go to sub menu to enter customer name, DOB, category

		// 2. create a customer with the values from the above
	}

	int randomizeID() {
		Random random = new Random();
		String num = "";
		for(int i = 0; i <= 8; i++) {
			int randomDigit = random.nextInt(9);
			num = num + Integer.toString(randomDigit);
		}
		int id = Integer.parseInt(num);
		return id;
	}
	
	String getTimestamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String registerTime = dtf.format(now).toString(); 
		return registerTime;
	}
	
	// return 0 = good, 1 = bad 
	int validateDate(String strDate) {
		// tokenize strDate into YYYY, MM, DD
		// validate if day is valid
		// validate if month is valid
		// validate if year is valid
		String string = strDate;
		String[] tokenizer = string.split("-");
		String year = tokenizer[0];
		String month = tokenizer[1]; 
		String day = tokenizer[2];
		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);
		int intDay = Integer.parseInt(day);

		int returnValue;

		switch(intMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
		case 11:
			if (intDay < 1 || intDay > 31) {
				returnValue = 1;
				return returnValue;
			}
			break;
		case 4:
		case 6:
		case 8:
		case 10:
		case 12:
			if (intDay < 1 || intDay > 30) {
				returnValue = 1;
				return returnValue;
			}
			break;
		case 2:
			if (intYear%4 == 0) { //leap year
				if (intDay < 1 || intDay > 29) {
					returnValue = 2;
					return returnValue;
				}
			}
			else {
				if (intDay < 1 || intDay > 28) { //non leap year
					returnValue = 2;
					return returnValue;
				}
			}
			break;
		default:
			returnValue = 3;
			return returnValue;

		}

		if(intYear > 3000 || intYear < 1900) {
			returnValue = 4;
			return returnValue;
		}
		else {
			returnValue = 0;
			return returnValue;
		}
		
	}

	boolean isDateValid(String strDate) {
		boolean validDate = false;

			int ret = validateDate(strDate);
			switch(ret) {			
				case 1:
					System.out.println("Invalid day, please re-enter.");
					break;
				case 2:
					System.out.println("Invalid day (leap year), please re-enter");
					break;
				case 3:
					System.out.println("Invalid month, please re-enter.");
					break;
				case 4:
					System.out.println("Invalid year, please re-enter.");
					break;
				default:
					validDate = true;
			}
		return validDate;
	}
}
