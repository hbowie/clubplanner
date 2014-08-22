/*
 * Copyright 2014 Herb Bowie
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

package com.powersurgepub.clubplanner;

  import com.powersurgepub.psdatalib.clubplanner.*;
  import com.powersurgepub.psutils.*;
  import java.math.*;
  import java.text.*;
  import java.util.*;

/**
 A window showing financial info. 

 @author Herb Bowie. 
 */
public class FinanceWindow 
    extends javax.swing.JFrame 
        implements WindowToManage{
  
  private BigDecimal   financeProjection;
  private BigDecimal   overUnder;
  private BigDecimal   plannedIncome;
  private BigDecimal   plannedExpense;
  private BigDecimal   actualIncome;
  private BigDecimal   actualExpense;
  
  
  private NumberFormat currencyFormat 
      = NumberFormat.getCurrencyInstance(Locale.US);

  /**
   Creates new form FinanceWindow
   */
  public FinanceWindow() {

    clear();
    initComponents();
  }
  
  public void clear() {

    financeProjection = new BigDecimal(0);
    overUnder = new BigDecimal(0);
    plannedIncome = new BigDecimal(0);
    plannedExpense = new BigDecimal(0);
    actualIncome = new BigDecimal(0);
    actualExpense = new BigDecimal(0);
  }
  
  public void calcPlus(ClubEvent event) {
    
    financeProjection = financeProjection.add
        (event.getFinanceProjectionAsBigDecimal());
    
    overUnder = overUnder.add
        (event.getOverUnderAsBigDecimal());
    
    plannedIncome = plannedIncome.add 
        (event.getPlannedIncomeAsBigDecimal());
    
    plannedExpense = plannedExpense.add 
        (event.getPlannedExpenseAsBigDecimal());
    
    actualIncome = actualIncome.add 
        (event.getActualIncomeAsBigDecimal());
    
    actualExpense = actualExpense.add 
        (event.getActualExpenseAsBigDecimal());

  }
  
  public void calcMinus(ClubEvent event) {
    
    financeProjection = financeProjection.subtract
        (event.getFinanceProjectionAsBigDecimal());
    
    overUnder = overUnder.subtract
        (event.getOverUnderAsBigDecimal());
    
    plannedIncome = plannedIncome.subtract 
        (event.getPlannedIncomeAsBigDecimal());
    
    plannedExpense = plannedExpense.subtract 
        (event.getPlannedExpenseAsBigDecimal());
    
    actualIncome = actualIncome.subtract 
        (event.getActualIncomeAsBigDecimal());
    
    actualExpense = actualExpense.subtract 
        (event.getActualExpenseAsBigDecimal());
  }
  
  public void display() {

    financeProjectionText.setText (getFinanceProjection());

    overUnderText.setText (getOverUnder());
  }
  
  public String getFinanceProjection() {
    return currencyFormat.format(financeProjection.doubleValue());
  }
  
  public String getOverUnder() {
    return currencyFormat.format(overUnder.doubleValue());
  }
  
  public String getPlannedIncome() {
    return currencyFormat.format(plannedIncome.doubleValue());
  }
  
  public String getPlannedExpense() {
    return currencyFormat.format(plannedExpense.doubleValue());
  }
  
  public String getActualIncome() {
    return currencyFormat.format(actualIncome.doubleValue());
  }
  
  public String getActualExpense() {
    return currencyFormat.format(actualExpense.doubleValue());
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    financeProjectionLabel = new javax.swing.JLabel();
    financeProjectionText = new javax.swing.JLabel();
    overUnderLabel = new javax.swing.JLabel();
    overUnderText = new javax.swing.JLabel();

    setTitle("Finance Summary");
    setMinimumSize(new java.awt.Dimension(360, 240));
    getContentPane().setLayout(new java.awt.GridBagLayout());

    financeProjectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    financeProjectionLabel.setText("Total Finance Projection:");
    financeProjectionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(financeProjectionLabel, gridBagConstraints);

    financeProjectionText.setText("$0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(financeProjectionText, gridBagConstraints);

    overUnderLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    overUnderLabel.setText("Total Over/Under:");
    overUnderLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(overUnderLabel, gridBagConstraints);

    overUnderText.setText("$0.00");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
    getContentPane().add(overUnderText, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel financeProjectionLabel;
  private javax.swing.JLabel financeProjectionText;
  private javax.swing.JLabel overUnderLabel;
  private javax.swing.JLabel overUnderText;
  // End of variables declaration//GEN-END:variables
}
