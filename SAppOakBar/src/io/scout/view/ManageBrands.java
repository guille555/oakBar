package io.scout.view;

import io.scout.model.Brand;
import io.scout.persistence.SQLBrandQuery;
import io.scout.util.Util;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Guillermo, Gómez
 */
public class ManageBrands extends javax.swing.JFrame {

  private final String[] HEADERS = {"NAME"};
  private List<Brand> listBrands = null;

  public ManageBrands() {
    initComponents();
    this.initView();
  }

  private void initView() {
    Util util = null;
    util = new Util();
    util.initView(this);
    util.configTable(this.tableBrands, this.HEADERS);
    this.loadTable("");
    this.configDetail();
    this.textFieldSearchName.requestFocus();
  }

  private void clean() {
    this.textFieldSearchName.setText(null);
    this.textFieldSearchName.requestFocus();
  }

  private void loadTable(String name) {
    Util util = null;
    util = new Util();
    String[] data = null;
    SQLBrandQuery querys = null;
    DefaultTableModel defaultTableModel = null;
    data = new String[1];
    querys = new SQLBrandQuery();
    util.configTable(this.tableBrands, this.HEADERS);
    defaultTableModel = util.getDefaultTableModel(this.tableBrands);
    this.listBrands = querys.getAllBrandsByName(name);
    for (Brand brand : this.listBrands) {
      data[0] = brand.getBrandName();
      defaultTableModel.addRow(data);
    }
  }

  private void showDetail(int row) {
    short id;
    DetailBrand view = null;
    id = this.listBrands.get(row).getBrandId();
    view = new DetailBrand(id);
    view.setVisible(true);
    this.dispose();
  }

  private void configDetail() {
    this.tableBrands.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        int row;
        row = tableBrands.rowAtPoint(mouseEvent.getPoint());
        if ((mouseEvent.getClickCount() == 2) && (row != -1)) {
          showDetail(row);
        }
      }
    });
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    labelTitle = new javax.swing.JLabel();
    panelControl = new javax.swing.JPanel();
    labelSearch = new javax.swing.JLabel();
    textFieldSearchName = new javax.swing.JTextField();
    buttonSearch = new javax.swing.JButton();
    buttonRegister = new javax.swing.JButton();
    buttonUpdate = new javax.swing.JButton();
    buttonErase = new javax.swing.JButton();
    labelName = new javax.swing.JLabel();
    buttonClean = new javax.swing.JButton();
    scrollPanelBrands = new javax.swing.JScrollPane();
    tableBrands = new javax.swing.JTable();
    menuBar = new javax.swing.JMenuBar();
    menuManagement = new javax.swing.JMenu();
    menuItemBrand = new javax.swing.JMenuItem();
    menuItemDetail = new javax.swing.JMenuItem();
    menuItemProductItem = new javax.swing.JMenuItem();
    menuItemProduct = new javax.swing.JMenuItem();
    menuItemWayPay = new javax.swing.JMenuItem();
    menuReport = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitle.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
    labelTitle.setText("Brands");

    panelControl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelSearch.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
    labelSearch.setText("Search");

    textFieldSearchName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonSearch.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonSearch.setText("Search");
    buttonSearch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonSearchActionPerformed(evt);
      }
    });

    buttonRegister.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonRegister.setText("Register");
    buttonRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonRegisterActionPerformed(evt);
      }
    });

    buttonUpdate.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonUpdate.setText("Update");
    buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonUpdateActionPerformed(evt);
      }
    });

    buttonErase.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonErase.setText("Erase");
    buttonErase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonEraseActionPerformed(evt);
      }
    });

    labelName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelName.setText("Name:");

    buttonClean.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonClean.setText("Clean");
    buttonClean.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCleanActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panelControlLayout = new javax.swing.GroupLayout(panelControl);
    panelControl.setLayout(panelControlLayout);
    panelControlLayout.setHorizontalGroup(
      panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelControlLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panelControlLayout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(labelName))
          .addComponent(labelSearch)
          .addGroup(panelControlLayout.createSequentialGroup()
            .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(panelControlLayout.createSequentialGroup()
            .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonErase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(textFieldSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelControlLayout.setVerticalGroup(
      panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelControlLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelSearch)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelName)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonSearch)
          .addComponent(buttonClean))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonRegister)
          .addComponent(buttonUpdate)
          .addComponent(buttonErase))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tableBrands.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    scrollPanelBrands.setViewportView(tableBrands);

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(labelTitle)
          .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollPanelBrands, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPanelBrands, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    menuManagement.setText("Management");

    menuItemBrand.setText("Brands");
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
      .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
    String brandName = null;
    brandName = this.textFieldSearchName.getText();
    this.loadTable(brandName);
  }//GEN-LAST:event_buttonSearchActionPerformed

  private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
    RegisterBrand view = null;
    view = new RegisterBrand();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonRegisterActionPerformed

  private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
    Util util = null;
    util = new Util();
    UpdateBrand view = null;
    short id;
    int row;
    row = this.tableBrands.getSelectedRow();
    if (this.tableBrands.isRowSelected(row)) {
      id = this.listBrands.get(row).getBrandId();
      view = new UpdateBrand(id);
      view.setVisible(true);
      this.dispose();
    } else {
      util.showSelectRowMessage();
    }
  }//GEN-LAST:event_buttonUpdateActionPerformed

  private void buttonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEraseActionPerformed
    Util util = null;
    SQLBrandQuery querys = null;
    util = new Util();
    short id;
    int row;
    int result;
    row = this.tableBrands.getSelectedRow();
    if (this.tableBrands.isRowSelected(row)) {
      id = this.listBrands.get(row).getBrandId();
      result = util.getEraseAnswer();
      if (result == JOptionPane.YES_OPTION) {
        querys = new SQLBrandQuery();
        querys.eraseBrand(id);
        this.loadTable("");
      }
    } else {
      util.showSelectRowMessage();
    }
  }//GEN-LAST:event_buttonEraseActionPerformed

  private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
    this.clean();
    this.loadTable("");
  }//GEN-LAST:event_buttonCleanActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonClean;
  private javax.swing.JButton buttonErase;
  private javax.swing.JButton buttonRegister;
  private javax.swing.JButton buttonSearch;
  private javax.swing.JButton buttonUpdate;
  private javax.swing.JLabel labelName;
  private javax.swing.JLabel labelSearch;
  private javax.swing.JLabel labelTitle;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JMenuItem menuItemBrand;
  private javax.swing.JMenuItem menuItemDetail;
  private javax.swing.JMenuItem menuItemProduct;
  private javax.swing.JMenuItem menuItemProductItem;
  private javax.swing.JMenuItem menuItemWayPay;
  private javax.swing.JMenu menuManagement;
  private javax.swing.JMenu menuReport;
  private javax.swing.JPanel panelControl;
  private javax.swing.JScrollPane scrollPanelBrands;
  private javax.swing.JTable tableBrands;
  private javax.swing.JTextField textFieldSearchName;
  // End of variables declaration//GEN-END:variables
}
