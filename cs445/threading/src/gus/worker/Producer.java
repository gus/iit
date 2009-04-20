package gus.worker;

public class Producer extends Thread {
  private String name;
  private Consumer consumer;
  private int consumablesToCreate = 0;

  public Producer(String name, Consumer consumer, int consumablesToCreate) {
    this.name = name;
    this.consumer = consumer;
    this.consumablesToCreate = consumablesToCreate;
    start();
  }

  public void run() {
    System.out.println("started " + name);
    try {
      for (int i = 0; i < consumablesToCreate; i++) {
        sleep(i % 2);
        consumer.addConsumable(name + "-" + String.valueOf(i));
      }
    } catch (InterruptedException e) {}
    System.out.println("stopped " + name);
  }

  public static void main (String [] args) {
    Consumer consumer = new Consumer();
    Thread consumerThread = new Thread(consumer);
    consumerThread.start();
    
    new Producer("happy", consumer, 5);
    new Producer("dopey", consumer, 8);
    new Producer("skidmark", consumer, 10);
  }
}
