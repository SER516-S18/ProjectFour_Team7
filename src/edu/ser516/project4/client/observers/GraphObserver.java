package edu.ser516.project4.client.observers;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.ser516.project4.client.model.Status;
import edu.ser516.project4.client.model.StatusObservable;
import edu.ser516.project4.client.controller.AffectiveTimeSeriesController;
import edu.ser516.project4.client.controller.ExpressiveTimeseriesController;

/** @author Team 7
 * Observer for graph data
 * */
public class GraphObserver implements Observer {
  private static GraphObserver graphObserverInstance = null;

  /**
   * GraphObserver singleton instance
   * @return GraphObserver graphObserverInstance
   */
  public static GraphObserver getInstance() {
    if (graphObserverInstance == null) {
      graphObserverInstance = new GraphObserver();
    }
    return graphObserverInstance;
  }

  /**
   * Updates the graph status data
   * @param observable
   * @param arg
   */
  @Override
  public void update(Observable observable, Object arg) {
    ArrayList<Status> statusContainer = StatusObservable.getObserverInstance().getStatusContainer();
    Status status = statusContainer.get(statusContainer.size() - 1);

    AffectiveTimeSeriesController.getinstance().updateGraph();
    ExpressiveTimeseriesController.getInstance().updateExpressiveTimeseries(status);
  }
}
