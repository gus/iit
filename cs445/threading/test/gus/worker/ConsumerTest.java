package gus.worker;

import junit.framework.TestCase;

public class ConsumerTest extends TestCase {

  public void setUp() {
  }
  
  public void tearDown() {
  }

  public void testCanCreateNewConsumer() throws Exception {
    assertNotNull(new Consumer());
  }
  
}
