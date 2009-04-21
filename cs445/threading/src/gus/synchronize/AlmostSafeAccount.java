package gus.synchronize;

public class AlmostSafeAccount implements Account { // Why not just extend TcfAccount?
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
    new MeanMachine("a", account, 125000);
    new MeanMachine("b", account, 250000);
  }
}