package io.scout.view;

import io.scout.model.WayPay;
import io.scout.persistence.SQLWayPayQuery;
import io.scout.util.Tag;
import io.scout.util.Util;

/**
 * @author Guillermo, Gómez
 */
public class UpdateWayPay extends javax.swing.JFrame {

  private byte wayPayId;

  public UpdateWayPay() {
    initComponents();
  }

  public UpdateWayPay(byte id) {
    this();
    this.initView(id);
  }

  private void initView(byte id) {
    Util util = null;
    util = new Util();
    util.initView(this);
    this.wayPayId = id;
    this.textFieldDenomination.requestFocus();
    this.loadData(id);
  }

  private void loadData(byte id) {
    SQLWayPayQuery querys = null;
    querys = new SQLWayPayQuery();
    WayPay wayPay = querys.getWayPayById(id);
    StringBuilder text = null;
    text = new StringBuilder();
    text.append(Tag.TAG_ID.toString());
    text.append(": ");
    text.append(wayPay.getWayPayId());
    this.labelId.setText(text.toString());
    this.textFieldDenomination.setText(wayPay.getDenomination());
  }

  private boolean controlFields() {
    if (!this.textFieldDenomination.getText().isEmpty()) {
      return true;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    labelTitle = new javax.swing.JLabel();
    formPanel = new javax.swing.JPanel();
    labelDenomination = new javax.swing.JLabel();
    textFieldDenomination = new javax.swing.JTextField();
    buttonUpdate = new javax.swing.JButton();
    buttonReturn = new javax.swing.JButton();
    labelId = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Update Way to Pay");

    formPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelDenomination.setText("Denomiantion:");

    textFieldDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonUpdate.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonUpdate.setText("Update");
    buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonUpdateActionPerformed(evt);
      }
    });

    buttonReturn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonReturn.setText("Return");
    buttonReturn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonReturnActionPerformed(evt);
      }
    });

    labelId.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelId.setText("ID:");

    javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
    formPanel.setLayout(formPanelLayout);
    formPanelLayout.setHorizontalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(formPanelLayout.createSequentialGroup()
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(formPanelLayout.createSequentialGroup()
                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(labelDenomination)
                  .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(formPanelLayout.createSequentialGroup()
            .addComponent(labelId)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    formPanelLayout.setVerticalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelId)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelDenomination)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonUpdate)
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

  private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
    String denomination = null;
    boolean flagFields;
    SQLWayPayQuery querys = null;
    Util util = null;
    util = new Util();
    querys = new SQLWayPayQuery();
    flagFields = this.controlFields();
    try {
      if (flagFields) {
        denomination = this.textFieldDenomination.getText();
        querys.updateWayPay(this.wayPayId, denomination);
        util.showSuccessMessage();
        this.textFieldDenomination.requestFocus();
      } else {
        util.showEmptyFieldMessage();
      }
    } catch (Exception exc) {
      System.err.println("ERROR IN VIEW: " + exc.getMessage());
      util.showErrorMessage();
    }
  }//GEN-LAST:event_buttonUpdateActionPerformed

  private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
    ManageWayPay view = null;
    view = new ManageWayPay();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonReturnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonReturn;
  private javax.swing.JButton buttonUpdate;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel labelDenomination;
  private javax.swing.JLabel labelId;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField textFieldDenomination;
  // End of variables declaration//GEN-END:variables
}
