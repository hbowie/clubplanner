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
public class ClubEventPanel3
		extends
			JPanel {
	

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-definitions.java
     data file: fields.xls
   */
 

  private JLabel    costLabel    = new JLabel("Cost:", JLabel.LEFT);
  private JTextField costJTextField = new JTextField();

  private JLabel    purchaseLabel    = new JLabel("Purchase:", JLabel.LEFT);
  private JTextField purchaseJTextField = new JTextField();

  private JLabel    ticketsLabel    = new JLabel("Tickets:", JLabel.LEFT);
  private JTextField ticketsJTextField = new JTextField();

  private JLabel    quantityLabel    = new JLabel("Quantity:", JLabel.LEFT);
  private JTextField quantityJTextField = new JTextField();

  private JLabel    plannedIncomeLabel    = new JLabel("Planned Income:", JLabel.LEFT);
  private JTextField plannedIncomeJTextField = new JTextField();

  private JLabel    actualIncomeLabel    = new JLabel("Actual Income:", JLabel.LEFT);
  private JTextField actualIncomeJTextField = new JTextField();

  private JLabel    plannedExpenseLabel    = new JLabel("Planned Expense:", JLabel.LEFT);
  private JTextField plannedExpenseJTextField = new JTextField();

  private JLabel    actualExpenseLabel    = new JLabel("Actual Expense:", JLabel.LEFT);
  private JTextField actualExpenseJTextField = new JTextField();

  private JLabel    plannedAttendanceLabel    = new JLabel("Planned Attendance:", JLabel.LEFT);
  private JTextField plannedAttendanceJTextField = new JTextField();

  private JLabel    actualAttendanceLabel    = new JLabel("Actual Attendance:", JLabel.LEFT);
  private JTextField actualAttendanceJTextField = new JTextField();

  private JLabel    recapLabel    = new JLabel("Recap:", JLabel.LEFT);
  private JTextField recapJTextField = new JTextField();

  private     JLabel              bottomFiller   = new JLabel("");

  private     boolean             modified = false;

	private     GridBagger          gb = new GridBagger();

  /**
   A constructor without any arguments.
   */
  public ClubEventPanel3() {
 
    gb.startLayout (this, 4, 99);
    gb.setByRows(true);
		gb.setDefaultColumnWeight (0.5);
		gb.setDefaultRowWeight (0.0);
		gb.setAllInsets (4);
    gb.setFill(GridBagConstraints.HORIZONTAL);
    gb.setAnchor(GridBagConstraints.WEST);


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-layout.java
     data file: fields.xls
   */
 
    costLabel.setLabelFor(costJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(costLabel);
    costJTextField.setToolTipText("The cost per person to attend the event. If the event is free, then leave this field blank.");
    gb.setWidth(3);
    gb.add(costJTextField);
    purchaseLabel.setLabelFor(purchaseJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(purchaseLabel);
    purchaseJTextField.setToolTipText("Instructions on how to purchase tickets to the event, if any.");
    gb.setWidth(3);
    gb.add(purchaseJTextField);
    ticketsLabel.setLabelFor(ticketsJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(ticketsLabel);
    ticketsJTextField.setToolTipText("For purchasers, information on how they are to receive the tickets.");
    gb.setWidth(3);
    gb.add(ticketsJTextField);
    quantityLabel.setLabelFor(quantityJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(quantityLabel);
    quantityJTextField.setToolTipText("Number of seats or tickets available for the event; maximum number of attendees.");
    gb.setWidth(3);
    gb.add(quantityJTextField);
    plannedIncomeLabel.setLabelFor(plannedIncomeJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(plannedIncomeLabel);
    plannedIncomeJTextField.setToolTipText("The amount of money we have planned to receive for the event. Simple calculations are supported, such as $20 x 40.");
    gb.setWidth(1);
    gb.add(plannedIncomeJTextField);
    actualIncomeLabel.setLabelFor(actualIncomeJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(actualIncomeLabel);
    actualIncomeJTextField.setToolTipText("Our actual income for the event.");
    gb.setWidth(1);
    gb.add(actualIncomeJTextField);
    plannedExpenseLabel.setLabelFor(plannedExpenseJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(plannedExpenseLabel);
    plannedExpenseJTextField.setToolTipText("The amount of money we have planned/budgeted to be spent on the event.");
    gb.setWidth(1);
    gb.add(plannedExpenseJTextField);
    actualExpenseLabel.setLabelFor(actualExpenseJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(actualExpenseLabel);
    actualExpenseJTextField.setToolTipText("Our actual expenses for the event.");
    gb.setWidth(1);
    gb.add(actualExpenseJTextField);
    plannedAttendanceLabel.setLabelFor(plannedAttendanceJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(plannedAttendanceLabel);
    plannedAttendanceJTextField.setToolTipText("The number of attendees built into our planning assumptions.");
    gb.setWidth(1);
    gb.add(plannedAttendanceJTextField);
    actualAttendanceLabel.setLabelFor(actualAttendanceJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(actualAttendanceLabel);
    actualAttendanceJTextField.setToolTipText("The actual number of people who attended the event.");
    gb.setWidth(1);
    gb.add(actualAttendanceJTextField);
    recapLabel.setLabelFor(recapJTextField);
    gb.setColumnWeight(0.0);
    gb.setWidth(1);
    gb.add(recapLabel);
    recapJTextField.setToolTipText("A brief summary of how the event went. Can include lessons learned from the event.");
    gb.setWidth(3);
    gb.add(recapJTextField);

    gb.setWidth(2);
    gb.setFill(GridBagConstraints.BOTH);
    gb.setColumnWeight(1.0);
    gb.setRowWeight(1.0);
    gb.add(bottomFiller);
 
  }
 

  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-display.java
     data file: fields.xls
   */
  public void display (ClubEvent clubEvent) {
 
    modified = false;
 
    if (clubEvent.hasCost()) {
      costJTextField.setText (clubEvent.getCost().toString());
    } else {
      costJTextField.setText ("");
    }
    if (clubEvent.hasPurchase()) {
      purchaseJTextField.setText (clubEvent.getPurchase().toString());
    } else {
      purchaseJTextField.setText ("");
    }
    if (clubEvent.hasTickets()) {
      ticketsJTextField.setText (clubEvent.getTickets().toString());
    } else {
      ticketsJTextField.setText ("");
    }
    if (clubEvent.hasQuantity()) {
      quantityJTextField.setText (clubEvent.getQuantity().toString());
    } else {
      quantityJTextField.setText ("");
    }
    if (clubEvent.hasPlannedIncome()) {
      plannedIncomeJTextField.setText (clubEvent.getPlannedIncome().toString());
    } else {
      plannedIncomeJTextField.setText ("");
    }
    if (clubEvent.hasActualIncome()) {
      actualIncomeJTextField.setText (clubEvent.getActualIncome().toString());
    } else {
      actualIncomeJTextField.setText ("");
    }
    if (clubEvent.hasPlannedExpense()) {
      plannedExpenseJTextField.setText (clubEvent.getPlannedExpense().toString());
    } else {
      plannedExpenseJTextField.setText ("");
    }
    if (clubEvent.hasActualExpense()) {
      actualExpenseJTextField.setText (clubEvent.getActualExpense().toString());
    } else {
      actualExpenseJTextField.setText ("");
    }
    if (clubEvent.hasPlannedAttendance()) {
      plannedAttendanceJTextField.setText (clubEvent.getPlannedAttendance().toString());
    } else {
      plannedAttendanceJTextField.setText ("");
    }
    if (clubEvent.hasActualAttendance()) {
      actualAttendanceJTextField.setText (clubEvent.getActualAttendance().toString());
    } else {
      actualAttendanceJTextField.setText ("");
    }
    if (clubEvent.hasRecap()) {
      recapJTextField.setText (clubEvent.getRecap().toString());
    } else {
      recapJTextField.setText ("");
    }
 
  }


  /*
   Following code generated by PSTextMerge using:
 
     template:  item-panel-mod.java
     data file: fields.xls
   */
 
  public boolean modIfChanged (ClubEvent clubEvent) {
 
    if (! clubEvent.getCostAsString().equals (costJTextField.getText())) {
      clubEvent.setCost(costJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getPurchaseAsString().equals (purchaseJTextField.getText())) {
      clubEvent.setPurchase(purchaseJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getTicketsAsString().equals (ticketsJTextField.getText())) {
      clubEvent.setTickets(ticketsJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getQuantityAsString().equals (quantityJTextField.getText())) {
      clubEvent.setQuantity(quantityJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getPlannedIncomeAsString().equals (plannedIncomeJTextField.getText())) {
      clubEvent.setPlannedIncome(plannedIncomeJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getActualIncomeAsString().equals (actualIncomeJTextField.getText())) {
      clubEvent.setActualIncome(actualIncomeJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getPlannedExpenseAsString().equals (plannedExpenseJTextField.getText())) {
      clubEvent.setPlannedExpense(plannedExpenseJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getActualExpenseAsString().equals (actualExpenseJTextField.getText())) {
      clubEvent.setActualExpense(actualExpenseJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getPlannedAttendanceAsString().equals (plannedAttendanceJTextField.getText())) {
      clubEvent.setPlannedAttendance(plannedAttendanceJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getActualAttendanceAsString().equals (actualAttendanceJTextField.getText())) {
      clubEvent.setActualAttendance(actualAttendanceJTextField.getText());
      modified = true;
    }
    if (! clubEvent.getRecapAsString().equals (recapJTextField.getText())) {
      clubEvent.setRecap(recapJTextField.getText());
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
    Returns the cost for this club event.
 
    @return The cost for this club event.
   */
  public JTextField getCostJTextField () {
    return costJTextField;
  }

  /**
    Returns the purchase for this club event.
 
    @return The purchase for this club event.
   */
  public JTextField getPurchaseJTextField () {
    return purchaseJTextField;
  }

  /**
    Returns the tickets for this club event.
 
    @return The tickets for this club event.
   */
  public JTextField getTicketsJTextField () {
    return ticketsJTextField;
  }

  /**
    Returns the quantity for this club event.
 
    @return The quantity for this club event.
   */
  public JTextField getQuantityJTextField () {
    return quantityJTextField;
  }

  /**
    Returns the planned income for this club event.
 
    @return The planned income for this club event.
   */
  public JTextField getPlannedIncomeJTextField () {
    return plannedIncomeJTextField;
  }

  /**
    Returns the actual income for this club event.
 
    @return The actual income for this club event.
   */
  public JTextField getActualIncomeJTextField () {
    return actualIncomeJTextField;
  }

  /**
    Returns the planned expense for this club event.
 
    @return The planned expense for this club event.
   */
  public JTextField getPlannedExpenseJTextField () {
    return plannedExpenseJTextField;
  }

  /**
    Returns the actual expense for this club event.
 
    @return The actual expense for this club event.
   */
  public JTextField getActualExpenseJTextField () {
    return actualExpenseJTextField;
  }

  /**
    Returns the planned attendance for this club event.
 
    @return The planned attendance for this club event.
   */
  public JTextField getPlannedAttendanceJTextField () {
    return plannedAttendanceJTextField;
  }

  /**
    Returns the actual attendance for this club event.
 
    @return The actual attendance for this club event.
   */
  public JTextField getActualAttendanceJTextField () {
    return actualAttendanceJTextField;
  }

  /**
    Returns the recap for this club event.
 
    @return The recap for this club event.
   */
  public JTextField getRecapJTextField () {
    return recapJTextField;
  }

}
