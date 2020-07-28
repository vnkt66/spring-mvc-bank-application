# spring-mvc-bank-application
1. Technologies used

    - Required Servlet 3.0+ container, like Tomcat 7 or Jetty 8
    - MySQL WorkBench
    - Eclipse IDE(With Spring Tool Suite)
    - jdbc driver

2. To clone the repository

   $ git clone https://github.com/vnkt66/spring-mvc-bank-application/

3. To Run the application

   Run with Apache Tomcat or Jetty 8
   
4. Routing

- Home
Access http://localhost:8080/BankSpringMVC
- Transactions
Access http://localhost:8080/BankSpringMVC/welcome.html
- TransferMoney
Access http://localhost:8080/BankSpringMVC/transfer.html

5. Folder Structure

- src/com/bank package contains necessary folders like controller, dao, models.
- controller contains main controller file to map the urls to specific handler methods.
- dao contains interface and another class that implemets that interface for interacting with database.
- models contains classes that represents tables in database.

- WebContent is main folder which contains our views and servlet configuration file for database configuration, resolving views, controllers.
- web.xml contains servlets we dispatch, servlet mapping.

- pom.xml contains packing our app to either war or jar, required dependencies and plugins for our app to work.

- bank.sql contains sql queries.

- target folder contains our deployed war file.

6. Sql 

- one to one mapping between user and his account.
- one to many mapping between user and transactions he performs.

7. Screenshots

- contains screenshots for sql execution, maven build, live demo.

8. Working

- Make sure you have server installed like tomcat for running this application by default it runs on 8080 you are free to change the port like i did on 9090.
- Make Sure to refresh project and target folders for sync.
- Clean tomcat server and run it if you face any issues.

## Note

- First 11 Transactions added to the database for just sample quering it doesn't count on bankBalance.
- In models Transaction.java is not related to the project.
- For now transfer deducts 1000 from bankBalance from a particular user.
- The application can be extended to map user with transactions, add columns like receiver_id to the transactions to further add complexity.

### Authors

- Venkanna Chowdary Penubothu - [spring-mvc-bank-application](https://github.com/vnkt66/spring-mvc-bank-application/)
