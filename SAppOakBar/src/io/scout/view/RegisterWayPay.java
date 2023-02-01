package io.scout.view;

import io.scout.persistence.SQLWayPayQuery;
import io.scout.util.Util;

/**
 * @author Guillermo, Gómez
 */
public class RegisterWayPay extends javax.swing.JFrame {

  public RegisterWayPay() {
    initComponents();
    this.initView();
  }

  private void initView() {
    Util util = null;
    util = new Util();
    util.initView(this);
    this.textFieldDenomination.requestFocus();
  }

  private boolean controlFields() {
    String denomination = null;
    denomination = this.textFieldDenomination.getText();
    if (!denomination.isEmpty()) {
      return true;
    }
    return false;
  }

  private void clean() {
    this.textFieldDenomination.setText(null);
    this.textFieldDenomination.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    labelTitle = new javax.swing.JLabel();
    formPanel = new javax.swing.JPanel();
    labelDenomination = new javax.swing.JLabel();
    textFieldDenomination = new javax.swing.JTextField();
    buttonRegister = new javax.swing.JButton();
    buttonClean = new javax.swing.JButton();
    buttonReturn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Register Way to Pay");

    formPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelDenomination.setText("Denomination:");

    textFieldDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonRegister.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonRegister.setText("Save");
    buttonRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonRegisterActionPerformed(evt);
      }
    });

    buttonClean.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonClean.setText("Clean");
    buttonClean.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCleanActionPerformed(evt);
      }
    });

    buttonReturn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonReturn.setText("Return");
    buttonReturn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonReturnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
    formPanel.setLayout(formPanelLayout);
    formPanelLayout.setHorizontalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(labelDenomination)
          .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(formPanelLayout.createSequentialGroup()
            .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    formPanelLayout.setVerticalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelDenomination)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonRegister)
          .addComponent(buttonClean)
          .addComponent(buttonReturn))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(labelTitle)
          .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
    String denomination = null;
    Util util = null;
    SQLWayPayQuery querys = null;
    util = new Util();
    try {
      querys = new SQLWayPayQuery();
      if (this.controlFields()) {
        denomination = this.textFieldDenomination.getText();
        querys.saveWayPay(denomination);
        util.showSuccessMessage();
        this.clean();
      } else {
        util.showEmptyFieldMessage();
      }
    } catch (Exception exc) {
      System.err.println("ERROR IN VIEW: " + exc.getMessage());
      util.showErrorMessage();
    }
  }//GEN-LAST:event_buttonRegisterActionPerformed

  private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
    this.clean();
  }//GEN-LAST:event_buttonCleanActionPerformed

  private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
    ManageWayPay view = null;
    view = new ManageWayPay();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonReturnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonClean;
  private javax.swing.JButton buttonRegister;
  private javax.swing.JButton buttonReturn;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel labelDenomination;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField textFieldDenomination;
  // End of variables declaration//GEN-END:variables
}
