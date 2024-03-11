# Banking Simulator 💰
## Overview
The banking application will be used by tellers in the branch to manage daily customer banking needs, such as: 
- Check balance
- Make deposit
- Make withdrawal
- View most recent transaction
- Calculate interest
- Customer management
  - Create accounts for new customer
  - Create customer profile
  - See user information (e.g. name, DOB, account creation date)


## How was it made?
### 1.1 Create a terminal version with key features
- Input/output done through console
- Customer and Account classes

### 1.2 Add Swing GUI
- Input/output through dialog, button, label, text box, radio button in Swing instead of console
-	Associate event handler to specific UI components with its respective methods (e.g. button, radio button)

### 1.3	Persist into database
- Start Derby DB and make accessible from within Eclipse through JDBC
- Create table Customer and Account, update tables with JDBC based code in PersistanceManager

## Use Case Realization
### Class Diagram
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/a6356d03-4676-4ff8-8f69-170666a58446)

### Create a customer
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/95d5cc26-d603-45b2-98aa-6fcc545b0145)

### List customer
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/700ea100-28cc-4af2-a6a7-3b2dea171f71)

### Sign up customer
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/8b43a371-5d4f-4fb0-9122-45c16cb3b2e0)

### Search customer by ID
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/6c35a8c0-410d-4a75-89f1-89a732b7d922)

### View customers
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/35f32fba-663b-40e7-88c5-8bbf57c06a2e)

## GUI Design
![image](https://github.com/milkxiii/bankingsimulator/assets/104285627/76795b0a-641d-475a-831b-748af3be0891)


