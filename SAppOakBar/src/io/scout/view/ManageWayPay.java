package io.scout.view;

import io.scout.model.WayPay;
import io.scout.persistence.SQLWayPayQuery;
import io.scout.util.Util;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Guillermo, Gómez
 */
public class ManageWayPay extends javax.swing.JFrame {

  private final String[] HEADERS = {"DENOMINATION"};
  private List<WayPay> listWaysPay = null;

  public ManageWayPay() {
    initComponents();
    this.initView();
  }
  
  private void initView() {
    Util util = null;
    util = new Util();
    util.initView(this);
    this.configDetail();
    this.loadTable("");
    this.textFieldDenomination.requestFocus();
  }

  private void clean() {
    this.textFieldDenomination.setText(null);
    this.textFieldDenomination.requestFocus();
  }

  private void loadTable(String denomination) {
    Util util = null;
    String[] data = null;
    SQLWayPayQuery querys = null;
    util = new Util();
    data = new String[1];
    querys = new SQLWayPayQuery();
    DefaultTableModel defaultTableModel = null;
    util.configTable(this.tableWaysPay, this.HEADERS);
    defaultTableModel = util.getDefaultTableModel(this.tableWaysPay);
    this.listWaysPay = querys.getAllWaysPayByDenomination(denomination);
    for (WayPay wayPay : this.listWaysPay) {
      data[0] = wayPay.getDenomination();
      defaultTableModel.addRow(data);
    }
  }

  private void showDetail(int row) {
    byte id;
    DetailWayPay view = null;
    id = this.listWaysPay.get(row).getWayPayId();
    view = new DetailWayPay(id);
    view.setVisible(true);
    this.dispose();
  }

  private void configDetail() {
    this.tableWaysPay.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        int row;
        row = tableWaysPay.rowAtPoint(mouseEvent.getPoint());
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
    labelDenomination = new javax.swing.JLabel();
    textFieldDenomination = new javax.swing.JTextField();
    buttonSearch = new javax.swing.JButton();
    buttonClean = new javax.swing.JButton();
    buttonRegister = new javax.swing.JButton();
    buttonUpdate = new javax.swing.JButton();
    buttonErase = new javax.swing.JButton();
    scrollPanelWaysPay = new javax.swing.JScrollPane();
    tableWaysPay = new javax.swing.JTable();
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
    labelTitle.setText("Way to Pay");

    panelControl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

    labelSearch.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
    labelSearch.setText("Search");

    labelDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    labelDenomination.setText("Denomination:");

    textFieldDenomination.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

    buttonSearch.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonSearch.setText("Search");
    buttonSearch.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonSearchActionPerformed(evt);
      }
    });

    buttonClean.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
    buttonClean.setText("Clean");
    buttonClean.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCleanActionPerformed(evt);
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

    buttonErase.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
    buttonErase.setText("Erase");
    buttonErase.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonEraseActionPerformed(evt);
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
            .addComponent(labelDenomination))
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
          .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelControlLayout.setVerticalGroup(
      panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panelControlLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(labelSearch)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(labelDenomination)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textFieldDenomination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    tableWaysPay.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {

      }
    ));
    scrollPanelWaysPay.setViewportView(tableWaysPay);

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(labelTitle)
          .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollPanelWaysPay, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        .addComponent(scrollPanelWaysPay, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
    String denomination = null;
    denomination = this.textFieldDenomination.getText();
    this.loadTable(denomination);
  }//GEN-LAST:event_buttonSearchActionPerformed

  private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
    this.clean();
    this.loadTable("");
  }//GEN-LAST:event_buttonCleanActionPerformed

  private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
    RegisterWayPay view = null;
    view = new RegisterWayPay();
    view.setVisible(true);
    this.dispose();
  }//GEN-LAST:event_buttonRegisterActionPerformed

  private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
    Util util = null;
    util = new Util();
    UpdateWayPay view = null;
    byte id;
    int row;
    row = this.tableWaysPay.getSelectedRow();
    if (this.tableWaysPay.isRowSelected(row)) {
      id = this.listWaysPay.get(row).getWayPayId();
      view = new UpdateWayPay(id);
      view.setVisible(true);
      this.dispose();
    } else {
      util.showSelectRowMessage();
    }
  }//GEN-LAST:event_buttonUpdateActionPerformed

  private void buttonEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEraseActionPerformed
    byte id;
    int row;
    int result;
    Util util = null;
    SQLWayPayQuery querys = null;
    util = new Util();
    querys = new SQLWayPayQuery();
    row = this.tableWaysPay.getSelectedRow();
    if (this.tableWaysPay.isRowSelected(row)) {
      id = this.listWaysPay.get(row).getWayPayId();
      result = util.getEraseAnswer();
      if (result == JOptionPane.YES_OPTION) {
        querys.eraseWayPay(id);
        this.loadTable("");
      }
    } else {
      util.showSelectRowMessage();
    }
  }//GEN-LAST:event_buttonEraseActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonClean;
  private javax.swing.JButton buttonErase;
  private javax.swing.JButton buttonRegister;
  private javax.swing.JButton buttonSearch;
  private javax.swing.JButton buttonUpdate;
  private javax.swing.JLabel labelDenomination;
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
  private javax.swing.JScrollPane scrollPanelWaysPay;
  private javax.swing.JTable tableWaysPay;
  private javax.swing.JTextField textFieldDenomination;
  // End of variables declaration//GEN-END:variables
}
