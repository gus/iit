package gus.synchronize.better;

import gus.synchronize.*;

// java -cp bin gus.synchronize.better.SafeAccount
public class SafeAccount implements BetterAccount {
  private Account account;

  public SafeAccount(Account account) {
    this.account = account;
  }

  public WithdrawResponse withdraw(long amount) {
    synchronized(account) {
      return account.withdraw(amount) ? new WithdrawResponse(amount, account.getBalance()) : new WithdrawResponse(0, account.getBalance());
    }
  }

  public long getBalance() {
    synchronized(account) { return account.getBalance(); }
  }

  public static void main (String [] args) {
    BetterAccount account = new SafeAccount(new GetANewAccount(1000000));
    new LeanMachine("a", account, 25000);
    new LeanMachine("b", account, 50000);
    new LeanMachine("c", account, 50000);
  }
}