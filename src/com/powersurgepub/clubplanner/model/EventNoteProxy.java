package com.powersurgepub.clubplanner.model;

  import java.util.*;

/**
  A pointer to a =$itemclass&c uul.
 
  This item class definition generated by PSTextMerge using:
 
     template:  item-proxy-class.java
     data file: fields.xls

  @author Herb Bowie
 */
public class EventNoteProxy {
 
  private int itemIndex = -1;
 
  public EventNoteProxy() {
 
  }
 
  public EventNoteProxy(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public void setItemIndex(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public int getItemIndex() {
    return itemIndex;
  }
 
  public EventNote getItem(List<EventNote> list) {
    if (itemIndex < 0 || itemIndex >= list.size()) {
      return null;
    } else {
      return list.get(itemIndex);
    }
  }

}
