import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Customer {

	Account account = new Account();// add getter and setting PROBABALLY
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
		return this.account.getBalance(this.getID());
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

		this.account.setAccountID(id);
		this.account.setCategory(category);
		this.account.setBalance(0);

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

	public static boolean validateDate(String strDate) {		
		try {
			String[] tokenizer = strDate.split("-");
			String year = tokenizer[0];
			String month = tokenizer[1]; 
			String day = tokenizer[2];
			
			if (year.length()!= 4 || month.length() != 2 || day.length() != 2) {
				return false;
			}
			
			int intYear = Integer.parseInt(year);
			int intMonth = Integer.parseInt(month);
			int intDay = Integer.parseInt(day);
	
			switch(intMonth) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 9:
				case 11:
					if (intDay < 1 || intDay > 31) {
						return false;
					}
				case 4:
				case 6:
				case 8:
				case 10:
				case 12:
					if (intDay < 1 || intDay > 30) {
						return false;
					}
				case 2:
					if (intYear%4 == 0) { //leap year
						if (intDay < 1 || intDay > 29) {
							return false;
		
						}
					}
					else {
						if (intDay < 1 || intDay > 28) { //non leap year
							return false;
						}
					}
					break;
			}
			
			if(intYear > 3000 || intYear < 1900) {
				return false;
			}
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}

	}

}
