package gus.synchronize;

public class SafeAccount implements Account { // Why not just extend TcfAccount?
  private Account account;

  public SafeAccount(Account account) { // What is this design pattern called?
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
    Account account = new SafeAccount(new TcfAccount(1000000));
    new MeanMachine("a", account, 125000);
    new MeanMachine("b", account, 250000);
  }
}