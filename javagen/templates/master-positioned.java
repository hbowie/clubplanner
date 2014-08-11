<?nextrec?>
<?definegroup 1 =$itemclass$=?>
<?ifendgroup 1 ?>
<?ifnewgroup 1 ?>
<?if =$itemtype$= = "Master" ?>
<?set masterItemClass = =$itemclass$= ?>
<?output "../../src/com/powersurgepub/clubplanner/model/=$itemclass$=Positioned.java"?>
/*
 * Copyright 2012 - 2014 Herb Bowie
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
  import com.powersurgepub.psdatalib.pstags.TagsNode;
 
/**

 Consists of an =$itemclass$= item and information to position it within the
 =$itemclass$=List. <p>
 
    This item master positioned class generated by PSTextMerge using: <p>
   
     template:  =$templatefilename$= <p>
     data file: =$datafilename$=

 */
public class =$itemclass$=Positioned {

  public static final int NAVIGATE_USING_LIST = 1;
  public static final int NAVIGATE_USING_TREE = 2;

  private   =$itemclass$=  =$itemclass&clul$=;
  private   int      index;
  private   TagsNode tagsNode;
  private   int      navigator = NAVIGATE_USING_LIST;
  private   boolean  newItem = true;

  public =$itemclass$=Positioned () {
    this.=$itemclass&clul$= = new =$itemclass$=();
    this.index = -1;
    this.tagsNode = null;
  }

  public =$itemclass$=Positioned (=$itemclass$= =$itemclass&clul$=, int index) {
    this.=$itemclass&clul$= = =$itemclass&clul$=;
    this.index = index;
    this.tagsNode = =$itemclass&clul$=.getTagsNode();
    newItem = false;
  }

  public void set=$itemclass$= (=$itemclass$= =$itemclass&clul$=) {
    this.=$itemclass&clul$= = =$itemclass&clul$=;
    if (=$itemclass&clul$= != null && =$itemclass&clul$=.hasKey()) {
      newItem = false;
    }
  }

  public =$itemclass$= get=$itemclass$= () {
    return =$itemclass&clul$=;
  }

  public void setIndex (int index) {
    this.index = index;
  }

  public void incrementIndex (int increment) {
    this.index = index + increment;
  }

  public boolean hasValidIndex (=$itemclass$=List =$itemclass&clul$=s) {
    return (index >= 0 && index < =$itemclass&clul$=s.size());
  }

  public int getIndex () {
    return index;
  }

  public int getIndexForDisplay () {
    return (index + 1);
  }

  public void setTagsNode (TagsNode tagsNode) {
    this.tagsNode = tagsNode;
  }

  public TagsNode getTagsNode () {
    return tagsNode;
  }

  public void setNavigator (int navigator) {
    if (navigator == NAVIGATE_USING_TREE) {
      this.navigator = NAVIGATE_USING_TREE;
    } else {
      this.navigator = NAVIGATE_USING_LIST;
    }
  }

  public void setNavigatorToList (boolean useList) {
    this.navigator =
        useList ? NAVIGATE_USING_LIST : NAVIGATE_USING_TREE;
  }

  public int getNavigator () {
    return navigator;
  }

  public boolean navigateUsingList () {
    return (navigator == NAVIGATE_USING_LIST);
  }

  public boolean navigateUsingTree () {
    return (navigator == NAVIGATE_USING_TREE);
  }

  public void setNew=$itemclass$= (boolean newItem) {
    this.newItem = newItem;
  }

  public boolean isNew=$itemclass$= () {
    return newItem;
  }

}
