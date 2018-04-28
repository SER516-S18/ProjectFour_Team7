package edu.ser516.project4.client.view.affective;
/**
 * Class to plot affective graph
 *
 * @author Team 7 Affective Tne Series panel
 */
import java.awt.*;

import javax.swing.*;

//import network.model.Status;
import edu.ser516.project4.client.controller.StatusController;
import edu.ser516.project4.client.view.PlotGraph;
import edu.ser516.project4.common.constants.ClientConstants;
import edu.ser516.project4.common.constants.ServerConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


public class AffectiveTimeSeriesGraph {

//  private StatusController statusController = StatusController.getInstance();

  /** The time Series data. */
  private TimeSeries interestSeries;
  private TimeSeries engagementSeries;
  private TimeSeries stressSeries;
  private TimeSeries relaxationSeries;
  private TimeSeries excitementSeries;
  private TimeSeries focusSeries;

  public static JPanel content;
  public static ChartPanel chartPanel;
  public static JFreeChart chart;

  private Color interestColor;
  private Color engagementColor;
  private Color stressColor;
  private Color relaxationColor;
  private Color excitementColor;
  private Color focusColor;
//  private Double displayLength;

  public TimeSeries getInterestSeries() {
    return interestSeries;
  }

  public void setInterestSeries(TimeSeries interestSeries) {
    this.interestSeries = interestSeries;
  }

  public TimeSeries getEngagementSeries() {
    return engagementSeries;
  }

  public void setEngagementSeries(TimeSeries engagementSeries) {
    this.engagementSeries = engagementSeries;
  }

  public TimeSeries getStressSeries() {
    return stressSeries;
  }

  public void setStressSeries(TimeSeries stressSeries) {
    this.stressSeries = stressSeries;
  }

  public TimeSeries getRelaxationSeries() {
    return relaxationSeries;
  }

  public void setRelaxationSeries(TimeSeries relaxationSeries) {
    this.relaxationSeries = relaxationSeries;
  }

  public TimeSeries getExcitementSeries() {
    return excitementSeries;
  }

  public void setExcitementSeries(TimeSeries excitementSeries) {
    this.excitementSeries = excitementSeries;
  }

  public TimeSeries getFocusSeries() {
    return focusSeries;
  }

  public void setFocusSeries(TimeSeries focusSeries) {
    this.focusSeries = focusSeries;
  }

  public Color getInterestColor() {
    return interestColor;
  }

  public void setInterestColor(Color interestColor) {
    this.interestColor = interestColor;
  }

  public Color getEngagementColor() {
    return engagementColor;
  }

  public void setEngagementColor(Color engagementColor) {
    this.engagementColor = engagementColor;
  }

  public Color getStressColor() {
    return stressColor;
  }

  public void setStressColor(Color stressColor) {
    this.stressColor = stressColor;
  }

  public Color getRelaxationColor() {
    return relaxationColor;
  }

  public void setRelaxationColor(Color relaxationColor) {
    this.relaxationColor = relaxationColor;
  }

  public Color getExcitementColor() {
    return excitementColor;
  }

  public void setExcitementColor(Color excitementColor) {
    this.excitementColor = excitementColor;
  }

  public Color getFocusColor() {
    return focusColor;
  }

  public void setFocusColor(Color focusColor) {
    this.focusColor = focusColor;
  }

//  public Double getDisplayLength() {
//    return displayLength;
//  }
//
//  public void setDisplayLength(Double displayLength) {
//    this.displayLength = displayLength;
//  }

  private static AffectiveTimeSeriesGraph affectiveTimeSeriesGraph;

  public static AffectiveTimeSeriesGraph getinstance() {
    if (affectiveTimeSeriesGraph == null) {
      affectiveTimeSeriesGraph = new AffectiveTimeSeriesGraph("Affective Graph");
    }
    return affectiveTimeSeriesGraph;
  }

  public JPanel getPanel() {
    JPanel affectiveGraph = new JPanel();
    affectiveGraph.add(content);
    return affectiveGraph;
  }

  /**
   * Constructs a new graph application.
   *
   * @param title the frame title.
   */
  public AffectiveTimeSeriesGraph(final String title) {

    // super(title);
    this.interestSeries = new TimeSeries(ClientConstants.INTEREST, Millisecond.class);
    this.engagementSeries = new TimeSeries(ClientConstants.ENGAGEMENT, Millisecond.class);
    this.stressSeries = new TimeSeries(ClientConstants.STRESS, Millisecond.class);
    this.relaxationSeries = new TimeSeries(ClientConstants.RELAXATION, Millisecond.class);
    this.excitementSeries = new TimeSeries(ClientConstants.EXCITEMENT, Millisecond.class);
    this.focusSeries = new TimeSeries(ClientConstants.FOCUS, Millisecond.class);
  //  this.displayLength = 60000.0; // 60 seconds
   // setColors();

    chart = PlotGraph.createChart(createDataSet(),true);

    chartPanel = new ChartPanel(chart);

    content = new JPanel(new BorderLayout());
    content.add(chartPanel);
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
  }

  public TimeSeriesCollection createDataSet() {
    final TimeSeriesCollection dataset = new TimeSeriesCollection();
    dataset.addSeries(this.interestSeries);
    dataset.addSeries(this.engagementSeries);
    dataset.addSeries(this.stressSeries);
    dataset.addSeries(this.relaxationSeries);
    dataset.addSeries(this.excitementSeries);
    dataset.addSeries(this.focusSeries);
    return dataset;
  }

  /**
   * Creates a time series chart.
   *
   * @param dataset the dataset.
   * @return A time series chart.
   */
//  public JFreeChart createChart(final XYDataset dataset) {
//    JFreeChart result = ChartFactory.createTimeSeriesChart("", "", "", dataset, false, true, false);
//
//    final XYPlot plot = result.getXYPlot();
//
//    plot.getRenderer().setSeriesPaint(0, ClientConstants.INTEREST_COLOR);
//    plot.getRenderer().setSeriesPaint(1, ClientConstants.ENGAGEMENT_COLOR);
//    plot.getRenderer().setSeriesPaint(2, ClientConstants.STRESS_COLOR);
//    plot.getRenderer().setSeriesPaint(3, ClientConstants.RELAXATION_COLOR);
//    plot.getRenderer().setSeriesPaint(4, ClientConstants.EXCITEMENT_COLOR);
//    plot.getRenderer().setSeriesPaint(5, ClientConstants.FOUCS_COLOR);
//
//    ValueAxis axis = plot.getDomainAxis();
//    axis.setAutoRange(true);
//    axis.setFixedAutoRange(displayLength); // 60 seconds
//    axis = plot.getRangeAxis();
//    axis.setRange(0.0, 1.0);
//    axis.setVerticalTickLabels(false);
//    axis.setTickLabelsVisible(false);
//
//    return result;
//  }

  private void setColors() {
    interestColor = ClientConstants.INTEREST_COLOR;
    engagementColor = Color.BLUE;
    stressColor = Color.GRAY;
    relaxationColor = Color.ORANGE;
    excitementColor = Color.CYAN;
    focusColor = Color.RED;
  }

  // /**
  //  * update the time series data from server status for affective values
  //  *
  //  * @param status
  //  */
  // public void update(Status status) {

  //   this.interestSeries.addOrUpdate(new Millisecond(), status.getInterest());

  //   this.engagementSeries.addOrUpdate(new Millisecond(), status.getEngagement());
  //   this.stressSeries.addOrUpdate(new Millisecond(), status.getStress());
  //   this.excitementSeries.addOrUpdate(new Millisecond(), status.getExcitement());
  //   this.relaxationSeries.addOrUpdate(new Millisecond(), status.getRelaxation());
  //   this.focusSeries.addOrUpdate(new Millisecond(), status.getFocus());
  // }

  // public void updateGraph() {
  //   content.remove(chartPanel);
  //   chart = createChart(createDataSet());
  //   chartPanel = new ChartPanel(chart);
  //   content.add(chartPanel);
  //   chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
  //   content.setVisible(true);
  // }

  }
