package gus.synchronize.better;

public class WithdrawResponse {
  public long amount;
  public long balance;

  public WithdrawResponse(long amount, long balance) {
    this.amount = amount;
    this.balance = balance;
  }
}
