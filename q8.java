import java.util.*;

class LessBalanceException extends Exception {
    LessBalanceException(String message) {
        super(message);
    }
}

class Account {
    double amount;
    Scanner in = new Scanner(System.in);

    Account() {
        amount = 500.0;
    }

    public void deposit() {
        System.out.println("Enter amount to deposit");
        double temp = in.nextDouble();
        amount += temp;
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw");
        double temp = in.nextDouble();
        try {
            if ((amount - temp) < 500.0)
                throw new LessBalanceException("Withdraw amount Rs." + temp + " is not valid");
        } catch (LessBalanceException e) {
            System.out.println("Balance less than Rs.500 : \n" + e);
            System.exit(0);
        }
    }
}

public class q8 {

    public static void transaction(int acc_no, Account acc) {
        System.out.println("Account " + acc_no + "\n");
        acc.deposit();
        acc.withdraw();
    }

    public static void main(String[] args) {
        Account acc1 = new Account();
        Account acc2 = new Account();
        transaction(1, acc1);
        transaction(2, acc2);
    }
}
