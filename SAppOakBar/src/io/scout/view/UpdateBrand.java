package io.scout.view;

import io.scout.model.Brand;
import io.scout.persistence.SQLBrandQuery;
import io.scout.util.Tag;
import io.scout.util.Util;

/**
 * @author Guillermo, Gómez
 */
public class UpdateBrand extends javax.swing.JFrame {

  private short brandId;

  public UpdateBrand() {
    initComponents();
  }

  public UpdateBrand(short id) {
    this();
    this.initView(id);
  }

  private void initView(short id) {
    Util util = null;
    this.brandId = id;
    util = new Util();
    util.initView(this);
    this.textFieldName.requestFocus();
    this.loadData(id);
  }

  private void loadData(short id) {
    SQLBrandQuery querys = null;
    Brand brand = null;
    StringBuilder text = null;
    querys = new SQLBrandQuery();
    text = new StringBuilder();
    brand = querys.getBrandById(id);
    text.append(Tag.TAG_ID);
    text.append(": ");
    text.append(brand.getBrandId());
    this.labelId.setText(text.toString());
    this.textFieldName.setText(brand.getBrandName());
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
    buttonUpdate = new javax.swing.JButton();
    buttonReturn = new javax.swing.JButton();
    labelId = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Update brand");

    formPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelName.setText("Name:");

    textFieldName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

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
          .addComponent(labelName)
          .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(formPanelLayout.createSequentialGroup()
            .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(112, 112, 112)
            .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(labelId))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    formPanelLayout.setVerticalGroup(
      formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelId)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      .addGroup(layout.createSequentialGroup()
        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
    String brandName = null;
    SQLBrandQuery querys = null;
    Util util = null;
    boolean flagFields;
    util = new Util();
    querys = new SQLBrandQuery();
    try {
      flagFields = this.controlFields();
      if (flagFields) {
        brandName = this.textFieldName.getText();
        querys.updateBrand(this.brandId, brandName);
        util.showSuccessMessage();
        this.textFieldName.requestFocus();
      } else {
        util.showEmptyFieldMessage();
      }
    } catch (Exception exc) {
      System.err.println("ERROR IN VIEW: " + exc.getMessage());
      util.showErrorMessage();
    }
  }//GEN-LAST:event_buttonUpdateActionPerformed

  private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
    ManageBrands view = null;
    view = new ManageBrands();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonReturnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonReturn;
  private javax.swing.JButton buttonUpdate;
  private javax.swing.JPanel formPanel;
  private javax.swing.JLabel labelId;
  private javax.swing.JLabel labelName;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField textFieldName;
  // End of variables declaration//GEN-END:variables
}
