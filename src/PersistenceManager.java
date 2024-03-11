import java.sql.*;
import java.util.ArrayList;

public class PersistenceManager {

	String custName, custDOB, custRegTime;
	int custID;
	
	String connectionUrl =
			"jdbc:sqlserver://localhost:1433;"
					+ "database={your_database};"
					+ "user=sa;"
					+ "password={your_password};";
	
	public void saveCustomer(Customer cust) {
		try (Connection conn = DriverManager.getConnection(connectionUrl);) {
			PreparedStatement prep2 = conn.prepareStatement(
					"insert into " +
							"CUSTOMER(CUSTOMERID, CUSTOMERNAME, CUSTOMERDOB, REGISTERTIME)" +
					"values(?, ?, ?, ?)");
			prep2.setInt(1, cust.getID());
			prep2.setString(2, cust.getName());
			prep2.setString(3, cust.getDateOfBirth());
			prep2.setString(4, cust.getRegTime());
			prep2.executeUpdate();
			prep2.close();
			conn.close();
		} catch (SQLException sqe) {
			System.out.println("Customer SQL Error: " + sqe.getMessage());

		}
	}

	public void saveAccount(Account acc) {

		try (Connection conn = DriverManager.getConnection(connectionUrl);) {
			PreparedStatement prep2 = conn.prepareStatement(
					"insert into " +
					"ACCOUNT(ACCOUNTID, CATEGORY, BALANCE, TRANSACTIONS)" +
					"values(?, ?, ?, ?)");
			System.out.println("1 - ID         " + acc.getAccountID());
			System.out.println("2 - Category   " + acc.getCategory());
			System.out.println("3 - Balance    " + acc.getBalance());
			prep2.setInt(1, acc.getAccountID());
			prep2.setInt(2, acc.getCategory());
			prep2.setFloat(3, acc.getBalance());
			prep2.setString(4, null);
			prep2.executeUpdate();
			prep2.close();
			conn.close();
		} catch (SQLException sqe) {
			System.out.println("Account SQL Error: " + sqe.getMessage());

		}
	}

	public void updateAccBalance(float balanceDifference, int idInput) {
		System.out.println(idInput);
		float newBal = balanceDifference + fetchAccBal(idInput);
		
		try (Connection conn = DriverManager.getConnection(connectionUrl);) {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			PreparedStatement prep2 = conn.prepareStatement(
					"UPDATE ACCOUNT " +
					"SET BALANCE = " + + newBal +
					"WHERE ACCOUNTID = " + idInput);
			prep2.execute();
		} catch (SQLException sqe) {
			System.out.println("Account SQL Error: " + sqe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

	}

	public boolean searchCustomer(int inputID) {
		boolean verifyCustomer = false;
		try (Connection conn = DriverManager.getConnection(connectionUrl);) {
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery(
					"select CUSTOMERID, CUSTOMERNAME, CUSTOMERDOB, REGISTERTIME " +
					"from CUSTOMER");

			while (rec.next()) {
				if (inputID == rec.getInt(1)){
					setCustName(rec.getString(2));
					setCustDOB(rec.getString(3));
					setCustRegTime(rec.getString(4));
					verifyCustomer = true;
				}
			}
			rec.close();
		} catch (SQLException s) {
			System.out.println("SQL Error: " + s.toString() + " "
					+ s.getErrorCode() + " " + s.getSQLState());
		} catch (Exception e) {
			System.out.println("Error: " + e.toString()
			+ e.getMessage());
		}
		return verifyCustomer;
	}

	public int fetchAccBal(int inputID) {
		int currentBal = 0;
		try (Connection conn = DriverManager.getConnection(connectionUrl);) {
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery(
					"select ACCOUNTID, BALANCE " +
					"from ACCOUNT");

			while (rec.next()) {
				if (inputID == rec.getInt(1)){
					currentBal = rec.getInt(2);
				}
			}
			rec.close();
		} catch (SQLException s) {
			System.out.println("SQL Error: " + s.toString() + " "
					+ s.getErrorCode() + " " + s.getSQLState());
		} catch (Exception e) {
			System.out.println("Error: " + e.toString()
			+ e.getMessage());
		}
		return currentBal;
	}

	public ArrayList<Customer> viewCustomerList() {	
		ArrayList<Customer> customerList= new ArrayList<Customer>();

		try (Connection conn = DriverManager.getConnection(connectionUrl);) {
			Statement st = conn.createStatement();
			ResultSet rec = st.executeQuery(
					"select CUSTOMERID, CUSTOMERNAME, CUSTOMERDOB, REGISTERTIME " +
					"from CUSTOMER ");

			while (rec.next()) {
				Customer cust = new Customer();
				setCustID(rec.getInt(1));
				setCustName(rec.getString(2));
				setCustDOB(rec.getString(3));
				setCustRegTime(rec.getString(4));

				cust.setID(getCustID());
				cust.setName(getCustName());
				cust.setDateOfBirth(getCustDOB());
				cust.setRegTime(getCustRegTime());
				customerList.add(cust);
			}
			rec.close();
		} catch (SQLException s) {
			System.out.println("SQL Error: " + s.toString() + " "
					+ s.getErrorCode() + " " + s.getSQLState());
		} catch (Exception e) {
			System.out.println("Error: " + e.toString()
			+ e.getMessage());
		}
		return customerList;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(String custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustRegTime() {
		return custRegTime;
	}

	public void setCustRegTime(String custRegTime) {
		this.custRegTime = custRegTime;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
}

