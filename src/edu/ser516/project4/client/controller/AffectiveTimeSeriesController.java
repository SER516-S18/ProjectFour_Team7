package edu.ser516.project4.client.controller;

import org.jfree.chart.ChartPanel;
import org.jfree.data.time.Millisecond;

import edu.ser516.project4.client.model.Status;
import edu.ser516.project4.client.view.PlotGraph;
import edu.ser516.project4.client.view.affective.AffectiveTimeSeriesGraph;

public class AffectiveTimeSeriesController {
  AffectiveTimeSeriesGraph affectiveTimeSeriesGraphInstance =
      AffectiveTimeSeriesGraph.getinstance();

  private AffectiveTimeSeriesController() {}

  private static AffectiveTimeSeriesController affectiveTimeSeriesController;

  public static AffectiveTimeSeriesController getinstance() {
    if (affectiveTimeSeriesController == null) {
      affectiveTimeSeriesController = new AffectiveTimeSeriesController();
    }
    return affectiveTimeSeriesController;
  }

  /**
   * update the time series data from server status for affective values
   *
   * @param status
   */
  public void updateAffectiveTimeseries(Status statusInstance) {
    affectiveTimeSeriesGraphInstance
        .getInterestSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getInterest());
    affectiveTimeSeriesGraphInstance
        .getEngagementSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getEngagement());
    affectiveTimeSeriesGraphInstance
        .getStressSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getStress());
    affectiveTimeSeriesGraphInstance
        .getExcitementSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getExcitement());
    affectiveTimeSeriesGraphInstance
        .getRelaxationSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getRelaxation());
    affectiveTimeSeriesGraphInstance
        .getFocusSeries()
        .addOrUpdate(new Millisecond(), statusInstance.getFocus());
  }

  public void updateGraph() {
    AffectiveTimeSeriesGraph.content.remove(AffectiveTimeSeriesGraph.chartPanel);
    AffectiveTimeSeriesGraph.chart =
        PlotGraph.createChart(
            affectiveTimeSeriesGraphInstance.createDataSet(),
            true); // affectiveTimeSeriesGraphInstance.createChart(affectiveTimeSeriesGraphInstance.createDataSet());
    AffectiveTimeSeriesGraph.chartPanel = new ChartPanel(AffectiveTimeSeriesGraph.chart);
    AffectiveTimeSeriesGraph.content.add(AffectiveTimeSeriesGraph.chartPanel);
    AffectiveTimeSeriesGraph.chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
    AffectiveTimeSeriesGraph.content.setVisible(true);
  }
}
