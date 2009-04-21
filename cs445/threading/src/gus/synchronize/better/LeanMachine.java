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

  public void run() {
    long remaining = 0;
    while((remaining = account.withdraw(amountToWithdraw)) > 0) {
      printReceipt("Deducted: " + amountToWithdraw + " Remaining:" + remaining);
    }
    printReceipt("Final: " + String.valueOf(account.getBalance()));
  }

  private void printReceipt(String note) {
    System.out.println("machine " + name + " - " + note);
  }
}
