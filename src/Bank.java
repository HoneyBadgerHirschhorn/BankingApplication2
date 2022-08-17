import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private static ArrayList<Branch> branches = new ArrayList<Branch>(0);
    public Bank() {}
        public void bankMenu () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hi, and welcome to Honeybadger Bank. Please select an option from the menu below");
            System.out.println("(0) Close this program.\n" +
                    "(1) Print a list of available bank branches \n" +
                    "(2) Open a brand new bank branch \n" +
                    "(3) Chose to work with an exisbing bank branch");
            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) {
                System.out.println("That was an invalid entry please try again ");
                bankMenu();
            }
            if (hasInt) {
                int choice = scanner.nextInt();
                if (choice <1 || choice >3){
                    System.out.println("That was an invalid entry please try again ");
                    bankMenu();
                }
                else switch (choice){
                    case 1:
                        printBranches();
                    case 2:
                        createBranch();
                    case 3:
                        System.out.println("Quitting the program");
                        System.exit(0);
                }
            }
        }

        public void printBranches(){
        if (branches.size() == 0 ){
            System.out.println("There are no bank branches yet. You can go make one from the branch menu");
            bankMenu();
        }
        if (branches.size() > 0){
            for (Branch branch : branches){
                System.out.println(branch);
            }
        }
        }

}



