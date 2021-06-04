package sigmod;

import java.util.Scanner;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * 构建机器人，曲线
 *
 * @author liming
 * @version [版本号, 10月 29, 2020]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LogisticDemo
{

    public double gompertz(double alpha, double beta, double gama, double x){

        double result = alpha*(Math.exp((-1)*Math.exp(beta-gama*x)));
        //        double result = alpha/((1+Math.exp(beta-gama*x))^(1/);
        return result;
    }
    public double sin(double max, double mu, double x){
        double result = max*Math.sin(mu*x);
        return result;
    }
    public double tansigmoid(double x){
        double rst = 2/(1+Math.exp(-2*x)) - 1;
        return rst;
    }
    /**
     * S型逻辑曲线
     * @param alpha
     * @param beta
     * @param gama
     * @param x
     * @return
     */
    public double logistic(double alpha, double beta, double gama, double x, int maxTime){
        if(x > maxTime){
            x = 2*maxTime-x;
        }
        double result = alpha/(1+Math.exp(beta-gama*x));
        return result;
    }
    public static void main(String[] args)
    {
//        System.out.println(Math.log(1));
//        System.out.println(Math.exp(Math.log(1)));
//        System.out.println(Math.exp(-5));
//        System.out.println(1/(1+Math.exp((-1)*Math.log(150))));

        LogisticDemo logistic = new LogisticDemo();

        XYSeries series = new XYSeries("xySeries");
        double alpha = 1000;
        double beta =4;
        double gama = 8d/3600;
        int maxTime = 3600;
        double scaleMax = alpha*0.1;
        double mu = 2*Math.PI * (1d/120);
        double min = 10;

        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);
        System.out.println("alpha 最高机器人数(数字）：");
        alpha = scan.nextDouble();
        System.out.println("maxTime 最大时间(秒数）：");
        maxTime = scan.nextInt();
        gama = 8d/maxTime;
        System.out.println("scaleMax 最大振荡幅度(小数0.xxx格式）：");
        scaleMax = alpha*scan.nextDouble();
        System.out.println(scaleMax);
        System.out.println(" 振荡周期(秒）：");
        mu = 2*Math.PI * (1/scan.nextDouble());
        System.out.println(mu);
        System.out.println(" 结束前最小人数：");
        min = scan.nextDouble();


        for (double x = 0; x < 10800; x++) {
            double y = logistic.logistic(alpha, beta, gama, x, maxTime);
            y += logistic.sin(scaleMax,mu, x);
            if(x<maxTime && y<0){
                y=0;
            }
            if(x>maxTime && y<min){
                y = min;
            }
            series.add(x, y);
        }
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

        while (true){
            System.out.println("输入时间点(秒)");
            double x = scan.nextDouble();
            double y = logistic.logistic(alpha, beta, gama, x, maxTime);
            y += logistic.sin(scaleMax,mu, x);
            if(x<maxTime && y<0){
                y=0;
            }
            if(x>maxTime && y<min){
                y = min;
            }
            System.out.println("当前人数为："+y);
        }
    }
}
