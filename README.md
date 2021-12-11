# Rental Property Management System
## ENSF480 Group 11
#### ***Team members: Dat Lam, Jacob Lansang, Evan Lester, Zhifan Li***
How to run this project:
* First create user in MySQL with username: "ensf480" and password: "ensf480"
* Create a new database in MySQL with name: "ensf480"
* Import the ensf480.sql file to the ensf480 database
### You have two ways to run this program:
#### 1: Run the ENSF480_Group11.jar file after setting up the database
#### 2: Run through terminal, You need to do the following things:
#### **To Use Send Email Features: Set up SendGrid jar file and its API key:**
##### Option 1: On Linux or macOS
* Go to project's folder
* Go to src folder, You can see there is a sendgrid-java.jar file
* In your terminal, type: ```zip -d sendgrid-java.jar 'META-INF/*.SF' 'META-INF/*.RSA' 'META-INF/*.DSA'```
* The above command is for removing the sign key so that we can use sending email feature correctly without any exceptions
* Then, set the environment value: 
* ```echo "export SENDGRID_API_KEY='API_KEY'" > sendgrid.env```
* ```echo "sendgrid.env" >> .gitignore```
* ```source ./sendgrid.env```

##### Option 2: Using Eclipse 
* You can setup the environment var in the Eclipse run configurations: Go to environment, then add variable: SENDGRID_API_KEY, Value: API_KEY
* The above command is for setting the sendgrid api key as an environemnt variable so that we can use send email features.

#### **To Run the Project after setting up the environment:**
* Go to project folder
* ```cd src```
* ```javac -cp .:mysql-connector-java-8.0.27.jar:sendgrid-java.jar view/*.java  model/*.java controller/*.java```
* ```java -cp .:mysql-connector-java-8.0.27.jar:sendgrid-java.jar view.RentalPropertyManagementSystem```
* You can registered as Registered Renter or Landlord
* You can also login as Registered Renter, Landlord, or Manager
* Manager's username is "admin", password is "password"
### Now you can start using it.
