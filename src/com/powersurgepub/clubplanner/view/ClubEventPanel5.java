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

package com.powersurgepub.clubplanner.view;

  import com.powersurgepub.clubplanner.*;
  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.linktweaker.*;
  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psdatalib.ui.*;
  import java.awt.*;
  import java.util.*;
  import javax.swing.*;
 
/**
 A panel displaying some of an item's fields, and allowing the user to modify those fields. <p>
 
 Generated by PSTextMerge using item-panel.java.

 @author Herb Bowie
 */
public class ClubEventPanel5
		extends
			JPanel
		implements
			DateOwner {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  private JLabel    notesLabel    = new JLabel("Notes:", JLabel.LEFT);
  private JScrollPane notesScrollPane = new javax.swing.JScrollPane();
  private JTextArea notesJTextArea = new JTextArea();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker = null;

  /**
   The constructor.
   */
  public ClubEventPanel5(JFrame frame, LinkTweaker linkTweaker) {
 
    this.frame = frame;
    this.linkTweaker = linkTweaker;
    gb.startLayout (this, 4, 99);
    gb.setByRows(true);
		gb.setDefaultColumnWeight (0.5);
		gb.setDefaultRowWeight (0.0);
		gb.setAllInsets (4);
    gb.setFill(GridBagConstraints.HORIZONTAL);
    gb.setAnchor(GridBagConstraints.NORTHWEST);


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-layout.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 

		// Panel Layout for Notes
    notesLabel.setLabelFor(notesJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(notesLabel);
    notesJTextArea.setColumns(20);
    notesJTextArea.setLineWrap(true);
    notesJTextArea.setRows(15);
    notesJTextArea.setWrapStyleWord(true);
    notesJTextArea.setToolTipText("One or more blocks of text with information about the event. Each note should be preceded by a line like the following: -- AAUM on Feb 21 via email.");
    notesScrollPane.setViewportView(notesJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(notesScrollPane);

    gb.setWidth(4);
    gb.setFill(GridBagConstraints.BOTH);
    gb.setColumnWeight(1.0);
    gb.setRowWeight(1.0);
    gb.add(bottomFiller);
 
  }
 

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-display.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
  public void display (ClubEvent clubEvent) {
 
    modified = false;
 
    if (clubEvent.hasNotes()) {
      notesJTextArea.setText (clubEvent.getNotes().toString());
    } else {
      notesJTextArea.setText ("");
    }
    notesJTextArea.setCaretPosition(0);
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  public boolean modIfChanged (ClubEvent clubEvent) {
 

    if (! clubEvent.getNotesAsString().equals (notesJTextArea.getText())) {
      clubEvent.setNotes(notesJTextArea.getText());
      modified = true;
    }

    return modified;
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-get.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 

  /**
    Returns the notes for this club event.
 
    @return The notes for this club event.
   */
  public JTextArea getNotesJTextArea () {
    return notesJTextArea;
  }


  /**
   Set a link field to a new value after it has been tweaked.
 
   This method generated by PSTextMerge using:
 
     template:  item-panel-tweak.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
 
   @param tweakedLink The link after it has been tweaked.
   @param linkID      A string identifying the link, in case there are more
                      than one. This would be the text used in the label
                      for the link.
  */
  public void setTweakedLink (String tweakedLink, String linkID) {
  }

  /**
   To be called whenever the date is modified by DatePanel.
   */
  public void dateModified (Date date) {
 
  }
 
  /**
   Does this date have an associated rule for recurrence?
   */
  public boolean canRecur() {
    return false;
	}
 
  /**
   Provide a text string describing the recurrence rule, that can
   be used as a tool tip.
   */
  public String getRecurrenceRule() {
    return "";
  }
 
  /**
   Apply the recurrence rule to the date.
 
   @param date Date that will be incremented.
   */
  public void recur (GregorianCalendar date) {
 
  }

}
