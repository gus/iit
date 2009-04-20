package gus.basic;

public class UsingAThread implements Runnable {
  private String message = null;
  private long sleepTimeMs = 0;

  public UsingAThread(String message, long sleepTimeMs) {
    this.message = message;
    this.sleepTimeMs = sleepTimeMs;
  }

  public void run() {
    System.out.println("started " + message);
    try {
      while(true) {
        System.out.println(message);
        Thread.sleep(sleepTimeMs);
      }
    } catch (InterruptedException e) {}
    System.out.println("stopped " + message);
  }

  public static void main(String [] args) {
    Thread t1 = new Thread(new UsingAThread("Hello", 500));
    Thread t2 = new Thread(new UsingAThread("world", 250));
    t1.start();
    t2.start();

    // HOW MANY THREADS DO WE HAVE NOW?
    System.out.println("done with main");
    try {Thread.sleep(5000);} catch (InterruptedException e) {}
    t1.interrupt();
    t2.interrupt();
  }
}
