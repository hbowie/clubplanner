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
  import com.powersurgepub.psdatalib.psdata.*;
  import com.powersurgepub.psdatalib.psdata.values.*;
  import com.powersurgepub.psdatalib.psdata.widgets.*;
  import com.powersurgepub.psdatalib.ui.*;
  import java.awt.*;
  import java.util.*;
  import javax.swing.*;
 
/**
 A panel displaying some of an item's fields, and allowing the user to modify those fields. <p>
 
 Generated by PSTextMerge using item-panel.java.

 @author Herb Bowie
 */
public class EventNotePanel1
		extends
			JPanel
		implements
			DateOwner {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  private JLabel    noteForLabel    = new JLabel("Note For:", JLabel.LEFT);
  private DatePanel noteForDatePanel;
  private JLabel    noteFromLabel    = new JLabel("Note From:", JLabel.LEFT);
  private JTextField noteFromJTextField = new JTextField();
  private JLabel    noteViaLabel    = new JLabel("Note Via:", JLabel.LEFT);
  private JTextField noteViaJTextField = new JTextField();
  private JLabel    noteLabel    = new JLabel("Note:", JLabel.LEFT);
  private JScrollPane noteScrollPane = new javax.swing.JScrollPane();
  private JTextArea noteJTextArea = new JTextArea();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker = null;

  /**
   The constructor.
   */
  public EventNotePanel1(JFrame frame, LinkTweaker linkTweaker) {
 
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
 

		// Panel Layout for Note For
    noteForLabel.setLabelFor(noteForDatePanel);
    noteForDatePanel = new DatePanel(frame, this);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteForLabel);
    noteForDatePanel.setToolTipText("Date on which note was made.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteForDatePanel);

		// Panel Layout for Note From
    noteFromLabel.setLabelFor(noteFromJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteFromLabel);
    noteFromJTextField.setToolTipText("Person from whom note came.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteFromJTextField);

		// Panel Layout for Note Via
    noteViaLabel.setLabelFor(noteViaJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteViaLabel);
    noteViaJTextField.setToolTipText("Medium by which note was communicated.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteViaJTextField);

		// Panel Layout for Note
    noteLabel.setLabelFor(noteJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteLabel);
    noteJTextArea.setColumns(20);
    noteJTextArea.setLineWrap(true);
    noteJTextArea.setRows(10);
    noteJTextArea.setWrapStyleWord(true);
    noteJTextArea.setToolTipText("Note itself.");
    noteScrollPane.setViewportView(noteJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteScrollPane);

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
  public void display (EventNote eventNote) {
 
    modified = false;
 
    if (eventNote.hasNoteFor()) {
      noteForDatePanel.setText (eventNote.getNoteFor().toString());
    } else {
      noteForDatePanel.setText ("");
    }
    if (eventNote.hasNoteFrom()) {
      noteFromJTextField.setText (eventNote.getNoteFrom().toString());
    } else {
      noteFromJTextField.setText ("");
    }
    if (eventNote.hasNoteVia()) {
      noteViaJTextField.setText (eventNote.getNoteVia().toString());
    } else {
      noteViaJTextField.setText ("");
    }
    if (eventNote.hasNote()) {
      noteJTextArea.setText (eventNote.getNote().toString());
    } else {
      noteJTextArea.setText ("");
    }
    noteJTextArea.setCaretPosition(0);
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  public boolean modIfChanged (EventNote eventNote) {
 

    if (! eventNote.getNoteForAsString().equals (noteForDatePanel.getText())) {
      eventNote.setNoteFor(noteForDatePanel.getText());
      modified = true;
    }

    if (! eventNote.getNoteFromAsString().equals (noteFromJTextField.getText())) {
      eventNote.setNoteFrom(noteFromJTextField.getText());
      modified = true;
    }

    if (! eventNote.getNoteViaAsString().equals (noteViaJTextField.getText())) {
      eventNote.setNoteVia(noteViaJTextField.getText());
      modified = true;
    }

    if (! eventNote.getNoteAsString().equals (noteJTextArea.getText())) {
      eventNote.setNote(noteJTextArea.getText());
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
    Returns the note for for this event note.
 
    @return The note for for this event note.
   */
  public DatePanel getNoteForDatePanel () {
    return noteForDatePanel;
  }

  /**
    Returns the note from for this event note.
 
    @return The note from for this event note.
   */
  public JTextField getNoteFromJTextField () {
    return noteFromJTextField;
  }

  /**
    Returns the note via for this event note.
 
    @return The note via for this event note.
   */
  public JTextField getNoteViaJTextField () {
    return noteViaJTextField;
  }

  /**
    Returns the note for this event note.
 
    @return The note for this event note.
   */
  public JTextArea getNoteJTextArea () {
    return noteJTextArea;
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
