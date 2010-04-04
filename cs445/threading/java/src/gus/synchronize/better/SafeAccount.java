package gus.synchronize.better;

import gus.synchronize.*;

public class SafeAccount implements BetterAccount { // Why not just extend TcfAccount?
  private Account account;

  public SafeAccount(Account account) { // What is this design pattern called?
    this.account = account;
  }

  public long withdraw(long amount) {
    synchronized(account) {
      return account.withdraw(amount) ? account.getBalance() : 0;
    }
  }

  public long getBalance() {
    synchronized(account) { return account.getBalance(); }
  }

  public static void main (String [] args) {
    BetterAccount account = new SafeAccount(new GetANewAccount(1000000));
    new LeanMachine("a", account, 125000);
    new LeanMachine("b", account, 250000);
  }
}