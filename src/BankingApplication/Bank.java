package BankingApplication;
import java.util.*;
public class Bank {
    int balance;
    int previoustransition;
    String customerName;
    String customerId;

    Bank(String csn , String cid){
        customerName = csn;
        customerId = cid;
    }

    void deposit(int amnt) {
        if (amnt != 0) {
            balance = balance + amnt;
            previoustransition = amnt;
        }
    }

    void withdraw(int amnt) {
        if (amnt != 0) {
            balance = balance - amnt;
            previoustransition = -amnt;
        }
    }

    void getPreviousTransition() {
        if (previoustransition > 0) {
            System.out.println("Deposit : " + previoustransition);
        }
        else if (previoustransition < 0) {
            System.out.println("Withdraw : " + Math.abs(previoustransition));
        } else {
            System.out.println("No Transition Occured");
        }
    }
    void showMenu(){
        Scanner scn = new Scanner(System.in);
        char option ='\0';
        System.out.println("Welcome "+customerName);
        System.out.println("Your Id is : "+customerId);
        System.out.println("\n");

        System.out.println("A.Show Balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Show Previous Transition");
        System.out.println("E.Exit");

        do {
            System.out.println("---------------------------------------------------");
            System.out.println("Choose an Option------>");
            System.out.println("---------------------------------------------------");
            option=scn.next().charAt(0);
            System.out.println("\n");

            switch (option){

                case 'A':
                    System.out.println("---------------------------------------------------");
                    System.out.println("Your Balance is : "+balance);
                    System.out.println("---------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("---------------------------------------------------");
                    System.out.print("Enter your amount to deposit : ");
                    //System.out.println("---------------------------------------------------");
                    int amount = scn.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C' :
                    System.out.println("---------------------------------------------------");
                    System.out.print("Enter your amount to withdraw : ");
                   // System.out.println("---------------------------------------------------");
                    int amount2 = scn.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D' :
                    System.out.println("---------------------------------------------------");
                    getPreviousTransition();
                    System.out.println("---------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'E' :
                    System.out.println("Thanks for using this application!");
                    break;
                default:
                    System.out.println("Invalid Key , Please Try Again!");
            }
        }while(option!='E');
    }
}
