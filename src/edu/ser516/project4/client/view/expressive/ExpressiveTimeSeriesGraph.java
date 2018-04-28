package edu.ser516.project4.client.view.expressive;

import edu.ser516.project4.common.constants.ClientConstants;
import edu.ser516.project4.client.model.Status;
import edu.ser516.project4.client.view.PlotGraph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Class to plot affective graph
 *
 * @author Team 7
 */

public class ExpressiveTimeSeriesGraph {

  /** The time Series data. */
  public static TimeSeries lookingRightSeries;
  public static TimeSeries eyebrowRaiseSeries;
  public static TimeSeries lookingLeftSeries;
  public static TimeSeries clenchSeries;
  public static TimeSeries rightWinkSeries;
  public static TimeSeries leftWinkSeries;
  public static TimeSeries blinkSeries;
  public static TimeSeries smileSeries;
  public static TimeSeries eyebrowFurrowSeries;
  public static TimeSeries smirkLeftSeries;
  public static TimeSeries smirkRightSeries;
  public static TimeSeries laughSeries;
  static JPanel content;
  private static ExpressiveTimeSeriesGraph expTimeSeriesGraph;

  public static ExpressiveTimeSeriesGraph getinstance() {
	    if (expTimeSeriesGraph == null) {
	      expTimeSeriesGraph = new ExpressiveTimeSeriesGraph("Expressive Graph");
	    }
	    return expTimeSeriesGraph;
	  }

	  public JPanel getPanel() {
	    JPanel expressiveGraph = new JPanel();

	    // JLabel instructions = new JLabel("Graph displaying affective data", JLabel.CENTER);
	    expressiveGraph.add(content);

	    return expressiveGraph;
	  }

  /**
   * Constructs a new graph application.
   *
   * @param title the frame title.
   */
  public ExpressiveTimeSeriesGraph(final String title) {

    this.eyebrowRaiseSeries = new TimeSeries(ClientConstants.EYEBROW_RAISE, Millisecond.class);
    this.eyebrowFurrowSeries = new TimeSeries(ClientConstants.EYEBROW_FURROW, Millisecond.class);
    this.smileSeries = new TimeSeries(ClientConstants.SMILE, Millisecond.class);
    this.clenchSeries = new TimeSeries(ClientConstants.CLENCH, Millisecond.class);
    this.smirkLeftSeries = new TimeSeries(ClientConstants.SMIRK_LEFT, Millisecond.class);
    this.smirkRightSeries = new TimeSeries(ClientConstants.SMIRK_RIGHT, Millisecond.class);
    this.laughSeries = new TimeSeries(ClientConstants.LAUGH, Millisecond.class);
    this.blinkSeries = new TimeSeries(ClientConstants.BLINK, Millisecond.class);
    this.lookingLeftSeries = new TimeSeries(ClientConstants.LOOKING_LEFT, Millisecond.class);
    this.lookingRightSeries = new TimeSeries(ClientConstants.LOOKING_RIGHT, Millisecond.class);
    this.rightWinkSeries = new TimeSeries(ClientConstants.RIGHT_WINK, Millisecond.class);
    this.leftWinkSeries = new TimeSeries(ClientConstants.LEFT_WINK, Millisecond.class);
    final TimeSeriesCollection dataset = new TimeSeriesCollection();
  
    final JFreeChart chart = PlotGraph.createChart(createDataSet(),false);

    final ChartPanel chartPanel = new ChartPanel(chart);

    content = new JPanel(new BorderLayout());
    content.add(chartPanel);
    chartPanel.setPreferredSize(new java.awt.Dimension(400, 500));
  }

  public TimeSeriesCollection createDataSet() {
	    final TimeSeriesCollection dataset = new TimeSeriesCollection();
	    dataset.addSeries(this.eyebrowRaiseSeries);
	    dataset.addSeries(this.eyebrowFurrowSeries);
	    dataset.addSeries(this.smileSeries);
	    dataset.addSeries(this.clenchSeries);
	    dataset.addSeries(this.smirkLeftSeries);
	    dataset.addSeries(this.smirkRightSeries);
	    dataset.addSeries(this.laughSeries);
	    dataset.addSeries(this.blinkSeries);
	    dataset.addSeries(this.lookingLeftSeries);
	    dataset.addSeries(this.lookingRightSeries);
	    dataset.addSeries(this.rightWinkSeries);
	    dataset.addSeries(this.leftWinkSeries);

	    return dataset;
	  }
  /**
   * Creates a time series chart.
   *
   * @param dataset the dataset.
   * @return A time series chart.
   */
//  private JFreeChart createChart(final XYDataset dataset) {
//    final JFreeChart result =
//        ChartFactory.createTimeSeriesChart("", "", "", dataset, true, true, false);
//    final XYPlot plot = result.getXYPlot();
//    ValueAxis axis = plot.getDomainAxis();
//    axis.setAutoRange(true);
//    axis.setFixedAutoRange(60000.0); // 60 seconds
//    axis = plot.getRangeAxis();
//    axis.setRange(0.0, 50);
//    axis.setVerticalTickLabels(false);
//    axis.setTickLabelsVisible(false);
//    plot.setDomainGridlinesVisible(false);
//    plot.setRangeGridlinesVisible(false);
//    axis.setVisible(false);
//    axis.setTickLabelPaint(Color.WHITE);
//
//    axis = plot.getRangeAxis();
//    axis.setVisible(false);
//    axis.setTickLabelsVisible(false);
//    axis.setTickLabelPaint(Color.WHITE);
//    return result;
//  }

  
  // /**
  //  * update the time series data from server status for affective values
  //  *
  //  * @param status
  //  */
  // public void update(Status status) {

  //   // double values
  //   this.eyebrowRaiseSeries.addOrUpdate(new Millisecond(), (status.getEyebrowRaise()) + 47);
  //   this.eyebrowFurrowSeries.addOrUpdate(new Millisecond(), status.getEyebrowFurrow() + 43);
  //   this.smileSeries.addOrUpdate(new Millisecond(), status.getSmile() + 39);
  //   this.clenchSeries.addOrUpdate(new Millisecond(), status.getClench() + 35);
  //   this.smirkLeftSeries.addOrUpdate(new Millisecond(), status.getSmirkLeft() + 31);
  //   this.smirkRightSeries.addOrUpdate(new Millisecond(), status.getSmirkRight() + 27);
  //   this.laughSeries.addOrUpdate(new Millisecond(), status.getLaugh() + 23);

  //   // Boolean values
  //   this.blinkSeries.addOrUpdate(new Millisecond(), (status.getBlink() ? 1 : 0) + 19);
  //   this.lookingLeftSeries.addOrUpdate(new Millisecond(), (status.getLookingLeft() ? 1 : 0) + 15);
  //   this.lookingRightSeries.addOrUpdate(new Millisecond(), (status.getLookingRight() ? 1 : 0) + 11);
  //   this.rightWinkSeries.addOrUpdate(new Millisecond(), (status.getRightWink() ? 1 : 0) + 7);
  //   this.leftWinkSeries.addOrUpdate(new Millisecond(), (status.getLeftWink() ? 1 : 0) + 3);
  // }

}
