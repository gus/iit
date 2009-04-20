package com.virgilmedia.inventory;

public interface Store {

  InventoryData lookup(String key, String date);

}
