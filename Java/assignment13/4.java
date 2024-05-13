/**
 * BankingSystem
 */
public class BankingSystem extends Thread {

    public static double totalbalance=0;
    
   synchronized public void withdraw(double amount) {
   
   synchronized(this) {
        totalbalance=totalbalance-amount;
    }
        

    }
  synchronized public void display() {
        System.out.println("total balance"+totalbalance);
    }
   synchronized public void deposit(double amount) {
        totalbalance=totalbalance+amount;
    }
   
   
    
}


public class Demo {    
    public static void main(String[] args) {
        BankingSystem bankingSystem=new BankingSystem();
        BankingSystem bankingSystem2=new BankingSystem();
        System.out.println(bankingSystem.totalbalance);
        bankingSystem.deposit(855);
        bankingSystem.withdraw(100);
        bankingSystem2.withdraw(250);
        bankingSystem.display();
    }
}