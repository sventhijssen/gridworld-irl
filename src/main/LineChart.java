package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

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

    void draw(String name, String title, String xLabel, String yLabel) throws IOException
    {
        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel ,
                getData(),
                PlotOrientation.VERTICAL,
                true , true , false);
        File XYChart = new File(name);
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

    void setVectorData(ArrayList<Vector> wVectors)
    {
        dataset = new XYSeriesCollection();
        // For each feature
        for(int l=0; l < wVectors.get(0).length(); l++)
        {
            // Make an array list
            ArrayList<Double> wValues = new ArrayList<>();
            for(Vector wVector: wVectors)
                wValues.add(wVector.getValues()[l]);

            // Create a new XY series
            XYSeries wSeries = new XYSeries("w_" + l);

            // Each
            for(int i=0; i < wValues.size(); i++)
                wSeries.add(i, wValues.get(i));
            dataset.addSeries(wSeries);
        }
    }
}