package gus.synchronize;

public class SafeAccount implements Account { // Why not just extend TcfAccount?
  private Account account;

  public SafeAccount(Account account) { // What is this design pattern called?
    this.account = account;
  }

  public boolean withdraw(long amount) {
    synchronized(account) { // What does this mean?
      return account.withdraw(amount);
    }
  }

  public long getBalance() {
    return account.getBalance();
  }

  public static void main (String [] args) {
    Account account = new SafeAccount(new TcfAccount(1000000));
    MeanMachine machinea = new MeanMachine("a", account, 125000);
    MeanMachine machineb = new MeanMachine("b", account, 250000);
  }
}