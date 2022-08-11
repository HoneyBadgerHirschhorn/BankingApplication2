import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    private String name;
    private double balance;
    private ArrayList<Double> transactions = new ArrayList<Double>(0);

    Branch branch = new Branch();
    public Customer(String name, ArrayList<Double> transactions){

    }

    public void customerMenu(){
        Scanner menuScanner = new Scanner(System.in);
        boolean isInt = menuScanner.hasNextInt();
        System.out.println("Please pick on of the three options available\n" +
                "(0) Create a new customer file\n"+
                "(1) Select an existing customer file.\n"+
                "(2) Set the customer's name.\n" +
                "(3) Set the customer's balance\n" +
                "(4) Add or withdraw from the account (this will add to the list of transactions).\n" +
                "(5) Amend transaction list for this customer.\n+" +
                "(6) Return to the branch menu.");
        if (!isInt){
            System.out.println("You did not enter a valid number, please try again.");
            menuScanner.nextLine();
            customerMenu();
        }
        if (isInt) {
            int choice = menuScanner.nextInt();
            if (choice <0 || choice > 6){
                System.out.println("You did not enter a valid number, please try again.");
                menuScanner.nextLine();
                customerMenu();
            }
            else {
                switch (choice){
                    case 0:

                    case 1:

                    case 2:
                        setName();
                    case 3:
                        setBalance();
                    case 4:
                        modifyTransactions();
                    case 5:

                    case 6:

                }
            }
        }
    }

    public void selectFile(){
        Scanner fileScanner = new Scanner(System.in);
        System.out.println("What customer file do you wish to work with?");
        String name = fileScanner.nextLine();
        currentClient(name, transactions);
        if (Objects.equals(this.name,name)){
            System.out.println("You've chosen to work with "+name+"s file. You may now work with options 2-5 on the menu.");
            customerMenu();
        }
        if (!Objects.equals(this.name,name)){
            System.out.println("I'm sorry it does not appear that we have "+name+" on file. Please check spelling and try again");
            fileScanner.nextLine();
            customerMenu();
        }
    }
    public void currentClient(String name, ArrayList<Double> transList){
       if (branch.customers.contains(name)){
           this.name = name;
           this.transactions = branch.customer.getTransactions();

       }

    }

    public Customer getCustomersIndex (){
     return branch.customers.get(branch.customers.indexOf(name));
    }
    public String getName() {
        return name;
    }
    public void setName() {
        Scanner nameScan = new Scanner(System.in);
        System.out.println("Please enter the name of the customer.");
        String Name = nameScan.nextLine();
        this.name = name;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    public void setTransactions() {
        Scanner transScan = new Scanner(System.in);
        System.out.println("Please enter the amount to add or withdraw from the account or hit q to reach the customer menu");
        boolean isDouble = transScan.hasNextDouble();
        if (isDouble){
            double number = transScan.nextDouble();
            this.balance += number;
            System.out.println("Balance has been updated to "+balance);
            transactions.add(number);
            System.out.println(number+" Has been added to the list of transactions");
        }
        if (!isDouble && (!Objects.equals(transScan.nextLine(),"Q") || !Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("That was not a valid entry, please try again.");
            setTransactions();
        }
        if (!isDouble && (Objects.equals(transScan.nextLine(),"Q") || Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("You've chosen to return to the customer menu");
            transScan.nextLine();
            customerMenu();
        }
    }

    public void modifyTransactions(){
        Scanner transScan = new Scanner(System.in);
        System.out.println("Would you like to see the list of transactions for "+name);
        boolean isDouble = transScan.hasNextDouble();
        if (isDouble){
            double number = transScan.nextDouble();
            this.balance += number;
            System.out.println("Balance has been updated to "+balance);
            transactions.add(number);
            System.out.println(number+" Has been added to the list of transactions");
        }
        if (!isDouble && (!Objects.equals(transScan.nextLine(),"Q") || !Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("That was not a valid entry, please try again.");
            setTransactions();
        }
        if (!isDouble && (Objects.equals(transScan.nextLine(),"Q") || Objects.equals(transScan.hasNextLine(),"q"))){
            System.out.println("You've chosen to return to the customer menu");
            transScan.nextLine();
            customerMenu();
        }
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance() {
        Scanner scanBalance = new Scanner(System.in);
        boolean isDouble = scanBalance.hasNextInt();
        if (isDouble) {
            System.out.println("What is the initial balance for " + name + " ?");
            double balance = scanBalance.nextDouble();
            this.balance = balance;
            System.out.println("The balance has been set to "+this.balance);
        }
        if (!isDouble){
            System.out.println("That is not a valid number, please try again.");
            scanBalance.nextLine();
            setBalance();
        }
    }
}
