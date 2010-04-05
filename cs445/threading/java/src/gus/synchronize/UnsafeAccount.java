package gus.synchronize;

// java -cp bin gus.synchronize.UnsafeAccount
public class UnsafeAccount implements Account {
  private long balance;

  public UnsafeAccount(long startingBalance) {
    this.balance = startingBalance;
  }

  public boolean withdraw(long amount) {
    if (amount <= balance) {
      try {
        Thread.sleep(5); // Doing something fancy that takes 5ms
      } catch (InterruptedException e) {}
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
    Account account = new UnsafeAccount(1000000);
    new MeanMachine("a", account, 125000);
    new MeanMachine("b", account, 250000);
  }
}