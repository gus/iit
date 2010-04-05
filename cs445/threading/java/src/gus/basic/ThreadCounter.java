package gus.basic;

// java -cp bin gus.basic.ThreadCounter
public class ThreadCounter implements Runnable {
  public static int COUNTER = 0;

  public void run() {
    ThreadCounter.COUNTER++;
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {}
    System.out.println(ThreadCounter.COUNTER);
    ThreadCounter.COUNTER--;
  }

  public static void main(String [] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(new ThreadCounter()).start();
    }
    System.out.println(ThreadCounter.COUNTER);
  }
}
