package gus.worker;

import java.util.*;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ConsumerTest extends TestCase {

  private Consumer consumer;
  private Thread consumerThread;
  private Queue<String> mockQueue;

  public void setUp() {
    mockQueue = mock(Queue.class);
    consumer = new Consumer(mockQueue);
    consumerThread = new Thread(consumer);
  }

  public void tearDown() {
    consumerThread.interrupt();
  }
  
  public void testShouldCreateNewConsumer() throws Exception {
    assertNotNull(new Consumer(mockQueue));
  }
  
  public void testShouldTryToGrabOneConsumableAtStartup() throws Exception {
    consumerThread.start();
    sleep();
    verify(mockQueue).poll();
  }

  private void sleep() throws InterruptedException {
    Thread.sleep(10);
  }
}
