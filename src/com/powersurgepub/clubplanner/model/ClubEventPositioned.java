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
  import com.powersurgepub.psdatalib.pstags.TagsNode;
 
/**

 Consists of an ClubEvent item and information to position it within the
 ClubEventList. <p>
 
    This item mater positioned class generated by PSTextMerge using: <p>
 
     template:  master-positioned.java <p>
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls

 */
public class ClubEventPositioned {

  public static final int NAVIGATE_USING_LIST = 1;
  public static final int NAVIGATE_USING_TREE = 2;

  private   ClubEvent  clubEvent;
  private   int      index;
  private   TagsNode tagsNode;
  private   int      navigator = NAVIGATE_USING_LIST;
  private   boolean  newItem = true;

  public ClubEventPositioned () {
    this.clubEvent = new ClubEvent();
    this.index = -1;
    this.tagsNode = null;
  }

  public ClubEventPositioned (ClubEvent clubEvent, int index) {
    this.clubEvent = clubEvent;
    this.index = index;
    this.tagsNode = clubEvent.getTagsNode();
    newItem = false;
  }

  public void setClubEvent (ClubEvent clubEvent) {
    this.clubEvent = clubEvent;
    if (clubEvent != null && clubEvent.hasKey()) {
      newItem = false;
    }
  }

  public ClubEvent getClubEvent () {
    return clubEvent;
  }

  public void setIndex (int index) {
    this.index = index;
  }

  public void incrementIndex (int increment) {
    this.index = index + increment;
  }

  public boolean hasValidIndex (ClubEventList clubEvents) {
    return (index >= 0 && index < clubEvents.size());
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

  public void setNewClubEvent (boolean newItem) {
    this.newItem = newItem;
  }

  public boolean isNewClubEvent () {
    return newItem;
  }

}
