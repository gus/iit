package com.virgilmedia.inventory;

public class Inventory {

  private final Store store;

  public Inventory(Store store) {
    this.store = store;
  }

  public int getAvailable(String key, String date) throws InventoryNotFoundException {
    InventoryData data = store.lookup(key, date);
    if (data == null)
      throw new InventoryNotFoundException();
    return data.available;
  }

  public int getProjected(String key, String date) {
    return store.lookup(key, date).projected;
  }

}
