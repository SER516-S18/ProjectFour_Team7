package edu.ser516.project4.client.controller;

import org.jfree.data.time.Millisecond;

import edu.ser516.project4.client.model.Status;
import edu.ser516.project4.client.view.expressive.ExpressiveTimeSeriesGraph;

public class ExpressiveTimeseriesController {
//  ExpressiveTimeSeriesGraph expressiveTimeseriesGraph = new ExpressiveTimeSeriesGraph("Expressive Graph");
  public static ExpressiveTimeseriesController expressiveTimeseriesControllerInstance;

  private ExpressiveTimeseriesController() {}

  public static ExpressiveTimeseriesController getInstance() {
	  if (expressiveTimeseriesControllerInstance == null) {
		  expressiveTimeseriesControllerInstance = new ExpressiveTimeseriesController();
	  }
	  return expressiveTimeseriesControllerInstance;
  }
  /**
   * update the time series data from server status for affective values
   *
   * @param status
   */
  public void updateExpressiveTimeseries(Status status) {

    // double values
    ExpressiveTimeSeriesGraph.eyebrowRaiseSeries.addOrUpdate(
        new Millisecond(), (status.getEyebrowRaise()) + 47);
    ExpressiveTimeSeriesGraph.eyebrowFurrowSeries.addOrUpdate(
        new Millisecond(), status.getEyebrowFurrow() + 43);
    ExpressiveTimeSeriesGraph.smileSeries.addOrUpdate(new Millisecond(), status.getSmile() + 39);
    ExpressiveTimeSeriesGraph.clenchSeries.addOrUpdate(new Millisecond(), status.getClench() + 35);
    ExpressiveTimeSeriesGraph.smirkLeftSeries.addOrUpdate(
        new Millisecond(), status.getSmirkLeft() + 31);
    ExpressiveTimeSeriesGraph.smirkRightSeries.addOrUpdate(
        new Millisecond(), status.getSmirkRight() + 27);
    ExpressiveTimeSeriesGraph.laughSeries.addOrUpdate(new Millisecond(), status.getLaugh() + 23);

    // Boolean values
    ExpressiveTimeSeriesGraph.blinkSeries.addOrUpdate(
        new Millisecond(), (status.getBlink() ? 1 : 0) + 19);
    ExpressiveTimeSeriesGraph.lookingLeftSeries.addOrUpdate(
        new Millisecond(), (status.getLookingLeft() ? 1 : 0) + 15);
    ExpressiveTimeSeriesGraph.lookingRightSeries.addOrUpdate(
        new Millisecond(), (status.getLookingRight() ? 1 : 0) + 11);
    ExpressiveTimeSeriesGraph.rightWinkSeries.addOrUpdate(
        new Millisecond(), (status.getRightWink() ? 1 : 0) + 7);
    ExpressiveTimeSeriesGraph.leftWinkSeries.addOrUpdate(
        new Millisecond(), (status.getLeftWink() ? 1 : 0) + 3);
  }
}
