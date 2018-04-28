package edu.ser516.project4.server.view;

import java.awt.*;
import javax.swing.*;

import edu.ser516.project4.server.controller.ServerConnectionController;

import edu.ser516.project4.server.view.components.Console;
import edu.ser516.project4.server.view.components.ServerCommand;
import edu.ser516.project4.server.view.components.AttributeContainer;

import static edu.ser516.project4.common.constants.NetworkConstants.HOST;
import static edu.ser516.project4.common.constants.NetworkConstants.PORT;

/**
 * @author Team 7
 * Server view to create server frame
 */
public class Server {
  public static Server serverViewInstance;
  public static JFrame serverView;
  public static boolean isServerUp;

  /**
   * Add server components to Server Frame
   * @param Container contentPane
   */
  private static void addComponentsToPane(Container contentPane) {
    contentPane.setLayout(new BorderLayout(5, 5));
    contentPane.setBackground(Color.decode("#C5E0D8"));
    contentPane.add(ServerCommand.getPanel(), BorderLayout.PAGE_START);
    contentPane.add(AttributeContainer.getPanel(), BorderLayout.CENTER);
    contentPane.add(Console.getConsolePanel(), BorderLayout.PAGE_END);
  }

  public static Server getInstance() {
    if (serverViewInstance == null) {
      serverViewInstance = new Server();
    }
    isServerUp = true;
    return serverViewInstance;
  }

  /**
   * Creates server Frame
   * @return JFrame ServerGUI
   */
  public JFrame createAndShowServerGUI() {

    if (serverView == null) {
      JFrame.setDefaultLookAndFeelDecorated(true);
      serverView = new JFrame("Project 3 Team 7 - EmoComposer");
      //      serverView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      // set up the content pane and add swing components to it
      addComponentsToPane(serverView.getContentPane());
      serverView.setPreferredSize(new Dimension(1000, 800));
      serverView.pack();
      serverView.setResizable(false);
    }
    return serverView;
  }

  /**
   * Server main
   * @param args
   */
  public static void initializeServerGUI() {
    ServerConnectionController server = ServerConnectionController.getInstance();
    Server serverViewInstance = Server.getInstance();
    server.start(HOST, PORT);
    JFrame serverFrame = serverViewInstance.createAndShowServerGUI();
    serverFrame.setVisible(true);
    Console.setMessage("Server is ready");
  }
}
