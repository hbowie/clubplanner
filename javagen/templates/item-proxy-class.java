<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?output "../../src/com/powersurgepub/clubplanner/model/=$itemclass$=Proxy.java"?>
package com.powersurgepub.clubplanner.model;

  import com.powersurgepub.psdatalib.clubplanner.*;
  import java.util.*;

/**
  A pointer to a =$itemclass&c uul.
  
  This item class definition generated by PSTextMerge using: 
   
     template:  =$templatefilename$=
     data file: =$datafilename$=

  @author Herb Bowie
 */
public class =$itemclass$=Proxy {
  
  private int itemIndex = -1;
  
  public =$itemclass$=Proxy() {
    
  }
  
  public =$itemclass$=Proxy(int itemIndex) {
    this.itemIndex = itemIndex;
  }
  
  public void setItemIndex(int itemIndex) {
    this.itemIndex = itemIndex;
  }
  
  public int getItemIndex() {
    return itemIndex;
  }
  
  public =$itemclass$= getItem(List<=$itemclass$=> list) {
    if (itemIndex < 0 || itemIndex >= list.size()) {
      return null;
    } else {
      return list.get(itemIndex);
    }
  }

}
<?endif?>
<?loop?>
