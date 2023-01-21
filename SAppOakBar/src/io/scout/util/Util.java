package io.scout.util;

import javax.swing.JFrame;

public class Util {

  public void initView(JFrame view) {
    view.setTitle(Tag.TITLE.toString());
    view.setResizable(false);
    view.setLocationRelativeTo(null);
  }
}
