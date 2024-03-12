import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class BankSwing extends JFrame implements ActionListener {
	CustomerService cs = new CustomerService();
	Customer cust = new Customer();
	JPanel panel;
	JButton goToLogIn, goToSignUpOne, goToViewCustomers, goToStart, goToSignUpTwo, goToSignUpThree, accOptionsOkButton, 
	goToDepositTwo, logInOkButton, goToAccountOptions, goToWithdrawTwo, goToInterestTwo;
	JLabel customerNameLabel, customerDOBLabel, depositAmountLabel, customerIDLabel, displayNameID, displayCustNameLabel, displayCustDOBLabel, 
	displayCustRegTimeLabel, withdrawAmountLabel, rateLabel, yearsLabel;
	JTextField customerName, customerDOB, depositAmount, customerID, displayCustName, displayCustDOB, displayCustRegTime, withdrawAmount, rate, years;
	JRadioButton standardAccButton, vipAccButton, childAccButton, checkBalance, makeDeposit, makeWithdrawal, calcInterest, 
	prevTransaction, accInfo;
	ButtonGroup accTypeGroup, optionsGroup;

	int scale = 3;
	
	public BankSwing() {
		super("Bank App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(scale*400, scale*330);
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
			picLabel.setBounds(scale*130, scale*40, scale*150, scale*105);
			panel.add(picLabel);

		} catch (IOException e) {
			System.out.println("no");
		}

		goToLogIn = new JButton("Log In");
		goToSignUpOne= new JButton("Sign Up");
		goToViewCustomers = new JButton("View Customers");
		goToLogIn.setBounds(scale*100, scale*150, scale*200, scale*50);
		goToSignUpOne.setBounds(scale*100, scale*200, scale*200, scale*50);
		goToViewCustomers.setBounds(scale*100, scale*250, scale*200, scale*50);
		goToLogIn.addActionListener(this);
		goToSignUpOne.addActionListener(this);
		goToViewCustomers.addActionListener(this);
		
		goToLogIn.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToSignUpOne.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToViewCustomers.setFont(new Font("Verdana", Font.PLAIN, 24));
		

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
		
		customerNameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerDOBLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerName.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerDOB.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToStart.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToSignUpTwo.setFont(new Font("Verdana", Font.PLAIN, 24));

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

		standardC.gridy = scale*150;
		vipC.gridy = scale*200;
		childC.gridy = scale*250;
		backC.gridy = scale*300;
		finishC.gridy = scale*300;
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
		
		standardAccButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		vipAccButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		childAccButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToSignUpOne.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToSignUpThree.setFont(new Font("Verdana", Font.PLAIN, 24));

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

		successC.gridy = scale*150;
		idC.gridy = scale*200;
		okC.gridy = scale*250;
		successC.anchor = GridBagConstraints.CENTER;
		idC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel("Successfully created account!");
		JLabel idLabel = new JLabel("User ID: " + id);
		goToStart = new JButton("Ok");
		goToStart.addActionListener(this);
		
		goToStart.setFont(new Font("Verdana", Font.PLAIN, 24));
		successLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		idLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		
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

		idC.gridy = scale*200;
		okC.gridy = scale*250;
		cancelC.gridy = scale*250;
		idC.anchor = GridBagConstraints.LINE_START;
		okC.anchor = GridBagConstraints.CENTER;
		cancelC.anchor = GridBagConstraints.LINE_START;

		customerIDLabel = new JLabel("ID: ");
		customerID = new JTextField(10);
		logInOkButton = new JButton("Ok");
		logInOkButton.addActionListener(this);
		goToStart = new JButton("Back");
		goToStart.addActionListener(this);

		customerIDLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerID.setFont(new Font("Verdana", Font.PLAIN, 24));
		logInOkButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToStart.setFont(new Font("Verdana", Font.PLAIN, 24));
		
		panel.setLayout(gbl);
		panel.add(customerIDLabel, idC);
		panel.add(customerID, idC);
		panel.add(goToStart, okC);
		panel.add(logInOkButton, okC);
		add(panel);
		setVisible(true);
	}

	public void showAccountOptions(String name, int id) {		
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

		displayNameIDC.gridy = scale*20;
		checkBalanceC.gridy = scale*100;
		makeDepositC.gridy = scale*125;
		makeWithdrawalC.gridy = scale*150;
		calcInterestC.gridy = scale*175;
		prevTransactionC.gridy = scale*200;
		accInfoC.gridy = scale*225;
		signOutC.gridy = scale*275;
		okC.gridy = scale*250;
		signOutC.gridx = scale*250;
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

		displayNameID = new JLabel(name + " " + Integer.toString(id));
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

		displayNameID.setFont(new Font("Verdana", Font.PLAIN, 24));
		checkBalance.setFont(new Font("Verdana", Font.PLAIN, 24));
		makeDeposit.setFont(new Font("Verdana", Font.PLAIN, 24));
		makeWithdrawal.setFont(new Font("Verdana", Font.PLAIN, 24));
		calcInterest.setFont(new Font("Verdana", Font.PLAIN, 24));
		prevTransaction.setFont(new Font("Verdana", Font.PLAIN, 24));
		accInfo.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToStart.setFont(new Font("Verdana", Font.PLAIN, 24));
		accOptionsOkButton.setFont(new Font("Verdana", Font.PLAIN, 24));

		add(panel);
		setVisible(true);
	}

	public void showCustomerDetails(String name, String dob, String regTime) {
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

		displayCustNameC.gridy = scale*150;
		displayCustDOBC.gridy = scale*200;
		displayCustRegTimeC.gridy = scale*250;
		displayCustNameLabelC.gridy = scale*150;
		displayCustDOBLabelC.gridy = scale*200;
		displayCustRegTimeLabelC.gridy = scale*250;
		custDetailBackButtonC.gridy = scale*300;
		proceedButtonC.gridy = scale*300;
		displayCustNameC.anchor = GridBagConstraints.LINE_START;
		displayCustDOBC.anchor = GridBagConstraints.LINE_START;
		displayCustRegTimeC.anchor = GridBagConstraints.LINE_START;
		custDetailBackButtonC.anchor = GridBagConstraints.LINE_START;
		displayCustNameLabelC.anchor = GridBagConstraints.LINE_START;
		displayCustDOBLabelC.anchor = GridBagConstraints.LINE_START;
		displayCustRegTimeLabelC.anchor = GridBagConstraints.LINE_START;
		proceedButtonC.anchor = GridBagConstraints.LINE_END;

		displayCustNameLabel = new JLabel("Name: ");
		displayCustDOBLabel = new JLabel("DOB: ");
		displayCustRegTimeLabel = new JLabel("Register Timestamp: ");
		displayCustName = new JTextField(name, 20);
		displayCustDOB = new JTextField(dob, 20);
		displayCustRegTime = new JTextField(regTime, 20);
		goToLogIn = new JButton("Back");
		goToAccountOptions = new JButton("Proceed to Activities");
		goToLogIn.addActionListener(this);
		goToAccountOptions.addActionListener(this);

		displayCustName.setEditable(false);
		displayCustDOB.setEditable(false);
		displayCustRegTime.setEditable(false);

		displayCustNameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustDOBLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustRegTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustName.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustDOB.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustRegTime.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToLogIn.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

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

	public void showAccountInfo(String name, String dob, String regTime) {
		super.setTitle("Account Info");

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
		GridBagConstraints proceedButtonC = new GridBagConstraints();

		displayCustNameC.gridy = scale*150;
		displayCustDOBC.gridy = scale*200;
		displayCustRegTimeC.gridy = scale*250;
		displayCustNameLabelC.gridy = scale*150;
		displayCustDOBLabelC.gridy = scale*200;
		displayCustRegTimeLabelC.gridy = scale*250;
		proceedButtonC.gridy = scale*300;
		displayCustNameC.anchor = GridBagConstraints.LINE_START;
		displayCustDOBC.anchor = GridBagConstraints.LINE_START;
		displayCustNameLabelC.anchor = GridBagConstraints.LINE_START;
		displayCustDOBLabelC.anchor = GridBagConstraints.LINE_START;
		displayCustRegTimeLabelC.anchor = GridBagConstraints.LINE_START;
		proceedButtonC.anchor = GridBagConstraints.LINE_END;

		displayCustNameLabel = new JLabel("Name: ");
		displayCustDOBLabel = new JLabel("DOB: ");
		displayCustRegTimeLabel = new JLabel("Register Timestamp: ");
		displayCustName = new JTextField(name, 20);
		displayCustDOB = new JTextField(dob, 20);
		displayCustRegTime = new JTextField(regTime, 20);
		goToAccountOptions = new JButton("Ok");
		goToLogIn.addActionListener(this);
		goToAccountOptions.addActionListener(this);

		displayCustName.setEditable(false);
		displayCustDOB.setEditable(false);
		displayCustRegTime.setEditable(false);
		
		displayCustNameLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustDOBLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustRegTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustName.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustDOB.setFont(new Font("Verdana", Font.PLAIN, 24));
		displayCustRegTime.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToLogIn.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(displayCustNameLabel, displayCustNameLabelC);
		panel.add(displayCustDOBLabel, displayCustDOBLabelC);
		panel.add(displayCustRegTimeLabel, displayCustRegTimeLabelC);
		panel.add(displayCustName, displayCustNameC);
		panel.add(displayCustDOB, displayCustDOBC);
		panel.add(displayCustRegTime, displayCustRegTimeC);
		panel.add(goToAccountOptions, proceedButtonC);

		add(panel);
		setVisible(true);
	}

	public void showPrevTransaction(float amt) {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints balanceC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		balanceC.gridy = scale*200;
		okC.gridy = scale*250;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel balanceLabel = new JLabel();
		
		if (amt == 0) {
			balanceLabel.setText("No transaction history available.");
		}
		else if (amt > 0) {
			balanceLabel.setText(String.format("Previous transaction: Deposit $%,.2f", amt));
		}
		else if (amt < 0) {
			balanceLabel.setText(String.format("Previous transaction: Withdraw $%,.2f", (-1) * amt));
		}
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);
		
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));
		balanceLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		
		panel.setLayout(gbl);
		panel.add(balanceLabel, balanceC);
		panel.add(goToAccountOptions, okC);
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
		GridBagConstraints backC = new GridBagConstraints();

		amountLabelC.gridy = scale*150;
		amountC.gridy = scale*200;
		backC.gridy = scale*250;
		okC.gridy = scale*250;
		amountLabelC.anchor = GridBagConstraints.LINE_START;
		amountC.anchor = GridBagConstraints.CENTER;

		depositAmountLabel = new JLabel("Amount to Deposit: ");
		depositAmount = new JTextField(6);
		goToDepositTwo = new JButton("Ok");
		goToDepositTwo.addActionListener(this);
		goToAccountOptions = new JButton("Back");
		goToAccountOptions.addActionListener(this);

		depositAmountLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		depositAmount.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToDepositTwo.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(depositAmountLabel, amountLabelC);
		panel.add(depositAmount, amountC);
		panel.add(goToAccountOptions, backC);
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

		successC.gridy = scale*150;
		balanceC.gridy = scale*200;
		okC.gridy = scale*250;
		successC.anchor = GridBagConstraints.CENTER;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel(String.format("Successfully deposited $%,.2f", depositAmount));
		JLabel idLabel = new JLabel(String.format("Current balance $%,.2f", bal));
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		successLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		idLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

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
		GridBagConstraints backC = new GridBagConstraints();

		amountLabelC.gridy = scale*150;
		amountC.gridy = scale*200;
		backC.gridy = scale*250;
		okC.gridy = scale*250;
		amountLabelC.anchor = GridBagConstraints.LINE_START;
		amountC.anchor = GridBagConstraints.CENTER;

		withdrawAmountLabel = new JLabel("Amount to Withdraw: ");
		withdrawAmount = new JTextField(6);
		goToWithdrawTwo = new JButton("Ok");
		goToWithdrawTwo.addActionListener(this);
		goToAccountOptions = new JButton("Back");
		goToAccountOptions.addActionListener(this);

		withdrawAmountLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		withdrawAmount.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToWithdrawTwo.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(withdrawAmountLabel, amountLabelC);
		panel.add(withdrawAmount, amountC);
		panel.add(goToAccountOptions, backC);
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

		successC.gridy = scale*150;
		balanceC.gridy = scale*200;
		okC.gridy = scale*250;
		successC.anchor = GridBagConstraints.CENTER;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel successLabel = new JLabel(String.format("Successfully withdrew $%,.2f", withdrawAmount));
		JLabel idLabel = new JLabel(String.format("Current balance $%,.2f", bal));
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		successLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		idLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(successLabel, successC);
		panel.add(idLabel, balanceC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}

	public void showInterest() {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints rateLabelC = new GridBagConstraints();
		GridBagConstraints rateC = new GridBagConstraints();
		GridBagConstraints yearsLabelC = new GridBagConstraints();
		GridBagConstraints yearsC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();
		GridBagConstraints backC = new GridBagConstraints();

		rateLabelC.gridy = scale*150;
		rateC.gridy = scale*150;
		yearsLabelC.gridy = scale*200;
		yearsC.gridy = scale*200;
		backC.gridy = scale*250;
		okC.gridy = scale*250;
		rateLabelC.anchor = GridBagConstraints.LINE_START;
		rateC.anchor = GridBagConstraints.CENTER;

		rateLabel = new JLabel("Annual interest rate (%): ");
		rate = new JTextField(3);
		yearsLabel = new JLabel("Number of years: ");
		years = new JTextField(4);
		goToInterestTwo = new JButton("Ok");
		goToInterestTwo.addActionListener(this);
		goToAccountOptions = new JButton("Back");
		goToAccountOptions.addActionListener(this);

		rateLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		rate.setFont(new Font("Verdana", Font.PLAIN, 24));
		yearsLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		years.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToInterestTwo.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(yearsLabel, yearsLabelC);
		panel.add(rateLabel, rateLabelC);
		panel.add(years, yearsC);
		panel.add(rate, rateC);
		panel.add(goToAccountOptions, backC);
		panel.add(goToInterestTwo, okC);		
		add(panel);
		setVisible(true);
	}
	
	public void showInterestTwo(float rate, int years) {
		int custID = cust.getID();
		String custName = cust.getName();
		super.setTitle("Bank Account: " + custName + " " + Integer.toString(custID));

		float amt = cust.account.calculateInterest(cust, rate, years);
		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints textC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		textC.gridy = scale*150;
		okC.gridy = scale*250;
		textC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel text = new JLabel(String.format("Annual %2.1f%% interest: \n Balance in %d years = $%,.2f", rate, years, amt));
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		text.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(text, textC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}
	
	public void showBalance (String name, int id, float balance) {
		super.setTitle("Bank Account: " + name + " " + Integer.toString(id));

		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints balanceC = new GridBagConstraints();
		GridBagConstraints okC = new GridBagConstraints();

		balanceC.gridy = scale*200;
		okC.gridy = scale*250;
		balanceC.anchor = GridBagConstraints.CENTER;
		okC.anchor = GridBagConstraints.CENTER;

		JLabel balanceLabel = new JLabel(String.format("Current balance: $%,.2f", balance));
		goToAccountOptions = new JButton("Ok");
		goToAccountOptions.addActionListener(this);

		balanceLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		goToAccountOptions.setFont(new Font("Verdana", Font.PLAIN, 24));

		panel.setLayout(gbl);
		panel.add(balanceLabel, balanceC);
		panel.add(goToAccountOptions, okC);
		add(panel);
		setVisible(true);
	}

	public void showCustomerList(ArrayList<Customer> customerList) {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints customerTableC = new GridBagConstraints();
		GridBagConstraints backButtonC = new GridBagConstraints();

		customerTableC.gridy = scale*150;
		backButtonC.gridy = scale*200;
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
		goToStart.setFont(new Font("Verdana", Font.PLAIN, 24));

		goToStart.addActionListener(this);
		JTable customerTable = new JTable(data, columnNames) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	            return false;
	         }
		};

		customerTable.setFont(new Font("Verdana", Font.PLAIN, 24));
		customerTable.setCellSelectionEnabled(true);
		customerTable.setRowHeight(scale * 20);
		customerTable.setPreferredSize(new Dimension (400, customerCount * scale * 20));
		
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
			showCustomerList(cs.viewCustomers());
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

			if (Customer.validateDate(dobInput)) {

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
			else {
				System.out.println("invalid date");
			}
		}

		else if (source == goToLogIn) {
			showLogIn();
		}		

		else if (source == logInOkButton) {
			try {
				int idInput = Integer.parseInt(customerID.getText());

				if(cs.searchCustomer(cust, idInput)) {
					showCustomerDetails(cust.getName(), cust.getDateOfBirth(), cust.getRegTime());
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
			showAccountOptions(cust.getName(), cust.getID());
		}

		else if (source == accOptionsOkButton) {
			if (makeDeposit.isSelected()) {
				showDepositOne();
			}
			else if(makeWithdrawal.isSelected()) {
				showWithdrawalOne();
			}
			else if (checkBalance.isSelected()) {
				showBalance(cust.getName(), cust.getID(), cust.getBalance());
			}
			else if (accInfo.isSelected()) {
				showAccountInfo(cust.getName(), cust.getDateOfBirth(), cust.getRegTime());
			}
			else if (calcInterest.isSelected()) {
				showInterest();
			}
			else if (prevTransaction.isSelected()) {
				showPrevTransaction(cust.account.getPreviousTransaction(cust));
			}
		}

		else if (source == goToDepositTwo) {
			try {
				float amt = Float.parseFloat(depositAmount.getText());
				System.out.println(amt);
				cust.account.makeTransaction(cust, amt);
				System.out.println(cust.getBalance());
				showDepositTwo(amt, cust.getBalance());
			}

			catch (NumberFormatException e) {

			}
		}

		else if (source == goToWithdrawTwo) {
			try {
				float amt = Float.parseFloat(withdrawAmount.getText());
				if (amt < cust.getBalance()) {
					cust.account.makeTransaction(cust, amt * (-1));
					showWithdrawalTwo(amt, cust.getBalance());
				}
			}
			catch (NumberFormatException e) {

			}
		}
		
		else if (source == goToInterestTwo) {
			try {
				float interestRate = Float.parseFloat(rate.getText());
				int interestYears = Integer.parseInt(years.getText());
				showInterestTwo(interestRate, interestYears);
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
	}
}

