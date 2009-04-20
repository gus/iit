package gus.worker;

import java.util.*;

public class Consumer implements Runnable {
  private Queue<String> queue;

  public Consumer() {
    this.queue = new LinkedList<String>();
  }

  public synchronized void run() {
    try {
      while (true) {
        String consumable = consume();
        if (consumable == null) {
          System.out.println("I hate waiting :(");
          wait();
        } else {
          System.out.println("I'm a consumer of " + consumable);
        }
      }
    } catch (InterruptedException e) {}
  }

  private synchronized String consume() {
    return this.queue.poll();
  }

  public synchronized void addConsumable(String obj) {
    this.queue.offer(obj);
    notify();
  }
}
