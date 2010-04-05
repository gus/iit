package gus.synchronize.better;

public interface BetterAccount {
  public WithdrawResponse withdraw(long amount);
  public long getBalance();
}