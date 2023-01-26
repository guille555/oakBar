package io.scout.view;

import io.scout.util.Util;

/**
 * @author Guillermo, Gómez
 */
public class Principal extends javax.swing.JFrame {

  public Principal() {
    initComponents();
    this.initView();
  }

  private void initView() {
    Util util = new Util();
    util.initView(this);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    labelWelcome = new javax.swing.JLabel();
    menuBar = new javax.swing.JMenuBar();
    menuManagement = new javax.swing.JMenu();
    menuItemBrand = new javax.swing.JMenuItem();
    menuItemDetail = new javax.swing.JMenuItem();
    menuItemProductItem = new javax.swing.JMenuItem();
    menuItemProduct = new javax.swing.JMenuItem();
    menuItemWayPay = new javax.swing.JMenuItem();
    menuReport = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelWelcome.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelWelcome.setText("OAk BAr");

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(151, 151, 151)
        .addComponent(labelWelcome)
        .addContainerGap(168, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(44, 44, 44)
        .addComponent(labelWelcome)
        .addContainerGap(204, Short.MAX_VALUE))
    );

    menuManagement.setText("Management");

    menuItemBrand.setText("Brands");
    menuItemBrand.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemBrandActionPerformed(evt);
      }
    });
    menuManagement.add(menuItemBrand);

    menuItemDetail.setText("Details");
    menuManagement.add(menuItemDetail);

    menuItemProductItem.setText("Product Items");
    menuManagement.add(menuItemProductItem);

    menuItemProduct.setText("Products");
    menuManagement.add(menuItemProduct);

    menuItemWayPay.setText("Ways to Pay");
    menuManagement.add(menuItemWayPay);

    menuBar.add(menuManagement);

    menuReport.setText("Reports");
    menuBar.add(menuReport);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuItemBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBrandActionPerformed
    ManageBrands view = null;
    view = new ManageBrands();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_menuItemBrandActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel labelWelcome;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem menuItemBrand;
  private javax.swing.JMenuItem menuItemDetail;
  private javax.swing.JMenuItem menuItemProduct;
  private javax.swing.JMenuItem menuItemProductItem;
  private javax.swing.JMenuItem menuItemWayPay;
  private javax.swing.JMenu menuManagement;
  private javax.swing.JMenu menuReport;
  // End of variables declaration//GEN-END:variables
}
