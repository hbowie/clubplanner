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
public class EventActionPanel1
		extends
			JPanel
		implements
			DateOwner {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  private JLabel    numberedLabel    = new JLabel("Numbered:", JLabel.LEFT);
  private JCheckBox numberedJCheckBox = new JCheckBox();
  private JLabel    actioneeLabel    = new JLabel("Actionee:", JLabel.LEFT);
  private JTextField actioneeJTextField = new JTextField();
  private JLabel    actionLabel    = new JLabel("Action:", JLabel.LEFT);
  private JTextField actionJTextField = new JTextField();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();
	
	private     JFrame              frame;
	
	private     LinkTweaker         linkTweaker = null;

  /**
   The constructor.
   */
  public EventActionPanel1(JFrame frame, LinkTweaker linkTweaker) {
 
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
 

		// Panel Layout for Actionee
    actioneeLabel.setLabelFor(actioneeJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(actioneeLabel);
    actioneeJTextField.setToolTipText("The person(s) repsponsible to take the indicated action");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(actioneeJTextField);

		// Panel Layout for Action
    actionLabel.setLabelFor(actionJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(actionLabel);
    actionJTextField.setToolTipText("The action to be taken.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(actionJTextField);

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
  public void display (EventAction eventAction) {
 
    modified = false;
 
    if (eventAction.hasNumbered()) {
      numberedJCheckBox.setText (eventAction.getNumbered().toString());
    } else {
      numberedJCheckBox.setText ("");
    }
    if (eventAction.hasActionee()) {
      actioneeJTextField.setText (eventAction.getActionee().toString());
    } else {
      actioneeJTextField.setText ("");
    }
    if (eventAction.hasAction()) {
      actionJTextField.setText (eventAction.getAction().toString());
    } else {
      actionJTextField.setText ("");
    }
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: /Users/hbowie/Java/projects/nbproj/clubplanner/javagen/fields.xls
   */
 
  public boolean modIfChanged (EventAction eventAction) {
 

    if (! eventAction.getNumberedAsString().equals (numberedJCheckBox.getText())) {
      eventAction.setNumbered(numberedJCheckBox.getText());
      modified = true;
    }

    if (! eventAction.getActioneeAsString().equals (actioneeJTextField.getText())) {
      eventAction.setActionee(actioneeJTextField.getText());
      modified = true;
    }

    if (! eventAction.getActionAsString().equals (actionJTextField.getText())) {
      eventAction.setAction(actionJTextField.getText());
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
    Returns the numbered for this event action.
 
    @return The numbered for this event action.
   */
  public JCheckBox getNumberedJCheckBox () {
    return numberedJCheckBox;
  }

  /**
    Returns the actionee for this event action.
 
    @return The actionee for this event action.
   */
  public JTextField getActioneeJTextField () {
    return actioneeJTextField;
  }

  /**
    Returns the action for this event action.
 
    @return The action for this event action.
   */
  public JTextField getActionJTextField () {
    return actionJTextField;
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
