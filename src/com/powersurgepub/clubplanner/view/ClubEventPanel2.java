package com.powersurgepub.clubplanner.view;

  import com.powersurgepub.clubplanner.*;
  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psdatalib.ui.*;
  import java.awt.*;
  import javax.swing.*;
 
/**
 A panel displaying some of an item's fields, and allowing the user to modify those fields.
 
 Generated by PSTextMerge using item-panel.java.

 @author Herb Bowie
 */
public class ClubEventPanel2
		extends
			JPanel {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: fields.xls
   */
 

  private JLabel    teaserLabel    = new JLabel("Teaser:", JLabel.LEFT);
  private JScrollPane teaserScrollPane = new javax.swing.JScrollPane();
  private JTextArea teaserJTextArea = new JTextArea();

  private JLabel    blurbLabel    = new JLabel("Blurb:", JLabel.LEFT);
  private JScrollPane blurbScrollPane = new javax.swing.JScrollPane();
  private JTextArea blurbJTextArea = new JTextArea();

  private JLabel    whyLabel    = new JLabel("Why:", JLabel.LEFT);
  private JScrollPane whyScrollPane = new javax.swing.JScrollPane();
  private JTextArea whyJTextArea = new JTextArea();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();

  /**
   A constructor without any arguments.
   */
  public ClubEventPanel2() {
 
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
     data file: fields.xls
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
    gb.setRowWeight(0.25);
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
    gb.setRowWeight(0.25);
    gb.add(blurbScrollPane);

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
    gb.setRowWeight(0.25);
    gb.add(whyScrollPane);

    gb.setWidth(2);
    gb.setFill(GridBagConstraints.BOTH);
    gb.setColumnWeight(1.0);
    gb.setRowWeight(0.1);
    gb.add(bottomFiller);
 
  }
 

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-display.java
     data file: fields.xls
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
    if (clubEvent.hasWhy()) {
      whyJTextArea.setText (clubEvent.getWhy().toString());
    } else {
      whyJTextArea.setText ("");
    }
    whyJTextArea.setCaretPosition(0);
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: fields.xls
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
    if (! clubEvent.getWhyAsString().equals (whyJTextArea.getText())) {
      clubEvent.setWhy(whyJTextArea.getText());
      modified = true;
    }

    return modified;
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-get.java
     data file: fields.xls
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
    Returns the why for this club event.
 
    @return The why for this club event.
   */
  public JTextArea getWhyJTextArea () {
    return whyJTextArea;
  }

}
