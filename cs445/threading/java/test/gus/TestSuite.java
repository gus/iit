package gus;

import junit.framework.Test;

public class TestSuite {
  
  public static Test suite() {
    junit.framework.TestSuite suite = new junit.framework.TestSuite();
    suite.addTestSuite(gus.worker.ConsumerTest.class);
    // suite.addTest(CreditCardTestSuite.suite());
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
