package com.virgilmedia.inventory;

public class InventoryData {

  public final int projected;
  public final int available;

  public InventoryData(int available, int projected) {
    this.available = available;
    this.projected = projected;
  }
  
}
