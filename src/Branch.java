import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
    Customer customer = new Customer("Name", new ArrayList<Double>());

    public Branch(){

    }
    public void createCustomer(){
        customer.setName();
        String name = customer.getName();
        customer.setBalance();
        customer.setTransactions();
        ArrayList<Double> transactions = customer.getTransactions();
    }


    ArrayList<Customer> customers = new ArrayList<Customer>();

    public void eh(){
        System.out.println(customer.getTransactions());
        System.out.println(customer.getName());
    }



}
