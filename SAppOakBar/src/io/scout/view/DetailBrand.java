package io.scout.view;

import io.scout.model.Brand;
import io.scout.persistence.SQLBrandQuery;
import io.scout.util.Tag;
import io.scout.util.Util;
import java.awt.Color;

/**
 * @author Guillermo, Gómez
 */
public class DetailBrand extends javax.swing.JFrame {

  public DetailBrand() {
    initComponents();
  }

  public DetailBrand(short id) {
    this();
    this.initView(id);
  }

  private void initView(short id) {
    Util util = null;
    util = new Util();
    util.initView(this);
    this.textFieldName.setEnabled(false);
    this.loadData(id);
  }

  private void loadData(short id) {
    SQLBrandQuery querys = null;
    StringBuilder text = new StringBuilder();
    Brand brand = null;
    querys = new SQLBrandQuery();
    brand = querys.getBrandById(id);
    text.append(Tag.TAG_ID.toString());
    text.append(": ");
    text.append(brand.getBrandId());
    this.labelId.setText(text.toString());
    this.textFieldName.setText(brand.getBrandName());
    this.textFieldName.setDisabledTextColor(Color.DARK_GRAY);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    labelTitle = new javax.swing.JLabel();
    informationPanel = new javax.swing.JPanel();
    labelId = new javax.swing.JLabel();
    labelName = new javax.swing.JLabel();
    textFieldName = new javax.swing.JTextField();
    buttonReturn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Brand detail");

    informationPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelId.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelId.setText("ID:");

    labelName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelName.setText("Name:");

    textFieldName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonReturn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonReturn.setText("Return");
    buttonReturn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonReturnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
    informationPanel.setLayout(informationPanelLayout);
    informationPanelLayout.setHorizontalGroup(
      informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(informationPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(labelId)
          .addComponent(labelName)
          .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informationPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    informationPanelLayout.setVerticalGroup(
      informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(informationPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelId)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonReturn)
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
          .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      .addGroup(layout.createSequentialGroup()
        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReturnActionPerformed
    ManageBrands view = null;
    view = new ManageBrands();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonReturnActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonReturn;
  private javax.swing.JPanel informationPanel;
  private javax.swing.JLabel labelId;
  private javax.swing.JLabel labelName;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField textFieldName;
  // End of variables declaration//GEN-END:variables
}
