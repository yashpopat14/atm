import java.util.Scanner;
import java.util.ArrayList;

class user{
    public String name;
    public String username;
    public String password;
    public String accountNo;
    float balance = 0f;
    ArrayList<String> transactionHistory = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    
    
    
    public void signup(){
        System.out.print("Enter your Name: ");
        name = sc.nextLine();
        System.out.print("Enter your Username: ");
        username = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextLine();
        System.out.print("Enter your Account No: ");
        accountNo = sc.nextLine();
    }
    
    public Boolean signin() {
        System.out.println();
        System.out.println("Login Using Your Username and Password..!");
        Boolean isLogin = false;
        while (!isLogin) {
            System.out.print("Enter your username: ");
            String user = sc.nextLine();
            System.out.print("Enter your Password: ");
            String pass = sc.nextLine();

            if (user.equals(username) && pass.equals(password)) {
                System.out.println();
                System.out.println("Successfully Login..!");
                isLogin = true;
            } else {
                System.out.println();
                System.out.println("Invaild Username OR Password");
                isLogin = false;
            }
        }
        return isLogin;
    }

    public float checkBalance() {
        return balance;

    }

    public void withdraw() {
        System.out.println();
        System.out.print("Enter the Amount :");
        float enteredAmount = sc.nextFloat();
        if (checkBalance() < enteredAmount) {
            System.out.println("Your Account have not Suffient Balance..");
        } else {
            System.out.println("SucessFully WithDraw...!");
            balance = balance - enteredAmount;
            String history = "Rs." + enteredAmount + " is WithDraw";
            transactionHistory.add(history);
        }

    }

    public void trans_History() {
        System.out.println();
        System.out.println("Your Account Transaction Histoty :");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println(transactionHistory.get(i));
        }
        System.out.println();
    }

    public void deposit() {
        System.out.println();
        System.out.print("Enter the Amount:");
        float enteredAmount = sc.nextFloat();
        balance += enteredAmount;
        System.out.println();
        System.out.println("SuccessFully Deposited...!");
        String history = "Rs." + enteredAmount + " is Deposited";
        transactionHistory.add(history);

    }

    public void transfer() {
        System.out.println();
        sc.nextLine();
        System.out.print("Enter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer : ");
        float enteredAmount = sc.nextFloat();

        if (balance < enteredAmount) {
            System.out.println("Transfer is Failed");
            System.out.println("Not Suffient Balance to Transfer");
        } else {
            balance -= enteredAmount;
            System.out.println("SuccessFully Transfered to " + receipent);
            String history = "Rs." + enteredAmount + " is Transfered to " + receipent;
            transactionHistory.add(history);

        }
    }

}



public class atm{
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    user User = new user();
    System.out.println("Welcomme To SBI ATM");
    System.out.println("Register To YourSelf");
    User.signup();
    User.signin();
    while (true) {
        System.out.println();
        System.out.println();
        System.out.println("1. Check Your Balance ");
        System.out.println("2. Withdraw  ");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History ");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\n Your Account Balance : " + User.checkBalance());
                break;
            case 2:
                User.withdraw();
                break;
            case 3:
                User.deposit();
                break;
            case 4:
                User.transfer();
                break;
            case 5:
                User.trans_History();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invaild Choice Please Enter Correct Choice");
                break;
        }
    }
  }
}
