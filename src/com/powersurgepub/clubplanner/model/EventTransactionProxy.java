/*
 * Copyright 2012 - 2013 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powersurgepub.clubplanner.model;

  import com.powersurgepub.psdatalib.clubplanner.*;
  import java.util.*;

/**
  A pointer to a Event Transaction. <p>
 
  This item class definition generated by PSTextMerge using: <p>
 
     template:  item-proxy-class.java <p>
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls

  @author Herb Bowie
 */
public class EventTransactionProxy {
 
  private int itemIndex = -1;
 
  public EventTransactionProxy() {
 
  }
 
  public EventTransactionProxy(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public void setItemIndex(int itemIndex) {
    this.itemIndex = itemIndex;
  }
 
  public int getItemIndex() {
    return itemIndex;
  }
 
  public EventTransaction getItem(List<EventTransaction> list) {
    if (itemIndex < 0 || itemIndex >= list.size()) {
      return null;
    } else {
      return list.get(itemIndex);
    }
  }

}
