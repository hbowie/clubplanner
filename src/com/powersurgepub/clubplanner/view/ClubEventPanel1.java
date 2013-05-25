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
public class ClubEventPanel1
		extends
			JPanel
		implements
			DateOwner {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  private JLabel    itemTypeLabel    = new JLabel("Item Type:", JLabel.LEFT);
  private PSComboBox itemTypePSComboBox = new PSComboBox();
  private JLabel    categoryLabel    = new JLabel("Category:", JLabel.LEFT);
  private PSComboBox categoryPSComboBox = new PSComboBox();
  private JLabel    seqLabel    = new JLabel("Seq:", JLabel.LEFT);
  private JLabel seqJLabel = new JLabel();
  private JLabel    statusLabel    = new JLabel("Status:", JLabel.LEFT);
  private TextSelector statusTextSelector = new TextSelector();
  private JLabel    whenLabel    = new JLabel("When:", JLabel.LEFT);
  private JTextField whenJTextField = new JTextField();
  private JLabel    ymdLabel    = new JLabel("YMD:", JLabel.LEFT);
  private JLabel ymdJLabel = new JLabel();
  private JLabel    whatLabel    = new JLabel("What:", JLabel.LEFT);
  private JTextField whatJTextField = new JTextField();
  private JLabel    whereLabel    = new JLabel("Where:", JLabel.LEFT);
  private JTextField whereJTextField = new JTextField();
  private JLabel    whoLabel    = new JLabel("Who:", JLabel.LEFT);
  private JScrollPane whoScrollPane = new javax.swing.JScrollPane();
  private JTextArea whoJTextArea = new JTextArea();
  private JLabel    discussLabel    = new JLabel("Discuss:", JLabel.LEFT);
  private JScrollPane discussScrollPane = new javax.swing.JScrollPane();
  private JTextArea discussJTextArea = new JTextArea();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker = null;

  /**
   The constructor.
   */
  public ClubEventPanel1(JFrame frame, LinkTweaker linkTweaker) {
 
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
 

		// Panel Layout for Item Type
    itemTypeLabel.setLabelFor(itemTypePSComboBox);
    itemTypePSComboBox.load (ClubEvent.class, "itemtype.txt");
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(itemTypeLabel);
    itemTypePSComboBox.setToolTipText("The type of item.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(itemTypePSComboBox);

		// Panel Layout for Category
    categoryLabel.setLabelFor(categoryPSComboBox);
    categoryPSComboBox.load (ClubEvent.class, "category.txt");
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(categoryLabel);
    categoryPSComboBox.setToolTipText("The category assigned to the event.");
    gb.setWidth(1);
    gb.setTopInset(4);
    gb.add(categoryPSComboBox);

		// Panel Layout for Seq
    seqLabel.setLabelFor(seqJLabel);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(seqLabel);
    seqJLabel.setToolTipText("The sequence of discussion at a Board meeting.");
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(seqJLabel);

		// Panel Layout for Status
    statusLabel.setLabelFor(statusTextSelector);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(statusLabel);
    statusTextSelector.setToolTipText("One or more tags indicating the status of the event.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(statusTextSelector);

		// Panel Layout for When
    whenLabel.setLabelFor(whenJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(whenLabel);
    whenJTextField.setToolTipText("An indication of the date and time that the event will be held, in a format emphasizing human readability, such as Fri Aug 10 7:00 PM - 10:00.");
    gb.setWidth(1);
    gb.setTopInset(4);
    gb.add(whenJTextField);

		// Panel Layout for YMD
    ymdLabel.setLabelFor(ymdJLabel);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(ymdLabel);
    ymdJLabel.setToolTipText("A full or partial date in year, month, day sequence.");
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(ymdJLabel);

		// Panel Layout for What
    whatLabel.setLabelFor(whatJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(whatLabel);
    whatJTextField.setToolTipText("A brief descriptive title for the event.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(whatJTextField);

		// Panel Layout for Where
    whereLabel.setLabelFor(whereJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(whereLabel);
    whereJTextField.setToolTipText("The location of the event, including the name of the venue and its address.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(whereJTextField);

		// Panel Layout for Who
    whoLabel.setLabelFor(whoJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(whoLabel);
    whoJTextArea.setColumns(20);
    whoJTextArea.setLineWrap(true);
    whoJTextArea.setRows(3);
    whoJTextArea.setWrapStyleWord(true);
    whoJTextArea.setToolTipText("Who is assigned to plan, coordinate and host the event. Can include multiple names. Can include email addresses and phone numbers.");
    whoScrollPane.setViewportView(whoJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(whoScrollPane);

		// Panel Layout for Discuss
    discussLabel.setLabelFor(discussJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(discussLabel);
    discussJTextArea.setColumns(20);
    discussJTextArea.setLineWrap(true);
    discussJTextArea.setRows(6);
    discussJTextArea.setWrapStyleWord(true);
    discussJTextArea.setToolTipText("Identification of any issues to be discussed at an upcoming board meeting.");
    discussScrollPane.setViewportView(discussJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(discussScrollPane);

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
 
    if (clubEvent.hasItemType()) {
      itemTypePSComboBox.setText (clubEvent.getItemType().toString());
    } else {
      itemTypePSComboBox.setText ("");
    }
    if (clubEvent.hasCategory()) {
      categoryPSComboBox.setText (clubEvent.getCategory().toString());
    } else {
      categoryPSComboBox.setText ("");
    }
    if (clubEvent.hasSeq()) {
      seqJLabel.setText (clubEvent.getSeq().toString());
    } else {
      seqJLabel.setText ("");
    }
    if (clubEvent.hasStatus()) {
      statusTextSelector.setText (clubEvent.getStatus().toString());
    } else {
      statusTextSelector.setText ("");
    }
    if (clubEvent.hasWhen()) {
      whenJTextField.setText (clubEvent.getWhen().toString());
    } else {
      whenJTextField.setText ("");
    }
    if (clubEvent.hasYmd()) {
      ymdJLabel.setText (clubEvent.getYmd().toString());
    } else {
      ymdJLabel.setText ("");
    }
    if (clubEvent.hasWhat()) {
      whatJTextField.setText (clubEvent.getWhat().toString());
    } else {
      whatJTextField.setText ("");
    }
    if (clubEvent.hasWhere()) {
      whereJTextField.setText (clubEvent.getWhere().toString());
    } else {
      whereJTextField.setText ("");
    }
    if (clubEvent.hasWho()) {
      whoJTextArea.setText (clubEvent.getWho().toString());
    } else {
      whoJTextArea.setText ("");
    }
    whoJTextArea.setCaretPosition(0);
    if (clubEvent.hasDiscuss()) {
      discussJTextArea.setText (clubEvent.getDiscuss().toString());
    } else {
      discussJTextArea.setText ("");
    }
    discussJTextArea.setCaretPosition(0);
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  public boolean modIfChanged (ClubEvent clubEvent) {
 

    if (! clubEvent.getItemTypeAsString().equals (itemTypePSComboBox.getText())) {
      clubEvent.setItemType(itemTypePSComboBox.getText());
      modified = true;
    }

    if (! clubEvent.getCategoryAsString().equals (categoryPSComboBox.getText())) {
      clubEvent.setCategory(categoryPSComboBox.getText());
      modified = true;
    }

    if (! clubEvent.getSeqAsString().equals (seqJLabel.getText())) {
      clubEvent.setSeq(seqJLabel.getText());
      modified = true;
    }

    if (! clubEvent.getStatusAsString().equals (statusTextSelector.getText())) {
      clubEvent.setStatus(statusTextSelector.getText());
      modified = true;
    }

    if (! clubEvent.getWhenAsString().equals (whenJTextField.getText())) {
      clubEvent.setWhen(whenJTextField.getText());
      modified = true;
    }

    if (! clubEvent.getYmdAsString().equals (ymdJLabel.getText())) {
      clubEvent.setYmd(ymdJLabel.getText());
      modified = true;
    }

    if (! clubEvent.getWhatAsString().equals (whatJTextField.getText())) {
      clubEvent.setWhat(whatJTextField.getText());
      modified = true;
    }

    if (! clubEvent.getWhereAsString().equals (whereJTextField.getText())) {
      clubEvent.setWhere(whereJTextField.getText());
      modified = true;
    }

    if (! clubEvent.getWhoAsString().equals (whoJTextArea.getText())) {
      clubEvent.setWho(whoJTextArea.getText());
      modified = true;
    }

    if (! clubEvent.getDiscussAsString().equals (discussJTextArea.getText())) {
      clubEvent.setDiscuss(discussJTextArea.getText());
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
    Returns the item type for this club event.
 
    @return The item type for this club event.
   */
  public PSComboBox getItemTypePSComboBox () {
    return itemTypePSComboBox;
  }

  /**
    Returns the category for this club event.
 
    @return The category for this club event.
   */
  public PSComboBox getCategoryPSComboBox () {
    return categoryPSComboBox;
  }

  /**
    Returns the seq for this club event.
 
    @return The seq for this club event.
   */
  public JLabel getSeqJLabel () {
    return seqJLabel;
  }

  /**
    Returns the status for this club event.
 
    @return The status for this club event.
   */
  public TextSelector getStatusTextSelector () {
    return statusTextSelector;
  }

  /**
    Returns the when for this club event.
 
    @return The when for this club event.
   */
  public JTextField getWhenJTextField () {
    return whenJTextField;
  }

  /**
    Returns the ymd for this club event.
 
    @return The ymd for this club event.
   */
  public JLabel getYmdJLabel () {
    return ymdJLabel;
  }

  /**
    Returns the what for this club event.
 
    @return The what for this club event.
   */
  public JTextField getWhatJTextField () {
    return whatJTextField;
  }

  /**
    Returns the where for this club event.
 
    @return The where for this club event.
   */
  public JTextField getWhereJTextField () {
    return whereJTextField;
  }

  /**
    Returns the who for this club event.
 
    @return The who for this club event.
   */
  public JTextArea getWhoJTextArea () {
    return whoJTextArea;
  }

  /**
    Returns the discuss for this club event.
 
    @return The discuss for this club event.
   */
  public JTextArea getDiscussJTextArea () {
    return discussJTextArea;
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
