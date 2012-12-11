package com.powersurgepub.clubplanner.view;

  import com.powersurgepub.clubplanner.*;
  import com.powersurgepub.clubplanner.model.*;
  import com.powersurgepub.psdatalib.ui.*;
  import java.awt.*;
  import javax.swing.*;
 
/**
 A panel displaying some of an item's fields, and allowing the user to modify those fields.
 
 Generated by PSTextMerge using item-panel.java.

 @author Herb Bowie
 */
public class ClubEventPanel4
		extends
			JPanel {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: fields.xls
   */
 

  private JLabel    idLabel    = new JLabel("ID:", JLabel.LEFT);
  private JTextField idJTextField = new JTextField();

  private JLabel    linkLabel    = new JLabel("Link:", JLabel.LEFT);
  private JTextField linkJTextField = new JTextField();

  private JLabel    venueLabel    = new JLabel("Venue:", JLabel.LEFT);
  private JTextField venueJTextField = new JTextField();

  private JLabel    imageLabel    = new JLabel("Image:", JLabel.LEFT);
  private JTextField imageJTextField = new JTextField();

  private JLabel    newsImageLabel    = new JLabel("News Image:", JLabel.LEFT);
  private JTextField newsImageJTextField = new JTextField();

  private JLabel    discussLabel    = new JLabel("Discuss:", JLabel.LEFT);
  private JTextField discussJTextField = new JTextField();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();

  /**
   A constructor without any arguments.
   */
  public ClubEventPanel4() {
 
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
 

		// Panel Layout for ID
    idLabel.setLabelFor(idJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(idLabel);
    idJTextField.setToolTipText("After the event has been added to the club web site, the ID assigned to the page by the Content Management System should be entered here.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(idJTextField);

		// Panel Layout for Link
    linkLabel.setLabelFor(linkJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(linkLabel);
    linkJTextField.setToolTipText("A URL pointing to a Web page with more information about the event.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(linkJTextField);

		// Panel Layout for Venue
    venueLabel.setLabelFor(venueJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(venueLabel);
    venueJTextField.setToolTipText("A URL pointing to a Web page with more information about the venue for the event.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(venueJTextField);

		// Panel Layout for Image
    imageLabel.setLabelFor(imageJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(imageLabel);
    imageJTextField.setToolTipText("A URL pointing to an image that can be used to help advertise the event.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(imageJTextField);

		// Panel Layout for News Image
    newsImageLabel.setLabelFor(newsImageJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(newsImageLabel);
    newsImageJTextField.setToolTipText("A URL pointing to an image suitable for use in our newsletter.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(newsImageJTextField);

		// Panel Layout for Discuss
    discussLabel.setLabelFor(discussJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.setTopInset(8);
    gb.add(discussLabel);
    discussJTextField.setToolTipText("Identification of any issues to be discussed at an upcoming board meeting.");
    gb.setWidth(3);
    gb.setTopInset(4);
    gb.add(discussJTextField);

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
 
    if (clubEvent.hasId()) {
      idJTextField.setText (clubEvent.getId().toString());
    } else {
      idJTextField.setText ("");
    }
    if (clubEvent.hasLink()) {
      linkJTextField.setText (clubEvent.getLink().toString());
    } else {
      linkJTextField.setText ("");
    }
    if (clubEvent.hasVenue()) {
      venueJTextField.setText (clubEvent.getVenue().toString());
    } else {
      venueJTextField.setText ("");
    }
    if (clubEvent.hasImage()) {
      imageJTextField.setText (clubEvent.getImage().toString());
    } else {
      imageJTextField.setText ("");
    }
    if (clubEvent.hasNewsImage()) {
      newsImageJTextField.setText (clubEvent.getNewsImage().toString());
    } else {
      newsImageJTextField.setText ("");
    }
    if (clubEvent.hasDiscuss()) {
      discussJTextField.setText (clubEvent.getDiscuss().toString());
    } else {
      discussJTextField.setText ("");
    }
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: fields.xls
   */
 
  public boolean modIfChanged (ClubEvent clubEvent) {
 
    if (! clubEvent.getIdAsString().equals (idJTextField.getText())) {
      clubEvent.setId(idJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getLinkAsString().equals (linkJTextField.getText())) {
      clubEvent.setLink(linkJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getVenueAsString().equals (venueJTextField.getText())) {
      clubEvent.setVenue(venueJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getImageAsString().equals (imageJTextField.getText())) {
      clubEvent.setImage(imageJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getNewsImageAsString().equals (newsImageJTextField.getText())) {
      clubEvent.setNewsImage(newsImageJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getDiscussAsString().equals (discussJTextField.getText())) {
      clubEvent.setDiscuss(discussJTextField.getText());
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
    Returns the id for this club event.
 
    @return The id for this club event.
   */
  public JTextField getIdJTextField () {
    return idJTextField;
  }

  /**
    Returns the link for this club event.
 
    @return The link for this club event.
   */
  public JTextField getLinkJTextField () {
    return linkJTextField;
  }

  /**
    Returns the venue for this club event.
 
    @return The venue for this club event.
   */
  public JTextField getVenueJTextField () {
    return venueJTextField;
  }

  /**
    Returns the image for this club event.
 
    @return The image for this club event.
   */
  public JTextField getImageJTextField () {
    return imageJTextField;
  }

  /**
    Returns the news image for this club event.
 
    @return The news image for this club event.
   */
  public JTextField getNewsImageJTextField () {
    return newsImageJTextField;
  }

  /**
    Returns the discuss for this club event.
 
    @return The discuss for this club event.
   */
  public JTextField getDiscussJTextField () {
    return discussJTextField;
  }

}
