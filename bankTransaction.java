import java.util.*;
import java.lang.Exception;
import java.time.LocalDate;

class UserDeniedException extends Exception {
     UserDeniedException(String message) {
          super(message);
     }
}

class Branches {
     private static Map<Integer, String[]> branches;

     static {
          branches = new HashMap<>();
          branches.put(123456, new String[] { "Maldives", "MLDS000432" });
          branches.put(789456, new String[] { "BERLIN", "BERL0000364" });
          branches.put(123789, new String[] { "HELSINKI", "HELS000665" });
          branches.put(456123, new String[] { "NAIROBI", "NAIR0000108" });
          branches.put(123987, new String[] { "DENVER", "DENV0000852" });
     }

     String[] getBranch(int pin) {
          return branches.get(pin);
     }
}

class BankAccount extends Branches {
     String name, address, type, branch_name, ifsc;
     int acc_no, pin, postal_code;
     long ph_no;
     LocalDate date;
     double temp = 0.0, bal = 0.0;
     Scanner in = new Scanner(System.in);
     Random rnd = new Random();
     static int count;

     static {
          count = 0;
     }

     public void verify(int pin) {
          try {
               if (this.pin != pin)
                    throw new UserDeniedException("Invalid Pin entered");
          } catch (UserDeniedException e) {
               System.out.println(e);
               System.exit(0);
          }
     }

     void getInfo() {
          try {

               System.out.println("Enter Name: ");
               name = in.nextLine();

               System.out.println("Enter 6 digit postal code: ");
               postal_code = in.nextInt();

               in.nextLine();

               System.out.println("Enter Address: ");
               address = in.nextLine();

               String[] branch_detail = new String[2];
               branch_detail = getBranch(postal_code);

               branch_name = branch_detail[0];
               ifsc = branch_detail[1];

               in.nextLine();

               System.out.println("Mention account type:\n1.Savings (7% interest )\t2.Current (5% interest) ");
               int typ = in.nextInt();

               switch (typ) {
                    case 1:
                         type = "Savings";
                         break;

                    case 2:
                         type = "Current";
                         break;

                    default:
                         System.out.println("Invalid Option");
               }

               System.out.println("Enter a secure 4 digit pin :");
               pin = in.nextInt();

          } catch (Exception e) {
               System.out.println("Exception caught : " + e);
               System.exit(0);
          }

     }

     public int createAcc() {
          try {
               getInfo();
               System.out.println("\nAccount Successfully Created!");
               acc_no = rnd.nextInt(1000) + 1;
               date = LocalDate.now();
               System.out.println("Hello " + name + " your account no is " + acc_no + ".\n");
          } catch (Exception e) {
               System.out.println("Fatal Error");
          }

          return acc_no;
     }

     public void display() {
          System.out.println("Name - " + name);
          System.out.println("Account Number - " + acc_no);
          System.out.println("Address - " + address);
          System.out.println("Branch - " + branch_name + "\t\tIFSC - " + ifsc);
          System.out.println("Date - " + date);
          System.out.println("\nBalance =  " + bal);
     }

     public void deposit() {

          System.out.println("Enter the amount to be deposited :");
          temp = in.nextFloat();
          try {
               bal += temp;
               System.out.println("SUCCESSFULLY CREDITED");

          } catch (Exception e) {
               System.out.println(e.getMessage());
               System.out.println("TRANSACTION FAILURE");
          }

     }

     public void withdraw() {

          System.out.println("Enter the amount to be withdrawn :");
          temp = in.nextFloat();

          try {

               if (temp < bal) {
                    bal -= temp;
                    System.out.println("SUCCESSFULLY DEBITED");
               } else {
                    System.out.println("INSUFFIECEINT FUND");
               }
          } catch (Exception e) {
               System.out.println(e.getMessage());
               System.out.println("TRANSACTION FAILURE");
          }

     }

     void checkBal() {
          System.out.println("Balance:" + bal);
     }

}

public class bankTransaction {
     public static void main(String arg[]) throws UserDeniedException {
          Scanner in = new Scanner(System.in);
          BankAccount acc[] = new BankAccount[10];

          Map<Integer, Integer> customerDetails = new HashMap<Integer, Integer>();
          int temp_account, temp_pin;

          System.out.println("\n\n\t----Bank Of Spain----");
          try {
               while (true) {
                    System.out.println(
                              "1.Create Account\t2.Display Details\n3.Check Balance\t\t4.Deposit\n5.Withdraw\t\t6.Exit.");
                    int ch = in.nextInt();
                    switch (ch) {
                         case 1:
                              acc[BankAccount.count] = new BankAccount();
                              int temp_acc = acc[BankAccount.count].createAcc();
                              customerDetails.put(temp_acc, BankAccount.count++);
                              break;

                         case 2:
                              System.out.println("Enter account number : ");
                              temp_account = in.nextInt();
                              System.out.println("Enter your pin : ");
                              temp_pin = in.nextInt();
                              acc[customerDetails.get(temp_account)].verify(temp_pin);
                              System.out.println("\n\n");
                              acc[customerDetails.get(temp_account)].display();
                              break;

                         case 3:
                              System.out.println("Enter account number : ");
                              temp_account = in.nextInt();
                              System.out.println("Enter your pin : ");
                              temp_pin = in.nextInt();
                              acc[customerDetails.get(temp_account)].verify(temp_pin);
                              acc[customerDetails.get(temp_account)].checkBal();
                              break;

                         case 4:
                              System.out.println("Enter account number : ");
                              temp_account = in.nextInt();
                              System.out.println("Enter your pin : ");
                              temp_pin = in.nextInt();
                              acc[customerDetails.get(temp_account)].verify(temp_pin);
                              acc[customerDetails.get(temp_account)].deposit();
                              break;

                         case 5:
                              System.out.println("Enter account number : ");
                              temp_account = in.nextInt();
                              System.out.println("Enter your pin : ");
                              temp_pin = in.nextInt();
                              acc[customerDetails.get(temp_account)].verify(temp_pin);
                              acc[customerDetails.get(temp_account)].withdraw();
                              break;

                         case 6:
                              System.exit(0);
                              break;

                         default:
                              System.out.println("Invalid Option");
                    }
               }
          } catch (Exception e) {
               System.out.println(e);
          }
     }
}