package edu.ser516.project4.client.controller;

import edu.ser516.project4.client.view.Client;
import edu.ser516.project4.server.controller.ServerConnectionController;
import edu.ser516.project4.server.controller.ServerController;

public class ClientController {
	public static void initializeGUI() {
		Client.initializeGUI();
	}
	
	public static void initializeConnection() {
		ServerConnectionController.getInstance();
	}

	public static void initializeServer() {
		ServerController.initializeServer();
	}
}
