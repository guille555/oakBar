package io.scout.view;

import io.scout.persistence.SQLBrandQuery;
import io.scout.util.Util;

/**
 * @author Guillermo, Gómez
 */
public class RegisterBrand extends javax.swing.JFrame {

  public RegisterBrand() {
    initComponents();
    this.initView();
  }

  private void initView() {
    Util util = new Util();
    util.initView(this);
    this.textFieldName.requestFocus();
  }

  private void clean() {
    this.textFieldName.setText(null);
    this.textFieldName.requestFocus();
  }

  private boolean controlFields() {
    if (!this.textFieldName.getText().isEmpty()) {
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
    labelName = new javax.swing.JLabel();
    textFieldName = new javax.swing.JTextField();
    buttonSave = new javax.swing.JButton();
    buttonClean = new javax.swing.JButton();
    buttonReturn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Register brand");

    formPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelName.setText("Name:");

    textFieldName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonSave.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonSave.setText("Save");
    buttonSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonSaveActionPerformed(evt);
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
          .addComponent(labelName)
          .addGroup(formPanelLayout.createSequentialGroup()
            .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    formPanelLayout.setVerticalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonSave)
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
      .addGroup(layout.createSequentialGroup()
        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
    SQLBrandQuery querys = null;
    String brandName = null;
    Util util = null;
    util = new Util();
    try {
      querys = new SQLBrandQuery();
      if (this.controlFields()) {
        brandName = this.textFieldName.getText();
        querys.saveBrand(brandName);
        util.showSuccessMessage();
        this.clean();
      } else {
        util.showEmptyFieldMessage();
      }
    } catch (Exception exc) {
      System.err.println("ERROR IN VIEW: " + exc.getMessage());
      util.showErrorMessage();
    }
  }//GEN-LAST:event_buttonSaveActionPerformed

  private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
    this.clean();
  }//GEN-LAST:event_buttonCleanActionPerformed

  private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
    ManageBrands view = null;
    view = new ManageBrands();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonReturnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonClean;
  private javax.swing.JButton buttonReturn;
  private javax.swing.JButton buttonSave;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel labelName;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField textFieldName;
  // End of variables declaration//GEN-END:variables
}
