package edu.ser516.project4.server.controller;

import javax.websocket.DeploymentException;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;

import edu.ser516.project4.client.model.Status;
import edu.ser516.project4.server.view.components.Console;

import static edu.ser516.project4.common.constants.NetworkConstants.ROOT_PATH;

import edu.ser516.project4.server.model.Connection;

public class ServerConnectionController {
	private static org.glassfish.tyrus.server.Server server;

	  private static ServerConnectionController serverInstance;
	  public static boolean isServerUp = false;

	  private ServerConnectionController() {}

	  public static ServerConnectionController getInstance() {
	    if (serverInstance == null) {
	      serverInstance = new ServerConnectionController();
	    }
	    return serverInstance;
	  }

	/*public static void initializeConnection() {
		ServerConnectionController.getInstance().start(NetworkConstants.HOST, NetworkConstants.PORT);
	}*/

	/**
	   * Starts server under the given host and port
	   *
	   * @param host ip address of the server
	   * @param port server port
	   */
	  public void start(String host, int port) {
	    try {
	      server = new org.glassfish.tyrus.server.Server(host, port, "/" + ROOT_PATH, ServerEndpoint.class);
//        isServerUp = true;
	      server.start();
	    } catch (DeploymentException e) {
	      e.printStackTrace();
	    } catch (Exception ex) {
	      System.out.println("Server is already in use");
	    }
	  }

	  /** Stops the server */
	  public void stop() {
	    server.stop();
	  }

	  /**
	   * Gets the number of clients connected
	   *
	   * @return number of connections
	   */
	  public int numConnections() {
	    return ServerEndpoint.peers.size();
	  }

	  /**
	   * Sends a status object of the websocket
	   *
	   * @param status status object to be sent
	   */
	  public void sendStatus(Status status) {
	    for (Session peer : ServerEndpoint.peers) {
	      try {
	        peer.getBasicRemote().sendObject(status);
	        Console.setMessage("Data Sent to ClientConnectionController");
	      } catch (IOException | EncodeException e) {
	        Console.setErrorMessage("Error while sending data to client");
	        e.printStackTrace();
	      }
	    }
	  }

  public String getHost() {
    return Connection.getInstance().getHost();
  }

  public int getPort() {
    return Connection.getInstance().getPort();
  }
}
