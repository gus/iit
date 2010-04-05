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

  // We could add more code and make this better
  public void run() {
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
