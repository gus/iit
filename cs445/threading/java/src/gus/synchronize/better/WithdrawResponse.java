package gus.synchronize.better;

// This is essentially a Struct
public class WithdrawResponse {
  public long amount;
  public long balance;

  public WithdrawResponse(long amount, long balance) {
    this.amount = amount;
    this.balance = balance;
  }
}
