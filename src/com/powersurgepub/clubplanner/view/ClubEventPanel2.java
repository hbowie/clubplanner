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
public class ClubEventPanel2
		extends
			JPanel
		implements
			DateOwner {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  private JLabel    teaserLabel    = new JLabel("Teaser:", JLabel.LEFT);
  private JScrollPane teaserScrollPane = new javax.swing.JScrollPane();
  private JTextArea teaserJTextArea = new JTextArea();
  private JLabel    blurbLabel    = new JLabel("Blurb:", JLabel.LEFT);
  private JScrollPane blurbScrollPane = new javax.swing.JScrollPane();
  private JTextArea blurbJTextArea = new JTextArea();
  private JLabel    purchaseLabel    = new JLabel("Purchase:", JLabel.LEFT);
  private JScrollPane purchaseScrollPane = new javax.swing.JScrollPane();
  private JTextArea purchaseJTextArea = new JTextArea();
  private JLabel    whyLabel    = new JLabel("Why:", JLabel.LEFT);
  private JScrollPane whyScrollPane = new javax.swing.JScrollPane();
  private JTextArea whyJTextArea = new JTextArea();
  private JLabel    recapLabel    = new JLabel("Recap:", JLabel.LEFT);
  private JScrollPane recapScrollPane = new javax.swing.JScrollPane();
  private JTextArea recapJTextArea = new JTextArea();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker = null;

  /**
   The constructor.
   */
  public ClubEventPanel2(JFrame frame, LinkTweaker linkTweaker) {
 
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
 

		// Panel Layout for Teaser
    teaserLabel.setLabelFor(teaserJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(teaserLabel);
    teaserJTextArea.setColumns(20);
    teaserJTextArea.setLineWrap(true);
    teaserJTextArea.setRows(4);
    teaserJTextArea.setWrapStyleWord(true);
    teaserJTextArea.setToolTipText("One to three sentences describing the event, intended to pique the reader's interest and motivate him to read further.");
    teaserScrollPane.setViewportView(teaserJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(teaserScrollPane);

		// Panel Layout for Blurb
    blurbLabel.setLabelFor(blurbJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(blurbLabel);
    blurbJTextArea.setColumns(20);
    blurbJTextArea.setLineWrap(true);
    blurbJTextArea.setRows(8);
    blurbJTextArea.setWrapStyleWord(true);
    blurbJTextArea.setToolTipText("Additional information about the event. This field can contain multiple paragraphs, separated by blank lines.");
    blurbScrollPane.setViewportView(blurbJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(blurbScrollPane);

		// Panel Layout for Purchase
    purchaseLabel.setLabelFor(purchaseJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(purchaseLabel);
    purchaseJTextArea.setColumns(20);
    purchaseJTextArea.setLineWrap(true);
    purchaseJTextArea.setRows(4);
    purchaseJTextArea.setWrapStyleWord(true);
    purchaseJTextArea.setToolTipText("Instructions on how to purchase tickets to the event, if any.");
    purchaseScrollPane.setViewportView(purchaseJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(purchaseScrollPane);

		// Panel Layout for Why
    whyLabel.setLabelFor(whyJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(whyLabel);
    whyJTextArea.setColumns(20);
    whyJTextArea.setLineWrap(true);
    whyJTextArea.setRows(4);
    whyJTextArea.setWrapStyleWord(true);
    whyJTextArea.setToolTipText("Why does the club think that this is an event deserving of our time, attention and resources?");
    whyScrollPane.setViewportView(whyJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(whyScrollPane);

		// Panel Layout for Recap
    recapLabel.setLabelFor(recapJTextArea);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(recapLabel);
    recapJTextArea.setColumns(20);
    recapJTextArea.setLineWrap(true);
    recapJTextArea.setRows(4);
    recapJTextArea.setWrapStyleWord(true);
    recapJTextArea.setToolTipText("A brief summary of how the event went. Can include lessons learned from the event.");
    recapScrollPane.setViewportView(recapJTextArea);
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(recapScrollPane);

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
 
    if (clubEvent.hasTeaser()) {
      teaserJTextArea.setText (clubEvent.getTeaser().toString());
    } else {
      teaserJTextArea.setText ("");
    }
    teaserJTextArea.setCaretPosition(0);
    if (clubEvent.hasBlurb()) {
      blurbJTextArea.setText (clubEvent.getBlurb().toString());
    } else {
      blurbJTextArea.setText ("");
    }
    blurbJTextArea.setCaretPosition(0);
    if (clubEvent.hasPurchase()) {
      purchaseJTextArea.setText (clubEvent.getPurchase().toString());
    } else {
      purchaseJTextArea.setText ("");
    }
    purchaseJTextArea.setCaretPosition(0);
    if (clubEvent.hasWhy()) {
      whyJTextArea.setText (clubEvent.getWhy().toString());
    } else {
      whyJTextArea.setText ("");
    }
    whyJTextArea.setCaretPosition(0);
    if (clubEvent.hasRecap()) {
      recapJTextArea.setText (clubEvent.getRecap().toString());
    } else {
      recapJTextArea.setText ("");
    }
    recapJTextArea.setCaretPosition(0);
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  public boolean modIfChanged (ClubEvent clubEvent) {
 

    if (! clubEvent.getTeaserAsString().equals (teaserJTextArea.getText())) {
      clubEvent.setTeaser(teaserJTextArea.getText());
      modified = true;
    }

    if (! clubEvent.getBlurbAsString().equals (blurbJTextArea.getText())) {
      clubEvent.setBlurb(blurbJTextArea.getText());
      modified = true;
    }

    if (! clubEvent.getPurchaseAsString().equals (purchaseJTextArea.getText())) {
      clubEvent.setPurchase(purchaseJTextArea.getText());
      modified = true;
    }

    if (! clubEvent.getWhyAsString().equals (whyJTextArea.getText())) {
      clubEvent.setWhy(whyJTextArea.getText());
      modified = true;
    }

    if (! clubEvent.getRecapAsString().equals (recapJTextArea.getText())) {
      clubEvent.setRecap(recapJTextArea.getText());
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
    Returns the teaser for this club event.
 
    @return The teaser for this club event.
   */
  public JTextArea getTeaserJTextArea () {
    return teaserJTextArea;
  }

  /**
    Returns the blurb for this club event.
 
    @return The blurb for this club event.
   */
  public JTextArea getBlurbJTextArea () {
    return blurbJTextArea;
  }

  /**
    Returns the purchase for this club event.
 
    @return The purchase for this club event.
   */
  public JTextArea getPurchaseJTextArea () {
    return purchaseJTextArea;
  }

  /**
    Returns the why for this club event.
 
    @return The why for this club event.
   */
  public JTextArea getWhyJTextArea () {
    return whyJTextArea;
  }

  /**
    Returns the recap for this club event.
 
    @return The recap for this club event.
   */
  public JTextArea getRecapJTextArea () {
    return recapJTextArea;
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
