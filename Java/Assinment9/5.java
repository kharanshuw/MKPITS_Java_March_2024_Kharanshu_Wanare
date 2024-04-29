package assignment9;

public interface BankAccount {
    public void deposit();
    public  void withdraw();
    public double balanceInquiry();
}

package assignment9;

public class CurrentAccount implements  BankAccount{

    private  long accountno;
    private double balance;

    public CurrentAccount(long accountno, double balance) {
        this.accountno = accountno;
        this.balance = balance;
    }

    public CurrentAccount() {

    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public double balanceInquiry() {
        return 0;
    }
}

package assignment9;

import java.util.Scanner;

public class SavingsAccount implements BankAccount{
   private long accountno;
   private double totalbalance;
    private double annualsalary;
    Scanner scanner=new Scanner(System.in);

    public SavingsAccount() {
    }

    public SavingsAccount(long accountno,double totalbalance, double annualsalary) {
        this.totalbalance = totalbalance;
        this.annualsalary = annualsalary;
        this.accountno=accountno;
    }

    public long getAccountno() {
        return accountno;
    }

    public double getAnnualsalary() {
        return annualsalary;
    }

    public double getTotalbalance() {
        return totalbalance;
    }

    @Override
    public void deposit() {
        System.out.println("how much money you want to deposit");
        double amount=scanner.nextDouble();
        totalbalance=totalbalance+amount;
    }

    @Override
    public void withdraw() {
        System.out.println("enter amount you want to withdraw");
        double amount=scanner.nextDouble();
        totalbalance=totalbalance-amount;
    }

    @Override
    public double balanceInquiry() {
        return totalbalance;
    }
}
