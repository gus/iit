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
      long withdrew = account.withdraw(amount) ? amount : 0;
      return new WithdrawResponse(withdrew, account.getBalance());
    }
  }

  public long getBalance() {
    synchronized(account) { return account.getBalance(); }
  }

  public static void main (String [] args) {
    BetterAccount account = new SafeAccount(new UnsafeAccount(1000000));
    new LeanMachine("a", account, 25000);
    new LeanMachine("b", account, 50000);
    new LeanMachine("c", account, 50000);
  }
}