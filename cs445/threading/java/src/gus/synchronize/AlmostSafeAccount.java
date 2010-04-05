package gus.synchronize;

// java -cp bin gus.synchronize.AlmostSafeAccount
// Pay attention to the return amount
public class AlmostSafeAccount implements Account { // Why not just extend GetANewAccount?
  private Account account;

  public AlmostSafeAccount(Account account) { // What is this design pattern called?
    this.account = account;
  }

  // What is this synchronized? How do we know this is where we want it?
  public synchronized boolean withdraw(long amount) {
    return account.withdraw(amount);
  }

  public synchronized long getBalance() {
    return account.getBalance();
  }

  public static void main (String [] args) {
    Account account = new AlmostSafeAccount(new UnsafeAccount(1000000));
    new MeanMachine("a", account, 25000);
    new MeanMachine("b", account, 50000);
    new MeanMachine("c", account, 50000);
  }
}