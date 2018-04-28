package edu.ser516.project4.client.view.affective;

import javax.swing.*;

/**
 * @author Team 7
 * Affective Tab panel
 * */
public class AffectiveTab {

  /**
   * Affective panel
   * @return JPanel
   */
  public static JPanel getPanel() {
    JPanel affectiveTabPanel = new JPanel();
    affectiveTabPanel.add(AffectiveTimeSeriesGraph.getinstance().getPanel());

    return affectiveTabPanel;
  }
}
