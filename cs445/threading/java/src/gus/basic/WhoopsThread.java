package gus.basic;

// java -cp bin gus.basic.WhoopsThread
public class WhoopsThread extends Thread {
  private String message = null;
  private long sleepTimeMs = 0;

  public WhoopsThread(long sleepTimeMs) {
    this.message = message;
    this.sleepTimeMs = sleepTimeMs;
  }

  // Uncomment for example
  public void run() {
    // System.out.println("started");
    // while(true) {
    //   try {
    //     System.out.println(this.message);
    //     sleep(sleepTimeMs);
    //   } catch (InterruptedException e) {
    //     System.out.println("interrupted");
    //   }
    // }
    // System.out.println("stopped"); # We'll never reach this line
  }

  public static void main(String [] args) {
    Thread whoops = new WhoopsThread(500);
    whoops.start();
    whoops.interrupt();
  }
}
