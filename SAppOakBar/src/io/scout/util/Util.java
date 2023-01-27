package io.scout.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Util {

  /*configurations for frames, tables and others components*/
  public void initView(JFrame view) {
    view.setTitle(Tag.TITLE.toString());
    view.setResizable(false);
    view.setLocationRelativeTo(null);
  }

  private DefaultTableModel getDefaultTableModel() {
    DefaultTableModel defaultTableModel = null;
    defaultTableModel = new DefaultTableModel() {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    return defaultTableModel;
  }

  public DefaultTableModel getDefaultTableModel(JTable table) {
    DefaultTableModel defaultTableModel = null;
    TableModel tableModel = null;
    tableModel = table.getModel();
    defaultTableModel = DefaultTableModel.class.cast(tableModel);
    return defaultTableModel;
  }

  private void configDefaultTableModel(DefaultTableModel defaultTableModel, String[] headers) {
    for (int index = 0; index < headers.length; index++) {
      defaultTableModel.addColumn(headers[index]);
    }
  }

  public void configTable(JTable table, String[] headers) {
    DefaultTableModel defaultTableModel = this.getDefaultTableModel();
    this.configDefaultTableModel(defaultTableModel, headers);
    table.getTableHeader().setReorderingAllowed(false);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.setModel(defaultTableModel);
  }

  public int getEraseAnswer() {
    int result;
    result = JOptionPane.showConfirmDialog(
      null,
      Tag.MESSAGE_QUESTION_ERASE.toString(),
      Tag.TITLE_WARNING.toString(),
      JOptionPane.WARNING_MESSAGE
    );
    return result;
  }

  public void showSuccessMessage() {
    JOptionPane.showMessageDialog(
      null,
      Tag.MESSAGE_OPERATION_SUCCESSFUL.toString(),
      Tag.TITLE_SUCCESS.toString(),
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  public void showErrorMessage() {
    JOptionPane.showMessageDialog(
      null,
      Tag.MESSAGE_OPERATION_FAILED.toString(),
      Tag.TITLE_ERROR.toString(),
      JOptionPane.ERROR_MESSAGE
    );
  }

  public void showEmptyFieldMessage() {
    JOptionPane.showMessageDialog(
      null,
      Tag.MESSAGE_EMPTY_FIELD.toString(),
      Tag.TITLE_WARNING.toString(),
      JOptionPane.WARNING_MESSAGE
    );
  }

  public void showSelectRowMessage() {
    JOptionPane.showMessageDialog(
      null,
      Tag.MESSAGE_SELECT_ROW.toString(),
      Tag.TITLE_WARNING.toString(),
      JOptionPane.WARNING_MESSAGE
    );
  }
}
