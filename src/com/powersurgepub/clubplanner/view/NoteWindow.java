/*
 * Copyright 2014 - 2014 Herb Bowie
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
  import com.powersurgepub.psutils.*;
  import java.awt.*;
  import java.awt.event.*;
  import java.util.*;
  import javax.swing.*;

/**
 A window that can be used to add a note to an event. 

 @author Herb Bowie
 */
public class NoteWindow 
  extends 
    javax.swing.JFrame
  implements
      ActionListener,
			DateOwner,
      WindowToManage {
  
  private JLabel    noteForLabel    = new JLabel("Note For:", JLabel.LEFT);
  private DatePanel noteForDatePanel;
  private JLabel    noteFromLabel    = new JLabel("Note From:", JLabel.LEFT);
  private JTextField noteFromJTextField = new JTextField();
  private JLabel    noteViaLabel    = new JLabel("Note Via:", JLabel.LEFT);
  private JComboBox noteViaComboBox    = new JComboBox();
  private JLabel    noteLabel    = new JLabel("Note:", JLabel.LEFT);
  private JScrollPane noteScrollPane = new javax.swing.JScrollPane();
  private JTextArea noteTextArea = new JTextArea();
  private JButton   addButton     = new JButton("Add Now");

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker;
  
  private     NotesPanel          notesPanel;

  /**
   Creates new form NoteWindow
   */
  public NoteWindow(JFrame frame, LinkTweaker linkTweaker, NotesPanel notesPanel) {
    
    this.frame = frame;
    this.linkTweaker = linkTweaker;
    this.notesPanel = notesPanel;
    
    initComponents();
    
    gb.startLayout (this, 4, 99);
    gb.setByRows(true);
		gb.setDefaultColumnWeight (0.5);
		gb.setDefaultRowWeight (0.0);
		gb.setAllInsets (4);
    gb.setFill(GridBagConstraints.HORIZONTAL);
    gb.setAnchor(GridBagConstraints.NORTHWEST);
    
		// Panel Layout for Note For
    noteForLabel.setLabelFor(noteForDatePanel);
    noteForDatePanel = new DatePanel(this, this);
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
    noteViaLabel.setLabelFor(noteViaComboBox);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteViaLabel);
    String[] noteViaSuggestions = {
         "E-mail",
         "Minutes",
         "Direct entry"
    };
    noteViaComboBox = new JComboBox(noteViaSuggestions);
    noteViaComboBox.setEditable(true);
    noteViaComboBox.setActionCommand("note-via");
    noteViaComboBox.addActionListener(this);
    noteViaComboBox.setToolTipText("Medium by which note was communicated.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteViaComboBox);

		// Panel Layout for Note
    noteLabel.setLabelFor(noteTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(noteLabel);
    noteTextArea.setColumns(20);
    noteTextArea.setLineWrap(true);
    noteTextArea.setRows(10);
    noteTextArea.setWrapStyleWord(true);
    noteTextArea.setToolTipText("Note itself.");
    noteScrollPane.setViewportView(noteTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(noteScrollPane);
    
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    addButton.setActionCommand("add-now");
    addButton.addActionListener(this);
    gb.add(addButton);

    // gb.setWidth(4);
    // gb.setFill(GridBagConstraints.BOTH);
    // gb.setColumnWeight(1.0);
    // gb.setRowWeight(1.0);
    // gb.add(bottomFiller);
    
  }
  
  public void actionPerformed(ActionEvent evt) {
    if (evt.getActionCommand().equals("note-via")) {
      // do nothing for now
    }
    else
    if (evt.getActionCommand().equals("add-now")) {
      EventNote newNote = new EventNote();
      modIfChanged(newNote);
      notesPanel.addNote(newNote);
      WindowMenuManager.getShared().hideAndRemove(this);
      noteTextArea.setText("");
    }
  }
  
	private void formComponentHidden(java.awt.event.ComponentEvent evt) {                                     
		WindowMenuManager.getShared().hideAndRemove(this);
	}
  
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
      noteViaComboBox.setSelectedItem(eventNote.getNoteVia().toString());
    } else {
      noteViaComboBox.setSelectedItem("");
    }
    if (eventNote.hasNote()) {
      noteTextArea.setText (eventNote.getNote().toString());
    } else {
      noteTextArea.setText ("");
    }
    noteTextArea.setCaretPosition(0);
 
  }
  
  public boolean modIfChanged (EventNote eventNote) {

    if (! eventNote.getNoteForAsString().equals (noteForDatePanel.getText())) {
      eventNote.setNoteFor(noteForDatePanel.getText());
      modified = true;
    }

    if (! eventNote.getNoteFromAsString().equals (noteFromJTextField.getText())) {
      eventNote.setNoteFrom(noteFromJTextField.getText());
      modified = true;
    }

    if (! eventNote.getNoteViaAsString().equals ((String)noteViaComboBox.getSelectedItem())) {
      eventNote.setNoteVia((String)noteViaComboBox.getSelectedItem());
      modified = true;
    }

    if (! eventNote.getNoteAsString().equals (noteTextArea.getText())) {
      eventNote.setNote(noteTextArea.getText());
      modified = true;
    }

    return modified;
 
  }
  
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
  public JComboBox getNoteViaJComboBox () {
    return noteViaComboBox;
  }

  /**
    Returns the note for this event note.
 
    @return The note for this event note.
   */
  public JTextArea getNoteJTextArea () {
    return noteTextArea;
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

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setTitle("Add Note");
    setMinimumSize(new java.awt.Dimension(360, 360));
    setPreferredSize(new java.awt.Dimension(600, 480));

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(0, 573, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(0, 423, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
