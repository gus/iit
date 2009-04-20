package com.virgilmedia.inventory;

import java.util.HashMap;

import junit.framework.TestCase;

public class InventoryTest extends TestCase {
  protected Inventory inventory = null;
  
  protected void setUp() throws Exception {
    super.setUp();
    HashMap data = new HashMap();
    data.put("homepage//728x90-20071201", new InventoryData(200000, 300000));
    data.put("sports/soccer/300x250-20071201", new InventoryData(25000, 0));
    data.put("sports/soccer/300x250-20071203", new InventoryData(12000, 0));
    Store store = new FakeStore(data);
    
    inventory = new Inventory(store);
  }
  
  public void testAvailableHomepageInventory() throws Exception {
    int available = inventory.getAvailable("homepage//728x90", "20071201");
    assertEquals(200000, available);

    available = inventory.getAvailable("sports/soccer/300x250", "20071201");
    assertEquals(25000, available);

    available = inventory.getAvailable("sports/soccer/300x250", "20071203");
    assertEquals(12000, available);
  }

  public void testProjectedInventory() throws Exception {
    int projected = inventory.getProjected("homepage//728x90", "20071201");
    assertEquals(300000, projected);
  }

  public void testAvailableInventoryForNullPlacement() throws Exception {
    try {
      inventory.getAvailable("", "");
      fail("Should not get here");
    } catch (InventoryNotFoundException e) {
      assertNotNull(e);
    }
  }
}
