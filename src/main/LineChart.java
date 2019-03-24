package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

// Based on: https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
public class LineChart
{
    private int width;
    private int height;
    private XYSeriesCollection dataset = new XYSeriesCollection( );
    public LineChart(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    void draw() throws IOException
    {
        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                "Error between expert feature expectation and learned feature expectation" ,
                "iteration" ,
                "t" ,
                getData(),
                PlotOrientation.VERTICAL,
                true , true , false);
        File XYChart = new File("XYLineChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( XYChart, xyLineChart, width, height);
    }

    private XYDataset getData()
    {
        return this.dataset;
    }

    /**
     * Sets the values of t for each iteration.
     * @param tValues
     */
    void setData(ArrayList<Double> tValues)
    {
        final XYSeries tSeries = new XYSeries( "t" );
        for(int i=0; i < tValues.size(); i++)
            tSeries.add(i, tValues.get(i));
        dataset = new XYSeriesCollection();
        dataset.addSeries(tSeries);
    }
}