package edu.ser516.project4.client.view;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import edu.ser516.project4.client.view.affective.AffectiveTimeSeriesGraph;
import edu.ser516.project4.client.view.expressive.ExpressiveTimeSeriesGraph;
import edu.ser516.project4.common.constants.ClientConstants;

public class PlotGraph {


	public static JFreeChart createChart(final XYDataset dataset, boolean colorFlag) {


		JFreeChart result = ChartFactory.createTimeSeriesChart("", "", "", dataset, false, true, false);

		final XYPlot plot = result.getXYPlot();

		if(colorFlag) {

			plot.getRenderer().setSeriesPaint(0, ClientConstants.INTEREST_COLOR);
			plot.getRenderer().setSeriesPaint(1, ClientConstants.ENGAGEMENT_COLOR);
			plot.getRenderer().setSeriesPaint(2, ClientConstants.STRESS_COLOR);
			plot.getRenderer().setSeriesPaint(3, ClientConstants.RELAXATION_COLOR);
			plot.getRenderer().setSeriesPaint(4, ClientConstants.EXCITEMENT_COLOR);
			plot.getRenderer().setSeriesPaint(5, ClientConstants.FOUCS_COLOR);

		}
		ValueAxis axis = plot.getDomainAxis();
		axis.setAutoRange(true);
		axis.setFixedAutoRange(ClientConstants.DISPLAY_LENGTH); // 60 seconds
		axis = plot.getRangeAxis();
		if(colorFlag)
			axis.setRange(ClientConstants.AFFECTIVE_LOWER_RANGE, ClientConstants.AFFECTIVE_HIGHER_RANGE);
		else
			axis.setRange(ClientConstants.EXPRESSIVE_LOWER_RANGE, ClientConstants.EXPRESSIVE_HIGHER_RANGE);
		axis.setVerticalTickLabels(false);
		axis.setTickLabelsVisible(false);

		return result;
	}

	//	 public static JFreeChart createChart(ExpressiveTimeSeriesGraph expressiveGraph) {
	//		    final JFreeChart result =
	//		        ChartFactory.createTimeSeriesChart("", "", "", expressiveGraph.createDataSet(), true, true, false);
	//		    final XYPlot plot = result.getXYPlot();
	//		    ValueAxis axis = plot.getDomainAxis();
	//		    axis.setAutoRange(true);
	//		    axis.setFixedAutoRange(60000.0); // 60 seconds
	//		  
	//		    axis = plot.getRangeAxis();
	//		    axis.setRange(0.0, 50);
	//		    axis.setVerticalTickLabels(false);
	//		    axis.setTickLabelsVisible(false);
	//		    plot.setDomainGridlinesVisible(false);
	//		    plot.setRangeGridlinesVisible(false);
	//		    axis.setVisible(false);
	//		    axis.setTickLabelPaint(Color.WHITE);
	//
	//		    axis = plot.getRangeAxis();
	//		    axis.setVisible(false);
	//		    axis.setTickLabelsVisible(false);
	//		    axis.setTickLabelPaint(Color.WHITE);
	//		    return result;
	//		  }


}
