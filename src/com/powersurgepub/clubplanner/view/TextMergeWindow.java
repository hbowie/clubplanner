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
  import com.powersurgepub.psutils.*;
  import javax.swing.*;

/**
 A shell window to contain the various PSTextMerge tabs. 

 @author Herb Bowie
 */
public class TextMergeWindow 
  extends javax.swing.JFrame
    implements WindowToManage {
  
  private   ClubPlanner clubPlanner = null;

  /**
   Creates new form TextMergeWindow
   */
  public TextMergeWindow(ClubPlanner clubPlanner) {
    this.clubPlanner = clubPlanner;
    initComponents();
  }
  
  public TextMergeWindow (ClubPlanner clubPlanner, String title) {
    super (title);
    this.clubPlanner = clubPlanner;
    initComponents();
  }
  
  public JTabbedPane getTabs() {
    return jTabbedPane1;
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

    jTabbedPane1 = new javax.swing.JTabbedPane();

    setTitle("TextMerge");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
      public void windowActivated(java.awt.event.WindowEvent evt) {
        formWindowActivated(evt);
      }
    });
    getContentPane().setLayout(new java.awt.GridBagLayout());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    getContentPane().add(jTabbedPane1, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    clubPlanner.saveTextMergeWindowPosition();
  }//GEN-LAST:event_formWindowClosing

  private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    clubPlanner.positionTextMergeWindow();
  }//GEN-LAST:event_formWindowActivated


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTabbedPane jTabbedPane1;
  // End of variables declaration//GEN-END:variables
}