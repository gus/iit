package gus.synchronize;

public class TcfAccount implements Account {
  private long balance;

  public TcfAccount(long startingBalance) {
    this.balance = startingBalance;
  }

  public boolean withdraw(long amount) {
    if (amount <= balance) {
      try {Thread.sleep(5);} catch (InterruptedException e) {} // Doing something fancy that takes 5ms
      long newbalance = balance - amount;
      this.balance = newbalance;
      return true;
    } else {
      return false;
    }
  }

  public long getBalance() {
    return this.balance;
  }

  public static void main (String [] args) {
    Account account = new TcfAccount(1000000);
    new MeanMachine("a", account, 125000);
    new MeanMachine("b", account, 250000);
  }
}