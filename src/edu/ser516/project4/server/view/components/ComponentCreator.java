package edu.ser516.project4.server.view.components;

import javax.swing.*;
import java.awt.*;

public class ComponentCreator {

  public static JLabel createLabels(String name, int x_axis, int y_axis, int width, int height) {
    JLabel newLabel = new JLabel(name);
    newLabel.setBounds(x_axis, y_axis, width, height);
    newLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    return newLabel;
  }

  public static JTextField createTimeTextField(
      int x_axis, int y_axis, int width, int height, int column) {
    JTextField newTextField = new JTextField();
    newTextField.setBounds(x_axis, y_axis, width, height);
    newTextField.setColumns(column);
    return newTextField;
  }

  public static JSpinner createSpinners(
      String name, int x_axis, int y_axis, int width, int height) {
    JSpinner newSpinner = new JSpinner();
    newSpinner.setName(name);
    newSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor SpinnerEdit = new JSpinner.NumberEditor(newSpinner);
    newSpinner.setEditor(SpinnerEdit);
    newSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    newSpinner.setBounds(x_axis, y_axis, width, height);
    return newSpinner;
  }

  public static JComboBox createComboBoxes(
      String[] options, int x_axis, int y_axis, int width, int height) {
    JComboBox newComboBox = new JComboBox();
    newComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    newComboBox.setModel(new DefaultComboBoxModel(options));
    newComboBox.setBounds(x_axis, y_axis, width, height);
    newComboBox.setBackground(Color.WHITE);
    return newComboBox;
  }

  public static JToggleButton createButton(
      String name, int x_axis, int y_axis, int width, int height) {
    JToggleButton newButton = new JToggleButton(name);
    newButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    newButton.setBounds(x_axis, y_axis, width, height);
    return newButton;
  }

  public static JCheckBox createAutoResetCheckBox(
      String name, int x_axis, int y_axis, int width, int height) {
    JCheckBox newCheckBox = new JCheckBox(name);
    newCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    newCheckBox.setBounds(x_axis, y_axis, width, height);
    return newCheckBox;
  }
}
