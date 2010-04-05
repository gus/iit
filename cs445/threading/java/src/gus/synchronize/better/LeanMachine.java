package gus.synchronize.better;

public class LeanMachine extends Thread {
  private String name;
  private BetterAccount account;
  private long amountToWithdraw;

  public LeanMachine(String name, BetterAccount account, long amountToWithdraw) {
    this.name = name;
    this.account = account;
    this.amountToWithdraw = amountToWithdraw;
    start();
  }

  // Why is this better?
  public void run() {
    // This is cheating :) Use a NullObject, instead
    WithdrawResponse response = new WithdrawResponse(-1, -1);
    while(response.amount != 0) {
      response = account.withdraw(amountToWithdraw);
      printReceipt("Deducted: " + response.amount + " Remaining: " + response.balance);
    }
    printReceipt("Final: " + account.getBalance());
  }

  private void printReceipt(String note) {
    System.out.println("machine " + name + " - " + note);
  }
}
