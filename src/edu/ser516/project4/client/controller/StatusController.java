package edu.ser516.project4.client.controller;

import edu.ser516.project4.client.model.Status;

public class StatusController {
	private static StatusController statusControllerInstance = null;
	
	Status statusInstance = Status.getInstance();

	public static StatusController getInstance() {
		if (statusControllerInstance == null) {
			statusControllerInstance = new StatusController();
		}
		return statusControllerInstance;
	}
	
	public Status getStatusInstance() {
		return statusInstance;
	}

}
