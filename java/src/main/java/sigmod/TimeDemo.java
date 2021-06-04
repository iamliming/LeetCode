package sigmod;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 10月 29, 2020]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TimeDemo
{


    public double sinF(double alpha, double gama, double x){
        double result = alpha*gama*Math.sin(x);
        return result;
    }

    public static void main(String[] args)
    {
        XYSeries series = new XYSeries("xySeries");
//        for (double x = -80; x < 80; ) {
//            double y = logistic.logistic(alpha, beta, gama, x);
//            double y1 = logistic.sinF(alpha,0.1,x);
//            series.add(x, y+y1);
//            x += 1;
//        }
        //        for (double x = 0; x < 20; ) {
        //            //            double y = logistic.gompertz(alpha, beta, gama, x);
        //            //            System.out.println(point1);
        //            //            double y = logistic.sin(x, a1, b1, c1, a2, b2, c2, a3, b3, c3);
        //            double y = logistic.tansigmoid(x);
        //            series.add(x, y);
        //            x += 0.01;
        //        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
            "y = logistic", // chart title
            "x", // x axis label
            "logistic", // y axis label
            dataset, // data
            PlotOrientation.VERTICAL,
            false, // include legend
            false, // tooltips
            false // urls
        );

        ChartFrame frame = new ChartFrame("my picture", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
