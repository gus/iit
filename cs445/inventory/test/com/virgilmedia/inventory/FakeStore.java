package com.virgilmedia.inventory;

import java.util.HashMap;

public class FakeStore implements Store {

  private final HashMap data;

  public FakeStore(HashMap data) {
    this.data = data;
  }

  public InventoryData lookup(String key, String date) {
    return (InventoryData) data.get(key + "-" + date);
  }

}