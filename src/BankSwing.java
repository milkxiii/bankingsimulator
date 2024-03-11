import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BankSwing extends JFrame implements ActionListener {
	CustomerService cs = new CustomerService();
	Customer cust = new Customer();
	JPanel panel;
	JButton goToLogIn, goToSignUpOne, goToViewCustomers, goToStart, goToSignUpTwo, goToSignUpThree, accOptionsOkButton, 
	goToDepositTwo, logInOkButton, goToAccountOptions, goToWithdrawTwo;
	JLabel customerNameLabel, customerDOBLabel, depositAmountLabel, customerIDLabel, displayNameID, displayCustNameLabel, displayCustDOBLabel, 
	displayCustRegTimeLabel, withdrawAmountLabel;
	JTextField customerName, customerDOB, depositAmount, customerID, displayCustName, displayCustDOB, displayCustRegTime, withdrawAmount;
	JRadioButton standardAccButton, vipAccButton, childAccButton, checkBalance, makeDeposit, makeWithdrawal, calcInterest, 
	prevTransaction, accInfo;
	ButtonGroup accTypeGroup, optionsGroup;
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public BankSwing() {
		super("Bank App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 400);
		panel = new JPanel();
	}

	public void startPage() {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
		panel.setLayout(null);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("spongebob.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setBounds(130, 40, 150, 105);
			panel.add(picLabel);

		} catch (IOException e) {
			System.out.println("no");
		}
	    
		goToLogIn = new JButton("Log In");
		goToSignUpOne= new JButton("Sign Up");
		goToViewCustomers = new JButton("View Customers");
		goToLogIn.setBounds(100, 150, 200, 50);
		goToSignUpOne.setBounds(100, 200, 200, 50);
		goToViewCustomers.setBounds(100, 250, 200, 50);
		goToLogIn.addActionListener(this);
		goToSignUpOne.addActionListener(this);
		goToViewCustomers.addActionListener(this);

		panel.add(goToLogIn);
		panel.add(goToSignUpOne);
		panel.add(goToViewCustomers);
		add(panel);
		setVisible(true);
	}

	public void showSignUpOne() {
		super.setTitle("Bank Account: Sign up");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints nameC = new GridBagConstraints();
		GridBagConstraints dobC = new GridBagConstraints();
		GridBagConstraints cancelC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		nameC.gridy = 150;
		dobC.gridy = 200;
		okC.gridy = 250;
		cancelC.gridy = 250;
		nameC.anchor = GridBagConstraints.LINE_START;
		dobC.anchor = GridBagConstraints.LINE_START;
		cancelC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		customerNameLabel = new JLabel("Name: ");
		customerDOBLabel = new JLabel("DOB: ");
		customerName = new JTextField(25);
		customerDOB = new JTextField(25);
		goToStart = new JButton("Cancel");
		goToSignUpTwo = new JButton("Ok");
		goToStart.addActionListener(this);
		goToSignUpTwo.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(customerNameLabel, nameC);
		panel.add(customerName, nameC);
		panel.add(customerDOBLabel, dobC);
		panel.add(customerDOB, dobC);
		panel.add(goToStart, cancelC);
		panel.add(goToSignUpTwo, okC);
		add(panel);
		setVisible(true);
	}

	public void showSignUpTwo() {
		super.setTitle("Bank Account: Sign up");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints standardC = new GridBagConstraints();
		GridBagConstraints vipC = new GridBagConstraints();
		GridBagConstraints childC = new GridBagConstraints();
		GridBagConstraints backC = new GridBagConstraints();
		GridBagConstraints finishC = new GridBagConstraints();

		accTypeGroup = new ButtonGroup();

		standardC.gridy = 150;
		vipC.gridy = 200;
		childC.gridy = 250;
		backC.gridy = 300;
		finishC.gridy = 300;
		standardC.anchor = GridBagConstraints.LINE_START;
		vipC.anchor = GridBagConstraints.LINE_START;
		childC.anchor = GridBagConstraints.LINE_START;
		backC.anchor = GridBagConstraints.CENTER;
		finishC.anchor = GridBagConstraints.CENTER;

		standardAccButton = new JRadioButton("Standard Account");
		vipAccButton = new JRadioButton("VIP Account");
		childAccButton = new JRadioButton("Child Account");
		goToSignUpOne = new JButton("Back");
		goToSignUpThree = new JButton("Finish");

		accTypeGroup.add(standardAccButton);
		accTypeGroup.add(vipAccButton);
		accTypeGroup.add(childAccButton);

		goToSignUpThree.addActionListener(this);
		goToSignUpOne.addActionListener(this);		

		panel.setLayout(gbl);
		panel.add(standardAccButton, standardC);
		panel.add(vipAccButton, vipC);
		panel.add(childAccButton, childC);
		panel.add(goToSignUpOne, backC);
		panel.add(goToSignUpThree, finishC);
		add(panel);
		setVisible(true);

	}

	public void showSignUpThree(int id) {
		super.setTitle("Bank Account: Sign up");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints successC = new GridBagConstraints();
		GridBagConstraints idC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		successC.gridy = 150;
		idC.gridy = 200;
		okC.gridy = 250;
		successC.anchor = GridBagConstraints.CENTER;
		idC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel("Successfully created account!");
		JLabel idLabel = new JLabel("User ID: " + id);
		goToStart = new JButton("Ok");
		goToStart.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(successLabel, successC);
		panel.add(idLabel, idC);
		panel.add(goToStart, okC);
		add(panel);
		setVisible(true);

	}

	public void showLogIn() {
		super.setTitle("Bank Account: Log in");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints idC = new GridBagConstraints();
		GridBagConstraints cancelC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		idC.gridy = 200;
		okC.gridy = 250;
		cancelC.gridy = 250;
		idC.anchor = GridBagConstraints.LINE_START;
		okC.anchor = GridBagConstraints.CENTER;
		cancelC.anchor = GridBagConstraints.LINE_START;

		customerIDLabel = new JLabel("ID: ");
		customerID = new JTextField(10);
		logInOkButton = new JButton("Ok");
		logInOkButton.addActionListener(this);
		goToStart = new JButton("Back");
		goToStart.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(customerIDLabel, idC);
		panel.add(customerID, idC);
		panel.add(goToStart, okC);
		panel.add(logInOkButton, okC);
		add(panel);
		setVisible(true);
	}

	public void showAccountOptions(Customer cust) {		
		super.setTitle("Bank Account Options");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();

		GridBagConstraints displayNameIDC = new GridBagConstraints();
		GridBagConstraints checkBalanceC = new GridBagConstraints();
		GridBagConstraints makeDepositC = new GridBagConstraints();
		GridBagConstraints makeWithdrawalC = new GridBagConstraints();
		GridBagConstraints calcInterestC = new GridBagConstraints();
		GridBagConstraints prevTransactionC = new GridBagConstraints();
		GridBagConstraints accInfoC = new GridBagConstraints();
		GridBagConstraints signOutC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		displayNameIDC.gridy = 20;
		checkBalanceC.gridy = 100;
		makeDepositC.gridy = 125;
		makeWithdrawalC.gridy = 150;
		calcInterestC.gridy = 175;
		prevTransactionC.gridy = 200;
		accInfoC.gridy = 225;
		signOutC.gridy = 275;
		okC.gridy = 250;
		signOutC.gridx = 250;
		displayNameIDC.anchor = GridBagConstraints.LINE_START;
		checkBalanceC.anchor = GridBagConstraints.LINE_START;
		makeDepositC.anchor = GridBagConstraints.LINE_START;
		makeWithdrawalC.anchor = GridBagConstraints.LINE_START;
		calcInterestC.anchor = GridBagConstraints.LINE_START;
		prevTransactionC.anchor = GridBagConstraints.LINE_START;
		accInfoC.anchor = GridBagConstraints.LINE_START;
		signOutC.anchor = GridBagConstraints.LINE_END;
		okC.anchor = GridBagConstraints.CENTER;

		optionsGroup = new ButtonGroup();

		displayNameID = new JLabel(cust.getName() + " " + Integer.toString(cust.getID()));
		checkBalance = new JRadioButton("Check Balance");
		makeDeposit = new JRadioButton("Deposit");
		makeWithdrawal = new JRadioButton("Withdraw");
		calcInterest = new JRadioButton("Interest");
		prevTransaction = new JRadioButton("Previous Transaction");
		accInfo = new JRadioButton("Account Info");
		goToStart = new JButton("Sign out");
		accOptionsOkButton = new JButton("Ok");

		//add options to the optionsGroup and display on GUI using a loop
		JRadioButton[] optionsList = new JRadioButton[] {checkBalance, 
				makeDeposit, makeWithdrawal, calcInterest, prevTransaction, accInfo};

		for (JRadioButton option : optionsList) {
			optionsGroup.add(option);
		}

		panel.setLayout(gbl);
		panel.add(displayNameID, displayNameIDC);
		panel.add(checkBalance, checkBalanceC);
		panel.add(makeDeposit, makeDepositC);
		panel.add(makeWithdrawal, makeWithdrawalC);
		panel.add(calcInterest, calcInterestC);
		panel.add(prevTransaction, prevTransactionC);
		panel.add(accInfo, accInfoC);
		panel.add(goToStart, signOutC);
		panel.add(accOptionsOkButton, okC);
		goToStart.addActionListener(this);
		accOptionsOkButton.addActionListener(this);

		add(panel);
		setVisible(true);
	}

	public void showCustomerDetails(Customer cust) {
		super.setTitle("Customer Details");

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints displayCustNameC = new GridBagConstraints();
		GridBagConstraints displayCustDOBC = new GridBagConstraints();
		GridBagConstraints displayCustRegTimeC = new GridBagConstraints();
		GridBagConstraints displayCustNameLabelC = new GridBagConstraints();
		GridBagConstraints displayCustDOBLabelC = new GridBagConstraints();
		GridBagConstraints displayCustRegTimeLabelC = new GridBagConstraints();
		GridBagConstraints custDetailBackButtonC = new GridBagConstraints();
		GridBagConstraints proceedButtonC = new GridBagConstraints();

		displayCustNameC.gridy = 150;
		displayCustDOBC.gridy = 200;
		displayCustRegTimeC.gridy = 250;
		displayCustNameLabelC.gridy = 150;
		displayCustDOBLabelC.gridy = 200;
		displayCustRegTimeLabelC.gridy = 250;
		custDetailBackButtonC.gridy = 300;
		proceedButtonC.gridy = 300;
		displayCustNameC.anchor = GridBagConstraints.LINE_START;
		displayCustDOBC.anchor = GridBagConstraints.LINE_START;
		displayCustRegTimeC.anchor = GridBagConstraints.LINE_START;
		custDetailBackButtonC.anchor = GridBagConstraints.LINE_START;
		proceedButtonC.anchor = GridBagConstraints.LINE_END;

		displayCustNameLabel = new JLabel("Name: ");
		displayCustDOBLabel = new JLabel("DOB: ");
		displayCustRegTimeLabel = new JLabel("Register Timestamp: ");
		displayCustName = new JTextField(cust.getName(), 20);
		displayCustDOB = new JTextField(cust.getDateOfBirth(), 20);
		displayCustRegTime = new JTextField(cust.getRegTime(), 20);
		goToLogIn = new JButton("Back");
		goToAccountOptions = new JButton("Proceed to Activities");
		goToLogIn.addActionListener(this);
		goToAccountOptions.addActionListener(this);

		displayCustName.setEditable(false);
		displayCustDOB.setEditable(false);
		displayCustRegTime.setEditable(false);

		panel.setLayout(gbl);
		panel.add(displayCustNameLabel, displayCustNameLabelC);
		panel.add(displayCustDOBLabel, displayCustDOBLabelC);
		panel.add(displayCustRegTimeLabel, displayCustRegTimeLabelC);
		panel.add(displayCustName, displayCustNameC);
		panel.add(displayCustDOB, displayCustDOBC);
		panel.add(displayCustRegTime, displayCustRegTimeC);
		panel.add(goToLogIn, custDetailBackButtonC);
		panel.add(goToAccountOptions, proceedButtonC);

		add(panel);
		setVisible(true);
	}

	public void showDepositOne() {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints amountLabelC = new GridBagConstraints();
		GridBagConstraints amountC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		amountLabelC.gridy = 150;
		amountC.gridy = 200;
		okC.gridy = 250;
		amountLabelC.anchor = GridBagConstraints.LINE_START;
		amountC.anchor = GridBagConstraints.LINE_START;
		okC.anchor = GridBagConstraints.CENTER;

		depositAmountLabel = new JLabel("Amount to Deposit: ");
		depositAmount = new JTextField(6);
		goToDepositTwo = new JButton("Ok");
		goToDepositTwo.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(depositAmountLabel, amountLabelC);
		panel.add(depositAmount, amountC);
		panel.add(goToDepositTwo, okC);
		add(panel);
		setVisible(true);
	}

	public void showDepositTwo(float depositAmount, float bal) {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints successC = new GridBagConstraints();
		GridBagConstraints balanceC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		successC.gridy = 150;
		balanceC.gridy = 200;
		okC.gridy = 250;
		successC.anchor = GridBagConstraints.CENTER;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel("Successfully deposited $" + depositAmount);
		JLabel idLabel = new JLabel("Current balance: $" + bal);
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(successLabel, successC);
		panel.add(idLabel, balanceC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}

	public void showWithdrawalOne() {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints amountLabelC = new GridBagConstraints();
		GridBagConstraints amountC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		amountLabelC.gridy = 150;
		amountC.gridy = 200;
		okC.gridy = 250;
		amountLabelC.anchor = GridBagConstraints.LINE_START;
		amountC.anchor = GridBagConstraints.LINE_START;
		okC.anchor = GridBagConstraints.CENTER;

		withdrawAmountLabel = new JLabel("Amount to Withdraw: ");
		withdrawAmount = new JTextField(6);
		goToWithdrawTwo = new JButton("Ok");
		goToWithdrawTwo.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(withdrawAmountLabel, amountLabelC);
		panel.add(withdrawAmount, amountC);
		panel.add(goToWithdrawTwo, okC);
		add(panel);
		setVisible(true);
	}

	public void showWithdrawalTwo(float withdrawAmount, float bal) {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints successC = new GridBagConstraints();
		GridBagConstraints balanceC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		successC.gridy = 150;
		balanceC.gridy = 200;
		okC.gridy = 250;
		successC.anchor = GridBagConstraints.CENTER;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel("Successfully withdrew $" + withdrawAmount);
		JLabel idLabel = new JLabel("Current balance: $" + bal);
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(successLabel, successC);
		panel.add(idLabel, balanceC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}

	public void showBalance(Customer cust) {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints balanceC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		balanceC.gridy = 200;
		okC.gridy = 250;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel balanceLabel = new JLabel("Current balance: $" + cust.getBalance());
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		panel.setLayout(gbl);
		panel.add(balanceLabel, balanceC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}

	public void viewCustomers(ArrayList<Customer> customerList) {
		//		JScrollPane scrollPane = new JScrollPane();
		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints customerTableC = new GridBagConstraints();
		GridBagConstraints backButtonC = new GridBagConstraints();

		customerTableC.gridy = 150;
		backButtonC.gridy = 200;
		customerTableC.anchor = GridBagConstraints.LINE_START;
		backButtonC.anchor = GridBagConstraints.LINE_START;

		String[] columnNames = {"Customer ID", "Customer Name"};
		int customerCount = customerList.size();
		String[][] data = new String[customerCount][customerCount];
		
		int row = 0;
		
		for(Customer cust : customerList) {
			int custID = cust.getID();
			String strCustID = String.valueOf(custID);
			String strCustName = cust.getName();
			data[row][0] = strCustID;
			data[row][1] = strCustName;
			row++;
		}
		

		goToStart = new JButton("Back");
		goToStart.addActionListener(this);
		JTable customerTable = new JTable(data, columnNames);
		panel.setLayout(gbl);
		panel.add(goToStart, backButtonC);
		panel.add(customerTable, customerTableC);
		add(panel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();

		if (source == goToStart) {
			startPage();
		}

		else if (source == goToViewCustomers) {
			System.out.println("viewing customers");
			ArrayList<Customer> customerList = cs.viewCustomers();
			viewCustomers(customerList);
		}

		else if (source == goToSignUpOne) {
			showSignUpOne();
		}

		else if (source == goToSignUpTwo) {
			showSignUpTwo();
		}

		else if (source == goToSignUpThree) {
			String nameInput = customerName.getText();
			String dobInput = customerDOB.getText();

			if (dobInput.length() == 8) {

				int accTypeValue = 0;
				if (standardAccButton.isSelected()) {
					accTypeValue = 1;
				}
				else if (vipAccButton.isSelected()) {
					accTypeValue = 2;
				}
				else if (childAccButton.isSelected()) {
					accTypeValue = 3;
				}

				int id = cs.signUpCustomer(cust, nameInput, dobInput, accTypeValue);
				showSignUpThree(id);
			}
		}

		else if (source == goToLogIn) {
			showLogIn();
		}		

		else if (source == logInOkButton) {
			try {
				int idInput = Integer.parseInt(customerID.getText());
				boolean userValid = cs.logInCustomer(cust, idInput);
				if(userValid) {
					showCustomerDetails(cust);
				}	
			}
			catch(NumberFormatException nfe) {
				System.out.println("Invalid input value (out of bounds)");
			}
			catch(Exception e) {
				System.out.println("Couldn't log in.");
			}
		}

		else if (source == goToAccountOptions) {
			showAccountOptions(cust);
		}

		else if (source == accOptionsOkButton) {
			if (makeDeposit.isSelected()) {
				showDepositOne();
			}
			if(makeWithdrawal.isSelected()) {
				showWithdrawalOne();
			}
			if (checkBalance.isSelected()) {
				showBalance(cust);
			}
		}

		else if (source == goToDepositTwo) {
			try {
				String strDep = depositAmount.getText();
				float intDep = Float.parseFloat(strDep);
				cust.m_account.makeTransaction(cust, intDep);
				float bal = cust.getBalance();
				showDepositTwo(intDep, bal);
			}

			catch (NumberFormatException e) {

			}
		}

		else if (source == goToWithdrawTwo) {
			try {
				String strWithdraw = withdrawAmount.getText();
				float intWithdraw = Float.parseFloat(strWithdraw);
				cust.m_account.makeTransaction(cust, intWithdraw * (-1));
				float bal = cust.getBalance();
				showWithdrawalTwo(intWithdraw, bal);
			}
			catch (NumberFormatException e) {

			}

		}
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
					);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception exc) {
			System.err.println("Couldn't use the system "
					+ "look and feel: " + exc);
		}
	}

	public static void main(String[] args) {
		BankSwing bankSwing = new BankSwing();
		CustomerService cs = new CustomerService();
		bankSwing.startPage();
		//		ArrayList<Customer> customerList = cs.viewCustomers();
		//		bank_swing.viewCustomers(customerList);
	}
}
