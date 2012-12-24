package com.powersurgepub.clubplanner.model;

  import java.util.*;

/**
  A pointer to a =$itemclass&c uul.
 
  This item class definition generated by PSTextMerge using:
 
     template:  item-proxy-class.java
     data file: fields.xls

  @author Herb Bowie
 */
public class ClubEventProxy {
 
  private int itemIndex = -1;
 
  public ClubEventProxy() {
 
  }
 
  public ClubEventProxy(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public void setItemIndex(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public int getItemIndex() {
    return itemIndex;
  }
 
  public ClubEvent getItem(List<ClubEvent> list) {
    if (itemIndex < 0 || itemIndex >= list.size()) {
      return null;
    } else {
      return list.get(itemIndex);
    }
  }

}
