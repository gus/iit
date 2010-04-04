package gus.worker;

import java.util.*;

public class Consumer implements Runnable {
  private Queue<String> queue;

  public Consumer() {
    // How could we make this better for testing? Dependency Injection
    this(new LinkedList<String>());
  }

  public Consumer(Queue<String> queue) {
    // How could we make this better for testing? Dependency Injection
    this.queue = queue;
  }

  public synchronized void run() {
    try {
      String consumable = null;
      while (true) {
        consumable = this.queue.poll();
        if (consumable == null) {
          System.out.println("I hate waiting :(");
          wait();
        } else {
          System.out.println("I'm a consumer of " + consumable);
        }
      }
    } catch (InterruptedException e) {}
  }

  public synchronized void addConsumable(String obj) {
    this.queue.offer(obj);
    notify();
  }
}
