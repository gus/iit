package gus.basic;

// java -cp bin gus.basic.ActsLikeThread
public class ActsLikeThread extends Thread {
  private String message = null;
  private long sleepTimeMs = 0;

  public ActsLikeThread(String message, long sleepTimeMs) {
    this.message = message;
    this.sleepTimeMs = sleepTimeMs;
  }

  public void run() {
    System.out.println("started " + message);
    try {
      while(true) {
        System.out.println(message);
        sleep(sleepTimeMs);
      }
    } catch (InterruptedException e) {}
    System.out.println("stopped " + message);
  }

  public static void main(String [] args) {
    Thread t1 = new ActsLikeThread("Hello", 500);
    Thread t2 = new ActsLikeThread("world", 250);
    t1.start();
    t2.start();

    System.out.println("done with main");
    try {Thread.sleep(5000);} catch (InterruptedException e) {}
    t1.interrupt();
    t2.interrupt();
  }
}
