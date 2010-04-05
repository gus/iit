package gus.synchronize;

// java -cp bin gus.synchronize.AlmostSafeAccount
// Pay attention to the return amount
public class AlmostSafeAccount implements Account { // Why not just extend GetANewAccount?
  private Account account;

  public AlmostSafeAccount(Account account) { // What is this design pattern called?
    this.account = account;
  }

  public boolean withdraw(long amount) {
    // What does synchronized(account) mean?
    synchronized(account) { return account.withdraw(amount); }
  }

  public long getBalance() {
    synchronized(account) { return account.getBalance(); }
  }

  public static void main (String [] args) {
    Account account = new AlmostSafeAccount(new GetANewAccount(1000000));
    new MeanMachine("a", account, 25000);
    new MeanMachine("b", account, 50000);
    new MeanMachine("c", account, 50000);
  }
}